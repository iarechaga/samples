package com.santander.extended.gateway.wiremock;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class CreatePersonRequest {

    private final Integer age;
    private final Sex sex;

    @JsonCreator
    public CreatePersonRequest(@JsonProperty(value = "age") Integer age,
                               @JsonProperty(value = "sex") Sex sex) {
        this.age = age;
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }
}
