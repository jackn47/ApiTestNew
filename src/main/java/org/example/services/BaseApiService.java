package org.example.services;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;


public abstract class BaseApiService {

    protected RequestSpecification baseRequest() {
        return RestAssured
                .given()
                .baseUri("https://test-devcasino.egamings.com")
                .contentType(ContentType.JSON)
                .queryParam("lang", "en");
    }
}
