package ComplexSearchApiTest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import net.javacrumbs.jsonunit.JsonAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.constant.Constable;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.util.stream.Stream;

import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static org.hamcrest.Matchers.*;

public class Api {

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "https://api.spoonacular.com";
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .addParam("apiKey", "545bbb609fe0417ab5fb7cd3d6161361")
                .build();
    }

    @Test
    void testSearchBread() {

        String actually = RestAssured.given()
                .param("number", 3)
                .param("limitLicense", true)
                .param("query", "bread")
                .log()
                .uri()
                .expect()
                .statusCode(200)
                .time(lessThanOrEqualTo(1500L))
                .body("totalResults", is(175))
                .body("results", hasSize(3))
                .log()
                .body()
                .when()
                .get("/recipes/complexSearch")
                .body()
                .asPrettyString();

        String expected = readResourceAsString("expected.json");

        JsonAssert.assertJsonEquals(
                expected,
                actually,
                JsonAssert.when(IGNORING_ARRAY_ORDER)
        );
    }

    private String readResourceAsString(String s) {
        return s;
    }

    @ParameterizedTest
    @MethodSource("resources")
    void testImageRecognize(String image) {
        RestAssured.given()
                .log()
                .all()
                .param("imageUrl", image)
                .expect()
                .statusCode(200)
                .body("status", is("success"))
                .body("category", is("burger"))
                .body("probability", greaterThan(0.6f))
                .log()
                .all()
                .when()
                .get("/food/images/classify");
    }

    public static Stream<Arguments> resources() {

        Arguments f1 = Arguments.of("https://at-cdn-s02.audiotool.com/2016/08/16/documents/midnight_burger/2/cover256x256-bb3d21a60e5f42d18279a256f8d85ebf.jpg");
        Arguments f2 = Arguments.of("https://avatanplus.com/files/resources/small/59b68673384f515e70fd321f.png");
        Arguments f3 = Arguments.of("https://avatars.mds.yandex.net/i?id=ff82bc041577cfab6578b7a14edd3642_sr-5179886-images-thumbs&n=13");
        return Stream.of(f1, f2, f3);
    }

     private String readComplexSearchApiTest(String resourceName) {
              // ComplexSearchApiTest/Api
        String path = getClass().getSimpleName() + FileSystems.getDefault().getSeparator() + resourceName;
        try (InputStream inputStream = getClass().getResourceAsStream(path)) {
            assert inputStream != null;
            byte[] data = inputStream.readAllBytes();
            return new String(data, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
