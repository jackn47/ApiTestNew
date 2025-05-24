package tests;

import io.qameta.allure.*;
import io.restassured.response.Response;
import org.example.models.AuthRequest;
import org.example.models.RegistrationRequest;
import org.example.services.AuthService;
import org.example.utils.GmailService;
import org.example.services.RegistrationService;
import org.example.services.UserInfoService;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class AllureSteps {

    private RegistrationService registrationService = new RegistrationService();
    private AuthService authService = new AuthService();
    private GmailService gmailService;
    private UserInfoService userInfoService = new UserInfoService();

    public AllureSteps() throws GeneralSecurityException, IOException {
        this.gmailService = new GmailService();
    }

    @Step("Генерируем данные для регистрации")
    public RegistrationRequest generateRegistrationData() {
        RegistrationRequest data = org.example.utils.TestDataGenerator.generateValidRegistrationRequest();
        return data;
    }

    @Step("Регистрируем пользователя с email: {registrationData.email}")
    public void registerUser(RegistrationRequest registrationData) {
        registrationService.register(registrationData);
    }

    @Step("Подтверждаем email {email} и получаем JWT")
    public String confirmEmailAndGetJwt(String email) throws GeneralSecurityException, IOException {
        return gmailService.confirmEmailAndGetJwt(email);
    }

    @Step("Получаем информацию о пользователе")
    public Response getUserInfo(String jwt) {
        return userInfoService.getUserInfo(jwt);
    }

    @Step("Валидируем данные пользователя")
    public void validateUserInfo(Response userInfoResponse, RegistrationRequest expectedData) {
        org.example.utils.UserInfoValidator.validateUserInfo(userInfoResponse, expectedData);
    }

    @Step("Авторизуемся с email: {authRequest.email}")
    public String login(AuthRequest authRequest) {
        Response response = authService.login(authRequest);
        return response.path("data.result.jwtToken");
    }

    @Step("Авторизация без валидации ответа")
    public Response loginWithoutValidation(AuthRequest authRequest) {
        return authService.loginWithoutValidation(authRequest);
    }
}