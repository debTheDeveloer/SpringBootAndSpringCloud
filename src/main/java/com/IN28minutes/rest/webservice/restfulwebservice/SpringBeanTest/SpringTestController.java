package com.IN28minutes.rest.webservice.restfulwebservice.SpringBeanTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringTestController {

    @Autowired
    UseSpringBeanService service;

    @GetMapping("/spring/BeanTest")
    public String getStringFromSpringBean(){
        return  service.printBean();
    }
}
