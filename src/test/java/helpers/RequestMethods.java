package helpers;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import pojo.CreateResponseRoot;
import pojo.Data;
import pojo.ResponseRoot;
import pojo.Root;

import static helpers.ConstData.ACCESS_TOKEN;
import static helpers.ConstData.BASE_URL_PATH;
import static io.restassured.RestAssured.given;

public class RequestMethods {
    public Root getUsersList200(){
        Root responseUser = given()
                .when()
                .get( BASE_URL_PATH)
                .then().log().all()
                .extract().as(Root.class);
        return responseUser;
    }
    public Root createNewUser201(){
        RandomDataGenerator randomValues = new RandomDataGenerator();
        Data requestUser = randomValues.setRandomData();
        String body = new Gson().toJson(requestUser);
        Root responseUser = given()
                .auth()
                .oauth2(ACCESS_TOKEN)
                .body(body)
                .when()
                .post(BASE_URL_PATH)
                .then().log().all()
                .extract().body().as(Root.class);
        return responseUser;
    }

    public void createNewUser400() {
        RandomDataGenerator randomValues = new RandomDataGenerator();
        Data requestUser = randomValues.setRandomData();
        String body = new Gson().toJson(requestUser);
        given()
                .auth()
                .oauth2(ACCESS_TOKEN)
                .header("Host", "")
                .body(body)
                .when()
                .contentType("text/html")
                .accept(ContentType.HTML)
                .post(BASE_URL_PATH)
                .then().log().all()
                .statusCode(400);

    }

//    public ResponseRoot manyRequests429() {
//
//        RequestMethods request = new RequestMethods();
//        Root responseUser = request.createNewUser201();
//        while (responseUser.getCode() != 429){
//            request.createNewUser201();
//        }
//            ResponseRoot response = given()
//                    .when()
//                    .then();
//                    //.extract().body().as(ResponseRoot.class);
//
//        Assertions.assertEquals(429, response.getCode());



   // }

    public CreateResponseRoot createNewUser422(){
        RandomDataGenerator randomValues = new RandomDataGenerator();
        Data requestUser = randomValues.setRandomDataWithEmptyName();
        String body = new Gson().toJson(requestUser);
        CreateResponseRoot responseUser = given()
                .auth()
                .oauth2(ACCESS_TOKEN)
                .body(body)
                .when()
                .post(BASE_URL_PATH)
                .then().log().all()
                .extract().body().as(CreateResponseRoot.class);
        return responseUser;
    }
    public ResponseRoot createNewUser401(){
        RandomDataGenerator randomValues = new RandomDataGenerator();
        Data requestUser = randomValues.setRandomDataWithEmptyName();
        String body = new Gson().toJson(requestUser);
        ResponseRoot responseUser = given()
                .auth()
                .oauth2(ACCESS_TOKEN + 1)
                .body(body)
                .when()
                .post(BASE_URL_PATH)
                .then().log().all()
                .extract().body().as(ResponseRoot.class);
        return responseUser;
    }

    public Root putRequest(){
        RandomDataGenerator randomValues = new RandomDataGenerator();
        Data requestUser = randomValues.setRandomData();
        String body = new Gson().toJson(requestUser);
        Root responseUser = given()
                .auth()
                .oauth2(ACCESS_TOKEN)
                .body(body)
                .pathParam("id", "4366")
                .when()
                .put(BASE_URL_PATH + "/{id}")
                .then().log().all()
                .extract().body().as(Root.class);
        return responseUser;
    }

}
