package org.jhpster.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.sql.Types;


//public class HibernateCustomDialect extends org.hibernate.dialect.PostgreSQL94Dialect {
//    private static final Logger log = LoggerFactory.getLogger(HibernateCustomDialect.class);
//
//
//    public HibernateCustomDialect() {
//        super();
//        log.info("Registering Custom Hibernate Dialect - {}",HibernateCustomDialect.class.getName());
//        this.registerHibernateType(Types.ARRAY, CustomStringArrayType.class.getName());
//    }
//}