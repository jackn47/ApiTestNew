package tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

import static org.hamcrest.Matchers.equalTo;

public abstract class BaseTest {

    protected static RequestSpecification baseRequestSpec;
    protected static ResponseSpecification baseResponseSpec;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://test-devcasino.egamings.com"; //

        baseRequestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addQueryParam("lang", "en")
                .build();

        baseResponseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectBody("code", equalTo(200))
                .expectBody("status", equalTo("success"))
                .build();
    }
}