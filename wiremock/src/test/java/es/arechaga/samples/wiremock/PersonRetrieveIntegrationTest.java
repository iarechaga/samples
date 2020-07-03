package es.arechaga.samples.wiremock;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.MediaType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 8081)
class PersonRetrieveIntegrationTest {

    @LocalServerPort
    private int port;

    @Test
    void shouldRetrievePerson() {
        ResponseById response =
                RestAssured.given()
                        .port(port)
                        .header("Content-type", MediaType.APPLICATION_JSON_VALUE)
                        .pathParam("id", 123)
                        .when()
                        .get("/person/{id}")
                        .then()
                        .statusCode(200)
                        .contentType(ContentType.JSON)
                        .extract()
                        .as(ResponseById.class);

        assertThat(response.getId(), is(123));
        assertThat(response.getAge(), is(23));
        assertThat(response.getSex(), Matchers.is(Sex.MALE));
    }

    @Test
    void shouldCreatePerson() {
        CreatePersonRequest request = new CreatePersonRequest(32, Sex.FEMALE);

        ResponseById response = RestAssured
                .given()
                .port(port)
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("/person/")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .as(ResponseById.class);

        assertThat(response.getId(), is(345));
        assertThat(response.getAge(), is(32));
        assertThat(response.getSex(), Matchers.is(Sex.FEMALE));
    }
}
