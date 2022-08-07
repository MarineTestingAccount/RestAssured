package helpers;

import com.google.gson.Gson;
import pojo.CreateResponseRoot;
import pojo.Data;
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



}
