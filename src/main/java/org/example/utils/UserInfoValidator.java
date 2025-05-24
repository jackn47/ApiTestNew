package org.example.utils;

import io.qameta.allure.Allure;
import io.restassured.response.Response;
import org.assertj.core.api.SoftAssertions;
import org.example.models.RegistrationRequest;
import org.example.models.UserInfoResponse;

public class UserInfoValidator {

    public static void validateUserInfo(Response userInfoResponse, RegistrationRequest expectedData) {
        UserInfoResponse.UserData actual = userInfoResponse.as(UserInfoResponse.class).getData();

        SoftAssertions soft = new SoftAssertions();

        log("Сравнение данных userInfo с данными регистрации:");

        log(String.format("Email: expected = %s, actual = %s", expectedData.getEmail(), actual.getEmail()));
        soft.assertThat(actual.getEmail()).as("Email mismatch").isEqualTo(expectedData.getEmail());

        log(String.format("First Name: expected = %s, actual = %s", expectedData.getFirstName(), actual.getFirstName()));
        soft.assertThat(actual.getFirstName()).as("First name mismatch").isEqualTo(expectedData.getFirstName());

        log(String.format("Last Name: expected = %s, actual = %s", expectedData.getLastName(), actual.getLastName()));
        soft.assertThat(actual.getLastName()).as("Last name mismatch").isEqualTo(expectedData.getLastName());

        log(String.format("Currency: expected = %s, actual = %s", expectedData.getCurrency(), actual.getCurrency()));
        soft.assertThat(actual.getCurrency()).as("Currency mismatch").isEqualTo(expectedData.getCurrency());

        soft.assertAll();
    }

    private static void log(String message) {
        Allure.step(message);
    }
}