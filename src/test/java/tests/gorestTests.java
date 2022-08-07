package tests;

import api.Specifications;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import helpers.RandomDataGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojo.Data;
import pojo.Root;

import static helpers.ConstData.*;
import static io.restassured.RestAssured.given;

public class gorestTests {
    private static final ObjectMapper MAPPER = new ObjectMapper();    @Test
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
        Specifications.installSpecification(Specifications.requestSpec(BASE_URL ));
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
                .then()
                .extract().body().as(Root.class);
        Assertions.assertEquals(201,responseUser.getCode());
        System.out.println(responseUser.getData().get(0));
        Assertions.assertNotNull(responseUser.getData().get(0));
        //Assertions.assertEquals(201, responseUser.getCode());
    }


}
