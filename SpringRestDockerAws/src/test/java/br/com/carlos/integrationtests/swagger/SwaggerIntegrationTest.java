package br.com.carlos.integrationtests.swagger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import org.springframework.boot.test.context.SpringBootTest;

import com.br.carlos.IntegrationTestsContainers.AbstractIntegrationTest;
import com.br.carlos.config.TestConfig;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class SwaggerIntegrationTest extends AbstractIntegrationTest {

    @Test
    public void shouldDisplaySwaggerUiPage() {
        var content = given()
                .basePath("/swagger-ui/index.html")
                .port(TestConfig.SERVER_PORT)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .body()
                .asString();

        Assertions.assertTrue(content.contains("Swagger UI"));
    }
}
