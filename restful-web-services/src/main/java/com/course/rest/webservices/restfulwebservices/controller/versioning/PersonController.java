package com.course.rest.webservices.restfulwebservices.controller.versioning;

import com.course.rest.webservices.restfulwebservices.model.versioning.Name;
import com.course.rest.webservices.restfulwebservices.model.versioning.PersonV1;
import com.course.rest.webservices.restfulwebservices.model.versioning.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("/v2/person")
    public PersonV2 getFirstVersion2OfPerson() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }
}
