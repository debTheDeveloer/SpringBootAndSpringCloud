package com.IN28minutes.rest.webservice.restfulwebservice.SpringBeanTest;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseSpringBeanService {

    @Autowired
    SpringBeanMethodClass methodClass;

    /*@Autowired
    public UseSpringBeanService(SpringBeanMethodClass methodClass){
        this.methodClass=methodClass;
    }*/

    public  String printBean() {
     return methodClass.printString();
    }
}
