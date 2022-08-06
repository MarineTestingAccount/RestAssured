package requests;

import static helpers.ConstData.BASE_URL_PATH;
import static io.restassured.RestAssured.given;

public class GorestRequests {

    public  void checkAllUsers() {
            given()
            .when()
               .get(BASE_URL_PATH)
            .then().log().all()
            .statusCode(200)
            .statusLine("HTTP/1.1 200 OK");
            //.body("data.id",hasItem(2508));
    }

    public void createNewUser(){


            ////TEMPLATE
        // There is no need to add escape character manually. Just paste string within double
        // quotes. It will automatically add escape sequence as required.
//        String jsonString = "{\"username\" : \"admin\",\"password\" : \"password123\"}";
//
//
//        //GIVEN
//        RestAssured
//                .given()
//                .baseUri("https://restful-booker.herokuapp.com/auth")
//                .contentType(ContentType.JSON)
//                .body(jsonString)
//                // WHEN
//                .when()
//                .post()
//                // THEN
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .body("token", Matchers.notNullValue())
//                .body("token.length()", Matchers.is(15))
//                .body("token", Matchers.matchesRegex("^[a-z0-9]+$"));
//
//
//    }
    }

    public void putUpdate(){

        // There is no need to add escape character manually. Just paste string within
        // double
        // quotes. It will automatically add escape sequence as required.
//        String jsonString = "{\r\n" + "    \"firstname\" : \"Amod\",\r\n" + "    \"lastname\" : \"Mahajan\",\r\n"
//                + "    \"totalprice\" : 111,\r\n" + "    \"depositpaid\" : true,\r\n" + "    \"bookingdates\" : {\r\n"
//                + "        \"checkin\" : \"2018-01-01\",\r\n" + "        \"checkout\" : \"2019-01-01\"\r\n"
//                + "    },\r\n" + "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}";
//
//        //GIVEN
//        RestAssured
//                .given()
//                .baseUri("https://restful-booker.herokuapp.com/booking/1")
//                .cookie("token", "e88375c0fde687a")
//                .contentType(ContentType.JSON)
//                .body(jsonString)
//                // WHEN
//                .when()
//                .put()
//                // THEN
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .body("firstname", Matchers.equalTo("Amod"))
//                .body("lastname", Matchers.equalTo("Mahajan"));
//
//    }
    }

    public void patchRequest(){
        // There is no need to add escape character manually. Just paste string within
        // double
        // quotes. It will automatically add escape sequence as required.
        String jsonString = "{\r\n" +
                "    \"firstname\" : \"Amod\",\r\n" +
                "    \"lastname\" : \"Mahajan\"}";

//        //GIVEN
//        RestAssured
//                .given()
//                .baseUri("https://restful-booker.herokuapp.com/booking/1")
//                .cookie("token", "6608dc75eedd44f")
//                .contentType(ContentType.JSON)
//                .body(jsonString)
//                // WHEN
//                .when()
//                .patch()
//                // THEN
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .body("firstname", Matchers.equalTo("Amod"))
//                .body("lastname", Matchers.equalTo("Mahajan"));
//
//    }



    }
    public  void deleteRequest() {
        // Delete Booking

//        //GIVEN
//        RestAssured
//                .given()
//                .baseUri("https://restful-booker.herokuapp.com/booking/1")
//                .cookie("token", "f7dddb1093eab19")
//                // WHEN
//                .when()
//                .delete()
//                // THEN
//                .then()
//                .assertThat()
//                .statusCode(201);
//
//        // Verifying booking is deleted
//        // Given
//        RestAssured
//                .given()
//                .baseUri("https://restful-booker.herokuapp.com/booking/1")
//                // When
//                .when()
//                .get()
//                // Then
//                .then()
//                .statusCode(404);
//
//    }

    }
}
