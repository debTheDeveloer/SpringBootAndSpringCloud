package com.IN28minutes.rest.webservice.restfulwebservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {


    //Uri versioning
    @GetMapping("v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Debajyoti Ghatak");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Debajyoti","Ghatak"));
    }

    //Param versioning
    @GetMapping(value = "/person/param", params = "version=1")
    public PersonV1 paramV1(){
        return new PersonV1("Debajyoti Ghatak");
    }

    @GetMapping(value = "/person/param", params = "version=2")
    public PersonV2 paramV2(){
        return new PersonV2(new Name("Debajyoti","Ghatak"));
    }

    //Header versioning
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 headerV1(){
        return new PersonV1("Debajyoti Ghatak");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 headerV2(){
        return new PersonV2(new Name("Debajyoti","Ghatak"));
    }

    //MediaType versioning
//    @GetMapping(value = "/person/produces", produces ="application/vnd.company.app-v1+json")
//    public PersonV1 producerV1(){
//        return new PersonV1("Debajyoti Ghatak");
//    }
//
//    @GetMapping(value = "/person/produces", produces ="application/vnd.company.app-v1+json")
//    public PersonV2 producerV2(){
//        return new PersonV2(new Name("Debajyoti","Ghatak"));
//    }
}
