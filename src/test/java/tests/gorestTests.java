package tests;

import api.Specifications;
import helpers.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class gorestTests {
    private final static String URL = "https://gorest.co.in";
    private final static String token = "a9e5f1e7c2b7ddc3308af58fa9c251e2fb38809ee71d26e37b780419acae502e";
    protected String userId = "";

    RandomValues randomValues = new RandomValues();
    ConnectToDB db = new ConnectToDB();
    InitSQLServer initSQLServer = new InitSQLServer();

    CreateDatabaseDemo crtDb = new CreateDatabaseDemo();
    DB dbb = new DB();

    protected String randName = randomValues.randomName();
    protected String randGender = randomValues.randomGender();
    protected String randEmail = randomValues.randomEmail();
    protected String randStatus = randomValues.randomStatus();

    public gorestTests() throws SQLException {
    }

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
    void getOneUser(){
        Specifications.installSpecification(Specifications.requestSpec(URL),Specifications.responseSpec200());
        Response response = given()
                .urlEncodingEnabled(false)
                .basePath("/public-api/users")
                //.pathParam("userId", encode("{userId}", UTF_8.name()))
                .when()
                .get("/{userId}")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        int status = jsonPath.get("code");
        List<String> names = jsonPath.get("data.name");
        Assertions.assertEquals(200,status);
        Assertions.assertTrue(names.stream().anyMatch(x->x.equals(randName)));
    }


    @Test
    void createNewUser(){
        Specifications.installSpecification(Specifications.requestSpec(URL),Specifications.responseSpec(200));
        Map<String, String> user = new HashMap<>();
        user.put("name",randName);
        user.put("gender",randGender);
        user.put("email",randEmail);
        user.put("status",randStatus);
        Response response = given()
                .body(user)
                .auth().oauth2(token)
                .when()
                .post("/public-api/users")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        int status = jsonPath.get("code");
        userId = jsonPath.get("data.id").toString();
        System.out.println(userId);
        System.out.println(status);
        Assertions.assertEquals(201,status);
    }

    @Test
    void createExistingNewUser(){
        Specifications.installSpecification(Specifications.requestSpec(URL),Specifications.responseSpec(200));
        Map<String, String> user = new HashMap<>();
        user.put("name",randName);
        user.put("gender",randGender);
        user.put("email",randEmail);
        user.put("status",randStatus);
        Response response = given()
                .body(user)
                .auth().oauth2(token)
                .when()
                .post("/public-api/users/")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        int status = jsonPath.get("code");
        System.out.println(status);
        Assertions.assertEquals(422,status);

    }


    @Test
    void updateUser(){
        Specifications.installSpecification(Specifications.requestSpec(URL),Specifications.responseSpec(200));
        Map<String, String> user = new HashMap<>();
        user.replace("name",randomValues.randomName());
        user.replace("email",randomValues.randomEmail());
        user.replace("status",randStatus);
        //System.out.println(userId);
        Response response = given()
                .body(user)
                .auth().oauth2(token)
                .when()
                .patch("/public-api/users/:{userId}")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        int status = jsonPath.get("code");
        String id = jsonPath.get("data.id").toString();
        System.out.println(response.getStatusCode());
        Assertions.assertEquals(200,status);
        Assertions.assertEquals(id,userId);
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

    @Test
    void DB() throws SQLException, IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        crtDb.init();
    }
}
