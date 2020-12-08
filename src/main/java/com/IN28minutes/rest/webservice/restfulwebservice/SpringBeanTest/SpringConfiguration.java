package com.IN28minutes.rest.webservice.restfulwebservice.SpringBeanTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    @Bean
    public SpringBeanMethodClass testMethod(){
        System.out.println("Bean of Spring Configuration is happening");
        return new SpringBeanMethodClass();
    }
}
