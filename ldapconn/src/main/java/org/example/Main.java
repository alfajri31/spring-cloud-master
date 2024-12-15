package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

@SpringBootApplication
public class Main {

    public LdapTemplate ldapTemplate;

    @Autowired
    private Environment env;

    @Bean
    public LdapContextSource contextSource() {
        LdapContextSource contextSource = new LdapContextSource();
        contextSource.setUrl(env.getRequiredProperty("spring.ldap.urls"));
        contextSource.setUserDn(
                env.getRequiredProperty("spring.ldap.username"));
        contextSource.setPassword(
                env.getRequiredProperty("spring.ldap.password"));
        return contextSource;
    }

    @Bean
    public LdapTemplate ldapTemplate() {
        return new LdapTemplate(contextSource());
    }


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
