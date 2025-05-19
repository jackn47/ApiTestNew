package tests;

import io.restassured.response.Response;
import org.example.models.AuthRequest;
import org.example.services.AuthService;
import org.example.utils.TestDataGenerator;
import org.junit.jupiter.api.Test;

public class AuthTest extends BaseTest {
    private final AuthService authService = new AuthService();

    @Test
    public void testValidAuth() {
        AuthRequest authRequest = TestDataGenerator.generateValidAuthRequest();

        Response response = authService.login(authRequest);

        String jwt = response.path("data.result.jwtToken");
        System.out.println("JWT: " + jwt);
    }
}