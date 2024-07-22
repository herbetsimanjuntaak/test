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


public class CreateUserPage {


    public Response res;


    public void createUser(){
        postCreatNewUser();
    }

    public void postUser(){
        res = hitPostUser();
        System.out.println(res.getBody().asString());
    }

    public void validationStatusCodeIsEquals(Integer status_code) {
        assertThat(res.statusCode()).isEqualTo(status_code);
    }
}
