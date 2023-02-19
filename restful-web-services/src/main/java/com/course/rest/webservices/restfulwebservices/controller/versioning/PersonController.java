package com.course.rest.webservices.restfulwebservices.controller.versioning;

import com.course.rest.webservices.restfulwebservices.model.versioning.Name;
import com.course.rest.webservices.restfulwebservices.model.versioning.PersonV1;
import com.course.rest.webservices.restfulwebservices.model.versioning.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    /*
    * URI Versioning (Digunakan oleh Twitter)
    * http://localhost:8080/v1/person
    * http://localhost:8080/v2/person
    *
    * */

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    /*
     * Request Parameter Versioning (Digunakan oleh Amazon)
     * http://localhost:8080/version=1
     * http://localhost:8080/version=2
     *
     * */

    @GetMapping(path ="/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonReqParam() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path ="/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonReqParam() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    /*
     * Custom Header Versioning (Digunakan oleh Microsoft)
     * http://localhost:8080/person/header
     * http://localhost:8080/person/header
     *
     * */

    @GetMapping(path ="/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonReqHeader() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path ="/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonReqHeader() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    /*
     * Media Type Versioning (Digunakan oleh Microsoft)
     * http://localhost:8080/person/header
     * http://localhost:8080/person/header
     *
     * */

    @GetMapping(path ="/person/accept", produces = "application/vnd.company.app.-v1+json")
    public PersonV1 getFirstVersionOfPersonMediaTypeVersioning() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path ="/person/accept", produces = "application/vnd.company.app.-v2+json")
    public PersonV2 getSecondVersionOfPersonMediaTypeVersioning() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }
}
