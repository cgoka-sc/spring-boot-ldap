package com.ldap.demo.springldapdemo.data;

import javax.naming.Name;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

@Entry(objectClasses = {"top", "person", "organizationalPerson", "inetOrgPerson"})
public class LdapEntry {
    @Id
    private Name dn;

    @Attribute(name = "cn")
    private String cn;

    @Attribute(name = "sn")
    private String sn;

    @Attribute(name = "uid")
    private String uid;

    @Attribute(name = "empoyeeNumber")
    private String empoyeeNumber;

    @Attribute(name = "empoyeeEmail")
    private String empoyeeEmail;

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEmpoyeeNumber() {
        return empoyeeNumber;
    }

    public void setEmpoyeeNumber(String empoyeeNumber) {
        this.empoyeeNumber = empoyeeNumber;
    }

    public String getEmpoyeeEmail() {
        return empoyeeEmail;
    }

    public void setEmpoyeeEmail(String empoyeeEmail) {
        this.empoyeeEmail = empoyeeEmail;
    }
}
