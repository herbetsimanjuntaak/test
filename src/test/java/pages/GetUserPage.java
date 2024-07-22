package pages;

import helper.Endpoint;
import helper.Models;
import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.File;

import static helper.Models.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class GetUserPage {

    String setUpUrl, finalEndpoint;

    Response res;


    public void prepareUrlFor(String url) {
        switch (url) {
            case "GET_LIST_USERS":
                setUpUrl = Endpoint.GET_LIST_USERS;
                break;
            case "GET_LIST_USER_BY_ID":
                setUpUrl = Endpoint.GET_LIST_USERS_ID;
                break;
            case "CREATE_NEW_USERS":
                setUpUrl = Endpoint.CREATE_NEW_USERS;
                break;
            case "DELETE_USERS":
                setUpUrl = Endpoint.DELETE_USERS;
                break;
            case "POST_USERS":
                setUpUrl = Endpoint.POST_USERS;
                break;
            case "PATCH_USERS":
                setUpUrl = Endpoint.PATCH_USERS;
                break;
            case "PUT_USERS":
                setUpUrl = Endpoint.PUT_USERS;
                break;
            case "GET_DATA_WRONG_ID":
                setUpUrl = Endpoint.GET_DATA_WRONG_ID;
                break;
            case "GET_ENDPOINT_WRONG":
                setUpUrl = Endpoint.GET_ENDPOINT_WRONG;
                break;
            default:
                System.out.println("input valid url :)");
        }
    }

    public void hitAPIGetListUsers() {
        res = Models.getListUsers(setUpUrl);
    }

    public void hitAPIBlankHeader() {
        res = Models.blankHeader(setUpUrl);
    }

    public void validationStatusCodeIsEquals(Integer status_code) {
        assertThat(res.statusCode()).isEqualTo(status_code);
    }

    public void validationResponseBodyGetListUsers() {
        String id = res.jsonPath().getString("data[0].id");
        String title = res.jsonPath().getString("data[0].title");
        String firstName = res.jsonPath().getString("data[0].firstName");
        String lastName = res.jsonPath().getString("data[0].lastName");

        assertThat(id).isNotNull();
        assertThat(title).isNotNull();
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();

        String responseBody = res.getBody().asString();
        Assert.assertTrue(responseBody.contains("data"));

        System.out.println(responseBody);

    }

    public void validationResponseJsonWithJSONSchema(String fileName) {
        File JSONFile = Utility.getJSONSchemaFile(fileName);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

    public void prepareValidId(String id) {
        finalEndpoint = setUpId(setUpUrl, id);
    }

    public void hitAPIGetUserById() {
        res = hitUserById(finalEndpoint);
    }

    public void validationResponseBodyGetUserById() {
        String firstName = res.jsonPath().getString("firstName");
        assertThat(firstName).isIn("Edita");

        String responseBody = res.getBody().asString();
        Assert.assertTrue(responseBody.contains("Edita"));
        System.out.println(responseBody);
    }

    public void responseBodyInvalidEndpoint() {
        String responseBody = res.getBody().asString();
        Assert.assertTrue(responseBody.contains("error"));
    }

    public void hitAPIGetListUsersWithParams(String params, String limit) {
        res = hitUserParams(setUpUrl, params, limit);
        System.out.println(res.getBody().asString());
    }

    public void hitAPIGetListUsersWithParamFirstName(String firstName, String lastName) {
        res = hitUserParamsFirstName(setUpUrl, firstName, lastName);
        System.out.println(res.getBody().asString());
    }

    public void validateParams(String firstName, String lastName) {
        String responseBody = res.getBody().asString();
        assertTrue(responseBody.contains(firstName));
        assertTrue(responseBody.contains(lastName));
        System.out.println(res.getBody().asString());
        System.out.println(firstName + " dan ini adalah " + lastName);
    }

    public void validatePage(String page, String limit) {
        String pages = res.jsonPath().getString("page");
        String limits = res.jsonPath().getString("limit");
        assertThat(pages).isIn(page);
        assertThat(limits).isIn(limit);
        System.out.println("page respon = " + pages);
        System.out.println("limits respon = " + limits);
    }

}
