//package tests;
//
//import helpers.RandomValues;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import org.json.simple.JSONObject;
//import org.junit.jupiter.api.Test;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;
//import static org.hamcrest.Matchers.hasItem;
//import static org.junit.Assert.assertEquals;
//
//public class test {
//    RandomValues randomValues = new RandomValues();
////TestReporter reporter = new TestReporter() {
//    String assessToken = "a9e5f1e7c2b7ddc3308af58fa9c251e2fb38809ee71d26e37b780419acae502e";
//    @Test
//    public void getAllUsers() {
//        given().
//                contentType("application/json").
//                accept("application/json").
//                log().all().
//                when().
//                get("https://gorest.co.in/public-api/users").
//                then().
//                log().body().
//                assertThat().
//                body("data.'name'", hasItem("The Hon. Nalini Khanna")).
//                contentType("application/json").
//                statusCode(200);
//    }
//    @Test
//    public void getCreatedUser() {
//        given().
//                contentType("application/json").
//                accept("application/json").
//                log().all().
//                when().
//                get("https://gorest.co.in/public-api/users/3446").
//                then().
//                log().body().
//                assertThat().
//                body("data.name", equalTo("Chandravati Chopra"));
//
//    }
//    @Test
//    public void CreateNewUser(){
//        JSONObject param = new JSONObject();
//        String first_name = randomValues.GetRandomString(5);
//        String second_name = randomValues.GetRandomString(4);
//        String email = first_name + "." + second_name + "@monsterUniversity.com";
//        param.put("first_name", first_name);
//        param.put("last_name", second_name);
//        param.put("email", email);
//        param.put("gender", "male");
//
//        //Set Header content type as Json-with out this record will not be created
//        Map<String,String> headers = new HashMap<String,String>();
//        headers.put("Content-Type", "application/json");
//
//        //Get the Json String
//        String req_body = param.toJSONString();
//
//        //reporter.publishEntry("Json Req Body: " + req_body);
//        Response resp = given().
//                baseUri("https://gorest.co.in").body(req_body).headers(headers).
//                auth().oauth2(assessToken).
//                when().post("/public-api/users").
//                thenReturn();
//       // reporter.publishEntry("HTTP Status Code: " + resp.getStatusCode() + resp.getBody().asString());
//    }
//
//    }
//}
