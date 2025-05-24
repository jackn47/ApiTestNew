package tests;

import io.qameta.allure.*;
import io.restassured.response.Response;
import org.example.models.AuthTestCase;
import org.example.utils.TestDataGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

@Epic("Authorization")
@Feature("Login")
public class AuthTest extends BaseTest {

    private final AllureSteps steps;

    public AuthTest() throws GeneralSecurityException, IOException {
        this.steps = new AllureSteps();
    }

    static Stream<AuthTestCase> authRequestProvider() {
        return Stream.of(
                new AuthTestCase("Успешная авторизация", TestDataGenerator.generateValidAuthRequest(), true),
                new AuthTestCase("Невалидный логин", TestDataGenerator.generateInvalidAuthRequest(), false)
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("authRequestProvider")
    @Story("Authorization with various credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка авторизации с различными наборами данных")
    public void testAuth(AuthTestCase testCase) {
        Allure.step("Кейс: " + testCase.getTitle());

        Response response = steps.loginWithoutValidation(testCase.getRequest());

        if (testCase.isShouldSucceed()) {
            response.then()
                    .statusCode(200)
                    .body("code", equalTo(200))
                    .body("status", equalTo("success"));
            Allure.step("Авторизация прошла успешно");
        } else {
            response.then()
                    .statusCode(not(200));
            Allure.step("Авторизация ожидаемо провалилась");
        }
    }
}