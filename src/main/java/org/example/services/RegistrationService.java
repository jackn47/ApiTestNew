package org.example.services;

import org.example.models.RegistrationRequest;

import static org.hamcrest.Matchers.equalTo;

public class RegistrationService extends BaseApiService {

    public void register(RegistrationRequest request) {
        baseRequest()
                .body(request)
                .when()
                .post("/api/v1/profiles")
                .then()
                .statusCode(200)
                .body("code", equalTo(200))
                .body("status", equalTo("success"))
                .body("data.result", equalTo(true));
    }
}