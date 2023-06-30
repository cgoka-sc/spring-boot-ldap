package com.ldap.demo.springldapdemo.repo;

import com.ldap.demo.springldapdemo.data.LdapEntry;
import org.springframework.data.ldap.repository.LdapRepository;

public interface LdapEntryRepository extends LdapRepository<LdapEntry> {
    LdapEntry findByUid(String uid);
}
