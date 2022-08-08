package tests;

import api.Specifications;
import helpers.InitDB;
import helpers.RequestMethods;
import org.junit.jupiter.api.*;
import pojo.CreateResponseRoot;
import pojo.ResponseRoot;
import pojo.Root;

import static helpers.ConstData.*;
import static io.restassured.RestAssured.given;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class gorestTests {
    RequestMethods request = new RequestMethods();
    InitDB initDB = new InitDB();

    @BeforeAll
    public void setInitDB(){
        initDB.dbConfig();
    }
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
        int idV = responseUser.getData().get(0).getId();
        String nameV = responseUser.getData().get(0).getName();
        String genderV = responseUser.getData().get(0).getGender();
        String emailV = responseUser.getData().get(0).getEmail();
        String statusV = responseUser.getData().get(0).getStatus();
        System.out.println(nameV + genderV + emailV + statusV);
        initDB.insertValues(idV, nameV,genderV, emailV, statusV);
        Assertions.assertEquals(201,responseUser.getCode());
        Assertions.assertNotNull(responseUser.getData().get(0).getId());
   }
    @Test
    void createUser400() {
        request.createNewUser400();
    }

//    @Test
//    void tooManyRequests429(){
//        ResponseRoot manyRequests = request.manyRequests429();
//        Assertions.assertEquals(429, manyRequests.getCode());
//        Assertions.assertNull(manyRequests.getMeta());
//        Assertions.assertEquals(manyRequests.getData().getMessage(), TOO_MANY_REQUESTS);
//    }
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
        Root responseUser = request.putRequest();
        Assertions.assertEquals(200,responseUser.getCode());
        Assertions.assertNotNull(responseUser.getData().get(0).getId());
    }

    @Test
    public void patchUserData() {
        Root responseUser = request.patchRequest();
        Assertions.assertEquals(200,responseUser.getCode());
        Assertions.assertNotNull(responseUser.getData().get(0).getId());
    }
    @Test
    public void deleteUserData() {
        ResponseRoot responseDeleteUser = request.deleteExistingUser();
        Assertions.assertEquals(204, responseDeleteUser.getCode());
        Assertions.assertNull(responseDeleteUser.getMeta());
        Assertions.assertNull(responseDeleteUser.getData());
    }
    @Test
    public void checkDeletedUserData() {
        ResponseRoot responseDeletedUser = request.checkDeletedUser();
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
