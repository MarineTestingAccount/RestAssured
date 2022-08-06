package tests;

import api.Specifications;
import helpers.InitDB;
import helpers.Payloads;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import requests.GorestRequests;

import static helpers.ConstData.BASE_URL;

public class gorestTests {

    String userId;
//    RandomValues randomValues = new RandomValues();
    InitDB crtDb = new InitDB();
    GorestRequests gorestRequests = new GorestRequests();
    Payloads payloads = new Payloads();

//    protected String randName = randomValues.randomName();
//    protected String randGender = randomValues.randomGender();
//    protected String randEmail = randomValues.randomEmail();
//    protected String randStatus = randomValues.randomStatus();

    @BeforeEach
    void before() {
       Specifications.installSpecification(Specifications.requestSpec(BASE_URL), Specifications.responseSpec200());
    }

    @Test
    void checkAllUsers() {
        gorestRequests.checkAllUsers();




//        int status = jsonPath.get("code");
//        System.out.println(status);
//        Assertions.assertEquals(200, status);
//        List<String> emails = jsonPath.get("data.email");
//        Assertions.assertTrue(emails.stream().allMatch(x -> x.contains("@")));
    }

//    @Test
//    void getOneUser() {
//        Response response = given()
//                .urlEncodingEnabled(false)
//                .basePath("/public-api/users")
//                //.pathParam("userId", encode("{userId}", UTF_8.name()))
//                .when()
//                .get("/{userId}")
//                .then().log().all()
//                .extract().response();
//        JsonPath jsonPath = response.jsonPath();
//        int status = jsonPath.get("code");
//        List<String> names = jsonPath.get("data.name");
//        Assertions.assertEquals(200, status);
//        //Assertions.assertTrue(names.stream().anyMatch(x -> x.equals(randName)));
//    }
//
//
//    @Test
//    void createNewUser() {
//        String url = "jdbc:mysql://localhost:3306/Rest_Assured_GorestDB";
//        //String db = "Rest_Assured_GorestDB";
//        // String usersUrl = "/users";
//        crtDb.initJDBC();
//        crtDb.createDB();
//        crtDb.connectDB(url);
//        crtDb.createTable();
//        String userId = "";
////        Map<String, String> user = new HashMap<>();
////        user.put("name", randName);
////        user.put("gender", randGender);
////        user.put("email", randEmail);
////        user.put("status", randStatus);
//        user = payloads.createUserPayload();
//        given()
//                .body(user)
//                .auth().oauth2(ACCESS_TOKEN)
//                //.port(3306)
//                .when()
//                //.post("/Rest_Assured_GorestDB/users")
//                .post(BASE_URL + BASE_URL_PATH)
//                .then().log().all();
////                .extract().response();
////        JsonPath jsonPath = response.jsonPath();
////        int status = jsonPath.get("code");
////        userId = jsonPath.get("data.id");
////        System.out.println(userId);
////        System.out.println(status);
////        Assertions.assertEquals(201, status);
////        return jsonPath.get("data.id");
//    }
//
//
//
//    @Test
//    void createExistingNewUser() {
//        Map<String, String> user = new HashMap<>();
//        user.put("name", randName);
//        user.put("gender", randGender);
//        user.put("email", randEmail);
//        user.put("status", randStatus);
//        Response response = given()
//                .body(user)
//                .auth().oauth2(ACCESS_TOKEN)
//                .when()
//                .post("/public-api/users/")
//                .then().log().all()
//                .extract().response();
//        JsonPath jsonPath = response.jsonPath();
//        int status = jsonPath.get("code");
//        System.out.println(status);
//        Assertions.assertEquals(422, status);
//
//    }
//
//
//    @Test
//    void updateUser() {
//            //this.createNewUser();
//        Map<String, String> user = new HashMap<>();
//        user.replace("name", randomValues.randomName());
//        user.replace("email", randomValues.randomEmail());
//        user.replace("status", randStatus);
//        int idUs = 6934;
//        //System.out.println(userId);
//        Response response = given()
//                .body(user)
//                .auth().oauth2(ACCESS_TOKEN)
//                .when()
//                .patch(BASE_URL + BASE_URL_PATH+ idUs)
//                .then().log().all()
//                .extract().response();
//        JsonPath jsonPath = response.jsonPath();
//        int status = jsonPath.get("code");
//        String id = jsonPath.get("data.id").toString();
//        System.out.println(response.getStatusCode());
//        Assertions.assertEquals(200, status);
//        Assertions.assertEquals(id, userId);
//    }
//
//    @Test
//    void deleteUser() {
//        Map<String, String> user = new HashMap<>();
//        user.put("name", "New User5");
//        user.put("gender", "male");
//        user.put("email", "user5@mail.ru");
//        user.put("status", "active");
//        Response response = given()
//                .body(user)
//                .auth().oauth2(ACCESS_TOKEN)
//                .when()
//                .put("/public-api/users")
//                .then().log().all()
//                .extract().response();
//        ResponseBody body = response.getBody();
//        System.out.println("Response Body is: " + body.asString());
//
////        JsonPath jsonPath = response.jsonPath();
////        String name = jsonPath.get("name");
////        System.out.println(response.getStatusCode());
////        Assertions.assertEquals("Updated User", name);
//    }
//
    @Test
    void DB() {
        crtDb.createDB();
        crtDb.createTable();
    }
//
//    @Test
//    void getAll(){
//        gorestRequests.checkAllUsers();
//    }
//
//    @Test
//    void hostVerify(){
//        // Hitting a GET request without setting any base URI and Path
//        RestAssured
//                .given()
//                // Logging all details
//                .log()
//                .all()
//                .when()
//                .get();
//        //I get status 500
//    }
}
