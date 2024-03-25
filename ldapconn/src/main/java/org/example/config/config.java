package org.example.config;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.support.LdapNameBuilder;

import javax.annotation.PostConstruct;
import javax.naming.Name;

@Configuration
public class config implements InitializingBean{

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
