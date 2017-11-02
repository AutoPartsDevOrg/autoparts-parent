package com.jxd.autoparts.common.config.db;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by qijianquan on 2016/1/25.
 */

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages="${datasource.jdbc.entityPackage}")
@EnableJpaRepositories(basePackages="${datasource.jdbc.package}",
        entityManagerFactoryRef="entityManagerFactory",transactionManagerRef="transactionManager")
public class JdbcEntityManager {

    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    private DataSource dataSource;

    @Value("${datasource.jdbc.entityPackage}")
    private String entityPackage;

    
    //@PersistenceContext(type = PersistenceContextType.TRANSACTION)
    @Bean(name = "entityManager")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactory(builder).getObject().createEntityManager();
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory (EntityManagerFactoryBuilder builder) {
    	return builder
                .dataSource(dataSource)
                .properties(getVendorProperties(dataSource))
                .packages(entityPackage) //设置实体类所在位置
                .persistenceUnit("datasource-jdbc")
                .build();
    }

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

    @Bean(name = "transactionManager")
    PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
        //return new JpaTransactionManager(entityManagerFactory(builder).getObject());
    	JpaTransactionManager tm = new JpaTransactionManager();
        tm.setEntityManagerFactory(entityManagerFactory(builder).getObject());
        tm.setDataSource(dataSource);
        return tm;
    }

}
