package helper;

import com.github.javafaker.IdNumber;
import com.github.javafaker.Number;
import com.github.javafaker.PhoneNumber;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static helper.Endpoint.CREATE_NEW_USERS;

import static helper.Utility.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Models {

    private static RequestSpecification request;


    public static void setUpHeaders() {
        request = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("app-id", "669939f1a325844cb69ce7cb");
    }

    public static Response getListUsers(String endpoint) {
        setUpHeaders();
        return request.when().get(endpoint);
    }

    public static Response blankHeader(String endpoint) {
        request = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json");
        return request.when().get(endpoint);
    }

    public static String setUpId(String endpoint, String user_id) {
        return endpoint + "/" + user_id;
    }

    public static Response hitUserById(String endpoint) {
        setUpHeaders();
        return request.when().get(endpoint);
    }


    public static Response hitUserParams(String endpoint, String params, String limit) {
        request = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("app-id", "669939f1a325844cb69ce7cb")
                .param("page", params)
                .param("limit", limit);

        return request.when().get(endpoint);
    }

    public static Response hitUserParamsFirstName(String endpoint, String firstName, String lastName) {
        request = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("app-id", "669939f1a325844cb69ce7cb")
                .param("firstName", firstName)
                .param("lastName", lastName);

        return request.when().get(endpoint);
    }

    public static JSONObject  postCreatNewUser() {
        String title = generateRandomTitle();
        String firstName = generateFirstName();
        String lastName = generateLastName();
        String email = generateEmails();
        String gender = generateGender();
        String phone = generatePhoneNumber();

        JSONObject payload = new JSONObject();
        payload.put("title", title);
        payload.put("firstName", firstName);
        payload.put("lastName", lastName);
        payload.put("email", email);
        payload.put("gender", gender);
        payload.put("phone", phone);
        return payload;

    }
    public static Response hitPostUser() {
        setUpHeaders();
        baseURI = CREATE_NEW_USERS;
        JSONObject payload = postCreatNewUser();
        return request.body(payload.toString()).when().post(baseURI);
    }

}
