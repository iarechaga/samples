package es.arechaga.samples.wiremock;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ResponseById {

    private final Integer id;
    private final Integer age;
    private final Sex sex;

    @JsonCreator
    public ResponseById(@JsonProperty(value = "id") Integer id,
                        @JsonProperty(value = "age") Integer age,
                        @JsonProperty(value = "sex") Sex sex) {
        this.id = id;
        this.age = age;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }
}
