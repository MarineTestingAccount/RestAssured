package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {
    public static RequestSpecification requestSpec(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType("application/json")
                .setAccept("application/json")
                .build();
    }

    public static ResponseSpecification responseSpec(int statusCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .build();
    }
//
//    public static ResponseSpecification responseSpec201() {
//        return new ResponseSpecBuilder()
//                .expectStatusCode(201)
//                .build();
//    }
//    public static ResponseSpecification responseSpec400() {
//        return new ResponseSpecBuilder()
//                .expectStatusCode(400)
//                .build();
//    }
//    public static ResponseSpecification responseSpec(int status) {
//        return new ResponseSpecBuilder()
//                .expectStatusCode(status)
//                .build();
//    }

    public static void installSpecification(RequestSpecification request) {
        RestAssured.requestSpecification = request;
        //RestAssured.responseSpecification = response;
    }

////template
//    RequestSpecification req= RestAssured.given()
//            .accept(ContentType.JSON)
//            .auth().preemptive().basic("username", "password")
//            .header("headername", "headervalue")
//            .param("paramname", "paramvalue")
//            .cookie("cookieName", "value");
//}
}
