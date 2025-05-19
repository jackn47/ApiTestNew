package tests;

import io.restassured.response.Response;
import org.example.models.AuthRequest;
import org.example.models.RegistrationRequest;
import org.example.services.AuthService;
import org.example.services.RegistrationService;
import org.example.services.UserInfoService;
import org.example.utils.GmailService;
import org.example.utils.TestDataGenerator;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatchGetUserInfo {

    @Test
    public void TestMatchGetUserInfo() throws GeneralSecurityException, IOException {
        GmailService gmailService = new GmailService();
        RegistrationService registrationService = new RegistrationService();
        AuthService authService = new AuthService();
        UserInfoService userInfoService = new UserInfoService();

        RegistrationRequest registrationData = TestDataGenerator.generateValidRegistrationRequest();
        registrationService.register(registrationData);

        gmailService.confirmEmail(registrationData.getEmail());

        AuthRequest loginRequest = AuthRequest.builder()
                .login(registrationData.getEmail())
                .password(registrationData.getPassword())
                .useJwt(1)
                .build();
        Response loginResponse = authService.login(loginRequest);
        String jwt = loginResponse.path("data.result.jwtToken");

        Response userInfoResponse = userInfoService.getUserInfo(jwt);

        String returnedEmail = userInfoResponse.path("data.email");
        String returnedFirstName = userInfoResponse.path("data.firstName");

        assertEquals(registrationData.getEmail(), returnedEmail);
        assertEquals(registrationData.getFirstName(), returnedFirstName);
    }
}

