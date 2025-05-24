package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit5.AllureJunit5;
import io.restassured.response.Response;
import org.example.models.RegistrationRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.security.GeneralSecurityException;

@ExtendWith(AllureJunit5.class)
@Epic("User Profile")
@Feature("Get user info")
public class MatchUserInfoTest {

    private AllureSteps steps;

    @BeforeEach
    public void setup() throws GeneralSecurityException, IOException {
        steps = new AllureSteps();
    }

    @Test
    @Story("Match user info with registration data")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка соответствия userInfo данным, переданным при регистрации")
    public void testMatchGetUserInfo() throws GeneralSecurityException, IOException {
        RegistrationRequest registrationData = steps.generateRegistrationData();
        steps.registerUser(registrationData);
        String jwt = steps.confirmEmailAndGetJwt(registrationData.getEmail());
        Response userInfoResponse = steps.getUserInfo(jwt);
        steps.validateUserInfo(userInfoResponse, registrationData);
    }
}