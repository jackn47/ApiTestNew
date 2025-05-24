package org.example.services;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;
import io.qameta.allure.restassured.AllureRestAssured;


public abstract class BaseApiService {

    protected RequestSpecification baseRequest() {
        return RestAssured
                .given()
                .filter(new AllureRestAssured())
                .baseUri("https://test-devcasino.egamings.com")
                .contentType(ContentType.JSON)
                .queryParam("lang", "en");
    }
}
