package org.example.services;

import io.restassured.response.Response;
import org.example.models.AuthRequest;

import static org.hamcrest.Matchers.equalTo;

public class AuthService extends BaseApiService {

    public Response login(AuthRequest authRequest) {
        return baseRequest()
                .body(authRequest)
                .when()
                .put("/api/v1/auth")
                .then()
                .statusCode(200)
                .body("code", equalTo(200))
                .body("status", equalTo("success"))
                .extract().response();
    }

    public Response loginWithoutValidation(AuthRequest authRequest) {
        return baseRequest()
                .body(authRequest)
                .when()
                .put("/api/v1/auth");
    }
}