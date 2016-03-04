package com.josemorenoesteban.zooplus.challenge;

import static org.springframework.context.annotation.ComponentScan.Filter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Es la clase de configuración de la aplicación de Spring.
 * 
 * Aquí se definirían beans (como un datasource, los que no son auto escaneados, etc)
 * Como hace un ComponentScan el carga todos los que se encuentre.
 * 
 * Es equivalente a /WEB-INF/spring-core-config.xml
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
}
