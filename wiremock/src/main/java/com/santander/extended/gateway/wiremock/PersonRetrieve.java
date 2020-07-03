package com.santander.extended.gateway.wiremock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PersonRetrieve {

    private final RestTemplate restTemplate;


    @Autowired
    public PersonRetrieve(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(path = "/person/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseById get(@PathVariable("id") Integer id) {
        ResponseEntity<ResponseById> entity = restTemplate.getForEntity("http://localhost:8081/person/" + id, ResponseById.class);
        return entity.getBody();
    }

    @PostMapping(path = "/person/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseById create(@RequestBody CreatePersonRequest request) {
        ResponseEntity<ResponseById> entity = restTemplate.postForEntity("http://localhost:8081/person/", request, ResponseById.class);
        return entity.getBody();
    }


}
