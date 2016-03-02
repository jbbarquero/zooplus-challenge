package com.josemorenoesteban.zooplus.challenge;

import com.josemorenoesteban.zooplus.challenge.domain.ExchangeRate;
import com.josemorenoesteban.zooplus.challenge.service.exchangerate.ExchangeRateAdaptor;
import static org.springframework.context.annotation.ComponentScan.Filter;
import static org.springframework.orm.jpa.vendor.Database.H2;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Es la clase de configuración de la aplicación de srping.
 * 
 * Aquí se definirían beans (como un datasource, los que no son auto escaneados, etc)
 * Como hace un ComponentScan el carga todos los que se encuentre.
 * 
 * Es equivalente a /WEB-INF/spring-core-config.xml
 *
 * @author jbeneito
 * @author jomoespe
 */
@Configuration
@ComponentScan(basePackageClasses=ApplicationConfiguration.class, 
    excludeFilters={
        @Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class),
        @Filter(type=FilterType.ANNOTATION, value=Controller.class)
    }
)
@EnableJpaRepositories(basePackages = {"com.josemorenoesteban.zooplus.challenge.domain"})
public class ApplicationConfiguration {
    @Bean
    public EmbeddedDatabase dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2);
        EmbeddedDatabase database = builder.setName("testdb").build();
        return database;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(H2);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);
        return adapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(dataSource());
        emfb.setJpaVendorAdapter(jpaVendorAdapter());
        emfb.setPackagesToScan(ExchangeRate.class.getPackage().getName());
        return emfb;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
