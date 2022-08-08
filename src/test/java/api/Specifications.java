package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Specifications {
    public static RequestSpecification requestSpec(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType("application/json")
                .setAccept("application/json")
                .build();
    }

    public static void installSpecification(RequestSpecification request) {
        RestAssured.requestSpecification = request;
    }
}
