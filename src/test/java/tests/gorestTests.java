package tests;

import api.Specifications;
import com.google.gson.Gson;
import helpers.RandomDataGenerator;
import helpers.RequestMethods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pojo.CreateResponseRoot;
import pojo.Data;
import pojo.ResponseRoot;
import pojo.Root;

import static helpers.ConstData.*;
import static io.restassured.RestAssured.given;

public class gorestTests {
    RequestMethods request = new RequestMethods();
    @BeforeEach
    public void spec() {
        Specifications.installSpecification(Specifications.requestSpec(BASE_URL));
    }

    @Test
    void getAllUsers() {
        Root data = request.getUsersList200();
        Assertions.assertEquals(200, data.getCode());
    }

    @Test
    void createUser() {
        Root responseUser = request.createNewUser201();
        Assertions.assertEquals(201,responseUser.getCode());
        Assertions.assertNotNull(responseUser.getData().get(0).getId());
   }
    @Test
    void createUser400() {
        request.createNewUser400();

    }

//@Test
//void manyRequests429(){
//        request.manyRequests429();
//}


    @Test
    void createUser422() {
        CreateResponseRoot responseUser = request.createNewUser422();
        Assertions.assertEquals(422, responseUser.getCode());
    }

    @Test
    void createUser401() {
        ResponseRoot responseUser = request.createNewUser401();
        Assertions.assertEquals(401, responseUser.getCode());
    }

    @Test
    public void putUserData() {

        RandomDataGenerator randomValues = new RandomDataGenerator();
        String randName = randomValues.randomName();
        String randGender = randomValues.randomGender();
        String randEmail = randomValues.randomEmail();
        String randStatus = randomValues.randomStatus();

        Data requestUser = new Data(randName, randGender, randEmail, randStatus);
        String body = new Gson().toJson(requestUser);

        Root responseUser = given()
                .auth()
                .oauth2(ACCESS_TOKEN)
                .body(body)
                .pathParam("id", "3442")
                .when()
                .put(BASE_URL_PATH + "/{id}")
                .then().log().all()
                .extract().body().as(Root.class);
        Assertions.assertEquals(200, responseUser.getCode());
        Assertions.assertNotNull(responseUser.getData().get(0).getId());
        Assertions.assertEquals(requestUser.getName(), responseUser.getData().get(0).getName());
        Assertions.assertEquals(requestUser.getGender(), responseUser.getData().get(0).getGender());
        Assertions.assertEquals(requestUser.getEmail(), responseUser.getData().get(0).getEmail());
        Assertions.assertEquals(requestUser.getStatus(), responseUser.getData().get(0).getStatus());
    }


    @Test
    public void patchUserData() {
        Specifications.installSpecification(Specifications.requestSpec(BASE_URL));
        RandomDataGenerator randomValues = new RandomDataGenerator();
        String randName = randomValues.randomName();
        String randGender = randomValues.randomGender();
        String randEmail = randomValues.randomEmail();
        String randStatus = randomValues.randomStatus();

        Data requestUser = new Data(randStatus);
        String body = new Gson().toJson(requestUser);

        Root responseUser = given()
                .auth()
                .oauth2(ACCESS_TOKEN)
                .body(body)
                .pathParam("id", "3442")
                .when()
                .patch(BASE_URL_PATH + "/{id}")
                .then().log().all()
                .extract().body().as(Root.class);
        Assertions.assertEquals(200, responseUser.getCode());
        Assertions.assertNotNull(responseUser.getData().get(0).getId());
    }

    @Test
    public void deleteUserData() {
        Specifications.installSpecification(Specifications.requestSpec(BASE_URL));
        ResponseRoot responseDeleteUser = given()
                .auth()
                .oauth2(ACCESS_TOKEN)
                .pathParam("id", "4366")
                // WHEN
                .when()
                .delete(BASE_URL_PATH + "/{id}")
                // THEN
                .then().log().all()
                .extract().body().as(ResponseRoot.class);
        System.out.println(responseDeleteUser.getCode());
        Assertions.assertEquals(204, responseDeleteUser.getCode());
        Assertions.assertNull(responseDeleteUser.getMeta());
        Assertions.assertNull(responseDeleteUser.getData());

    }

    @Test
    public void checkDeletedUserData() {
        Specifications.installSpecification(Specifications.requestSpec(BASE_URL));
        ResponseRoot responseDeletedUser = given()
                .auth()
                .oauth2(ACCESS_TOKEN)
                .pathParam("id", "3522")
                // WHEN
                .when()
                .delete(BASE_URL_PATH + "/{id}")
                // THEN
                .then().log().all()
                .extract().body().as(ResponseRoot.class);
        System.out.println(responseDeletedUser.getCode());
        Assertions.assertEquals(404, responseDeletedUser.getCode());
        Assertions.assertNull(responseDeletedUser.getMeta());
        Assertions.assertEquals(responseDeletedUser.getData().getMessage(), DELETE_RESPONSE_MESSAGE);
    }

    @Test
    public void error500(){
        given()
                .log()
                .all()
                .when()
                .get()
                .then()
                .statusCode(500);

    }

}
