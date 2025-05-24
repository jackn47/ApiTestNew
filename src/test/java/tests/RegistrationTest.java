package tests;

import io.qameta.allure.*;
import org.example.models.RegistrationRequest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Epic("Registration")
@Feature("User Registration")
public class RegistrationTest extends BaseTest {

    private final AllureSteps steps;

    public RegistrationTest() throws GeneralSecurityException, IOException {
        this.steps = new AllureSteps();
    }

    @Test
    @Story("Valid registration")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Регистрация нового пользователя с валидными данными")
    public void testValidRegistration() {
        RegistrationRequest validRegistrationRequest = steps.generateRegistrationData();

        steps.registerUser(validRegistrationRequest);
    }
}