package org.example.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.example.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Name;

@RestController
public class LdapController {

    @Autowired
    LdapTemplate ldapTemplate;

    @GetMapping("/test")
    public void test() {
        String username = "admin";
        String password = "fajri";
        Name dn = LdapNameBuilder
                .newInstance()
                .add("dc","internal")
                .add("dc","compute")
                .add("dc","ap-southeast-1")
                .add("cn", username)
                .add("ou", "users")
                .build();
        DirContextAdapter context = new DirContextAdapter(dn);

        context.setAttributeValues(
                "objectclass",
                new String[]
                        { "top",
                                "person",
                                "organizationalPerson",
                                "inetOrgPerson" });
        context.setAttributeValue("cn", username);
        context.setAttributeValue("sn", username);
        context.setAttributeValue
                ("userPassword", DigestUtils.sha256Hex(password));
        ldapTemplate.bind(context);
        org.jhpster.example.model.Book book = new org.jhpster.example.model.Book();
    }

    public void authenticate(String username,String password){
    }

    public void testModel(Book book) {

    }

}
