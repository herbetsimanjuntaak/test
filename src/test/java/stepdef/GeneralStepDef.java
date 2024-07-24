package stepdef;

import helper.Models;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pages.CreateUserPage;

import static helper.Models.resStatusCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeneralStepDef  {

    @Then("should return status code {int}")
    public void shouldReturnStatusCode(int status_code) {
        System.out.println(resStatusCode);
        System.out.println(status_code);
        assertThat(resStatusCode).isEqualTo(status_code);
    }

}
