package com.ldap.demo.springldapdemo;

import com.ldap.demo.springldapdemo.data.LdapEntry;
import com.ldap.demo.springldapdemo.repo.LdapEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    private final LdapEntryRepository ldapEntryRepository;

    @Autowired
    public HomeController(LdapEntryRepository ldapEntryRepository) {
        this.ldapEntryRepository = ldapEntryRepository;
    }

    @GetMapping("/")
    public String hello(Authentication authentication) {
        System.out.println("getPrincipal" + authentication.getDetails());
        System.out.println(" toString : " + authentication.toString());
        String uid = authentication.getName();
        LdapEntry ldapEntry = ldapEntryRepository.findByUid(uid);

        if (ldapEntry != null) {
            return generateToken(ldapEntry);

        } else {
            System.out.println("LDAP entry not found for UID: " + uid);
        }

        return "Hello Ldap entry not found";
    }

    public String generateToken(LdapEntry ldapEntry) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, ldapEntry.getEmpoyeeEmail());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS512, "sample").compact();
    }
}
