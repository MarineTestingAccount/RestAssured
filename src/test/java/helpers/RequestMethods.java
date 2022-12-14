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
// I have many questions
//    public ResponseRoot manyRequests429() {
//
//        RequestMethods request = new RequestMethods();
//        Root responseUser = request.createNewUser201();
//        while (responseUser.getCode() != 429) {
//            request.createNewUser201();
//        }
//        ResponseRoot manyRequests = given()
//                .when()
//                .get()
//                .then().log().all()
//                .extract().body().as(ResponseRoot.class);
//        return manyRequests;
//    }

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
                .pathParam("id", "4669")
                .when()
                .put(BASE_URL_PATH + "/{id}")
                .then().log().all()
                .extract().body().as(Root.class);
        return responseUser;
    }

    public Root patchRequest(){
        RandomDataGenerator randomValues = new RandomDataGenerator();
        String randStatus = randomValues.randomStatus();
        Data requestUser = new Data(randStatus);
        String body = new Gson().toJson(requestUser);

        Root responseUser = given()
                .auth()
                .oauth2(ACCESS_TOKEN)
                .body(body)
                .pathParam("id", "4669")
                .when()
                .patch(BASE_URL_PATH + "/{id}")
                .then().log().all()
                .extract().body().as(Root.class);
        return responseUser;
    }

    public ResponseRoot deleteExistingUser(){
        ResponseRoot responseDeleteUser = given()
                .auth()
                .oauth2(ACCESS_TOKEN)
                .pathParam("id", "4669")
                // WHEN
                .when()
                .delete(BASE_URL_PATH + "/{id}")
                // THEN
                .then().log().all()
                .extract().body().as(ResponseRoot.class);
        return responseDeleteUser;
    }
    public ResponseRoot checkDeletedUser(){
        ResponseRoot responseDeletedUser = given()
                .auth()
                .oauth2(ACCESS_TOKEN)
                .pathParam("id", "4669")
                .when()
                .delete(BASE_URL_PATH + "/{id}")
                .then().log().all()
                .extract().body().as(ResponseRoot.class);
        return responseDeletedUser;
    }
}
