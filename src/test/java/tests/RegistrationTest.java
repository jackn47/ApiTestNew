package tests;

import org.example.models.RegistrationRequest;
import org.example.utils.TestDataGenerator;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RegistrationTest extends BaseTest {

    @Test
    public void testValidRegistration() {
        RegistrationRequest validRegistrationRequest = TestDataGenerator.generateValidRegistrationRequest();

        given()
                .spec(baseRequestSpec)
                .body(validRegistrationRequest)
        .when()
                .post("/api/v1/profiles")
        .then()
                .spec(baseResponseSpec)
                .body("data.result", equalTo(true));
    }
}