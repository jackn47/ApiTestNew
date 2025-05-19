package org.example.services;

import io.restassured.response.Response;

public class UserInfoService extends BaseApiService {

    public Response getUserInfo(String jwt) {
        return baseRequest()
                .header("Authorization", "Bearer " + jwt)
                .when()
                .get("/api/v1/userInfo")
                .then()
                .statusCode(200)
                .extract().response();
    }
}