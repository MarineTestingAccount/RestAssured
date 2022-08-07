package tests;

import api.Specifications;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import helpers.RandomDataGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojo.Data;
import pojo.DeleteResponseRoot;
import pojo.Root;

import static helpers.ConstData.*;
import static io.restassured.RestAssured.given;

public class gorestTests {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    @Test
    void getAllUsers(){
        Specifications.installSpecification(Specifications.requestSpec(BASE_URL ));

        Root responseUser = given()
                .when()
                .get( BASE_URL_PATH)
                .then().log().all()
                .extract().as(Root.class);
        Assertions.assertEquals(200,responseUser.getCode());
    }

    @Test
    void createUser(){
        Specifications.installSpecification(Specifications.requestSpec(BASE_URL));

        RandomDataGenerator randomValues = new RandomDataGenerator();
        String randName = randomValues.randomName();
        String randGender = randomValues.randomGender();
        String randEmail = randomValues.randomEmail();
        String randStatus = randomValues.randomStatus();

        Data requestUser = new Data(randName,randGender,randEmail,randStatus);
        String body = new Gson().toJson(requestUser);
        Root responseUser = given()
                .auth()
                .oauth2(ACCESS_TOKEN)
                .body(body)
                .when()
                .post(BASE_URL_PATH)
                .then().log().all()
                .extract().body().as(Root.class);
        Assertions.assertEquals(201,responseUser.getCode());
        Assertions.assertNotNull(responseUser.getData().get(0).getId());
        Assertions.assertEquals(requestUser.getName(),responseUser.getData().get(0).getName());
        Assertions.assertEquals(requestUser.getGender(),responseUser.getData().get(0).getGender());
        Assertions.assertEquals(requestUser.getEmail(),responseUser.getData().get(0).getEmail());
        Assertions.assertEquals(requestUser.getStatus(),responseUser.getData().get(0).getStatus());

    }
    @Test
    public void putUserData() {
        Specifications.installSpecification(Specifications.requestSpec(BASE_URL));
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
                .put(BASE_URL_PATH+"/{id}")
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
            public void deleteUserData () {
                Specifications.installSpecification(Specifications.requestSpec(BASE_URL));
                DeleteResponseRoot responseDeleteUser = given()
                        .auth()
                        .oauth2(ACCESS_TOKEN)
                        .pathParam("id", "3531")
                        // WHEN
                        .when()
                        .delete(BASE_URL_PATH + "/{id}")
                        // THEN
                        .then().log().all()
                        .extract().body().as(DeleteResponseRoot.class);
                System.out.println(responseDeleteUser.getCode());
                Assertions.assertEquals(204, responseDeleteUser.getCode());
                Assertions.assertNull(responseDeleteUser.getMeta());
                Assertions.assertNull(responseDeleteUser.getData());

            }
    @Test
    public void checkDeletedUserData() {
        Specifications.installSpecification(Specifications.requestSpec(BASE_URL));
        DeleteResponseRoot responseDeletedUser = given()
                .auth()
                .oauth2(ACCESS_TOKEN)
                .pathParam("id", "3522")
                // WHEN
                .when()
                .delete(BASE_URL_PATH + "/{id}")
                // THEN
                .then().log().all()
                .extract().body().as(DeleteResponseRoot.class);
        System.out.println(responseDeletedUser.getCode());
        Assertions.assertEquals(404, responseDeletedUser.getCode());
        Assertions.assertNull(responseDeletedUser.getMeta());
        Assertions.assertEquals(responseDeletedUser.getData().getMessage(), DELETE_RESPONSE_MESSAGE);
    }

}
