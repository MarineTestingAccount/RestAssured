package tests;

import api.Specifications;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class gorestTests {
    private final static String URL = "https://gorest.co.in";
    private final static String token = "a9e5f1e7c2b7ddc3308af58fa9c251e2fb38809ee71d26e37b780419acae502e";

    @Test
    void checkAllUsers(){
        Specifications.installSpecification(Specifications.requestSpec(URL),Specifications.responseSpec200());
        Response response = given()
                .when()
                .get("/public-api/users")
                .then().log().all()
                .body("data.id", notNullValue())
                .body("data.name", notNullValue())
                .body("data.email", notNullValue())
                .body("data.gender", notNullValue())
                .body("data.status", notNullValue())
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        int status = jsonPath.get("code");
        System.out.println(status);
        Assertions.assertEquals(200,status);
        List<String> emails = jsonPath.get("data.email");
        Assertions.assertTrue(emails.stream().allMatch(x->x.contains("@")));
    }

    @Test
    void createNewUser(){
        Specifications.installSpecification(Specifications.requestSpec(URL),Specifications.responseSpec(200));
        Map<String, String> user = new HashMap<>();
        user.put("name","New User17");
        user.put("gender","male");
        user.put("email","user17@mail.ru");
        user.put("status","active");
        Response response = given()
                .body(user)
                .auth().oauth2(token)
                .when()
                .post("/public-api/users")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        int status = jsonPath.get("code");
        System.out.println(status);
        Assertions.assertEquals(201,status);
    }

    @Test
    void createExistingNewUser(){
        Specifications.installSpecification(Specifications.requestSpec(URL),Specifications.responseSpec(200));
        Map<String, String> user = new HashMap<>();
        user.put("name","New User17");
        user.put("gender","male");
        user.put("email","user17@mail.ru");
        user.put("status","active");
        Response response = given()
                .body(user)
                .auth().oauth2(token)
                .when()
                .post("/public-api/users")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        int status = jsonPath.get("code");
        System.out.println(status);
        Assertions.assertEquals(422,status);

    }


    @Test
    void updateUser(){
        Specifications.installSpecification(Specifications.requestSpec(URL),Specifications.responseSpec(201));
        Map<String, String> user = new HashMap<>();
        user.replace("name","Updated User");
        user.replace("email","updatedUser@mail.ru");
        user.replace("status","inactive");
        Response response = given()
                .body(user)
                .auth().oauth2(token)
                .when()
                .put("/public-api/users")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String name = jsonPath.get("name");
        System.out.println(response.getStatusCode());
        Assertions.assertEquals("New User", name);
    }

    @Test
    void deleteUser(){
        Specifications.installSpecification(Specifications.requestSpec(URL),Specifications.responseSpec(201));
        Map<String, String> user = new HashMap<>();
        user.put("name","New User5");
        user.put("gender","male");
        user.put("email","user5@mail.ru");
        user.put("status","active");
        Response response = given()
                .body(user)
                .auth().oauth2(token)
                .when()
                .put("/public-api/users")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String name = jsonPath.get("name");
        System.out.println(response.getStatusCode());
        Assertions.assertEquals("Updated User", name);
    }
}
