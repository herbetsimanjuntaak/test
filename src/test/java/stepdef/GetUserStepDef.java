package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.GetUserPage;

public class GetUserStepDef {

    GetUserPage getUserPage;

    public GetUserStepDef() {
        this.getUserPage = new GetUserPage();
    }

    @Given("prepare url for {string}")
    public void prepareUrlFor(String url) {
        getUserPage.prepareUrlFor(url);
    }

    @And("hit API get list users")
    public void hitAPIGetListUsers() {
        getUserPage.hitAPIGetListUsers();
    }

    @Then("validation status code is equals {int}")
    public void validationStatusCodeIsEquals(int statusCode) {
        getUserPage.validationStatusCodeIsEquals(statusCode);
    }

    @Then("validation response body get list users")
    public void validationResponseBodyGetListUsers() {
        getUserPage.validationResponseBodyGetListUsers();
    }

    @Then("validation response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String fileName) {
        getUserPage.validationResponseJsonWithJSONSchema(fileName);
    }

    @And("prepare valid id {string}")
    public void prepareValidId(String user_id) {
        getUserPage.prepareValidId(user_id);
    }

    @And("hit API get user by id")
    public void hitAPIGetUserById() {
        getUserPage.hitAPIGetUserById();
    }

    @Then("validation response body get user by id")
    public void validationResponseBodyGetUserById() {
        getUserPage.validationResponseBodyGetUserById();
    }

    @Then("validation response body wrong id")
    public void validationResponseBodyWrongId() {
        getUserPage.responseBodyInvalidEndpoint();
    }

    @And("hit API get list user with parameters {string} and {string}")
    public void hitAPIGetListUserWithParametersAnd(String page, String limit) {
        getUserPage.hitAPIGetListUsersWithParams(page, limit);
    }

    @And("hit API get list user with parameters {string}")
    public void hitAPIGetListUserWithParameters(String firstName, String lastName) {
        getUserPage.hitAPIGetListUsersWithParamFirstName(firstName, lastName);
    }

    @Then("validation response body invalid endpoint")
    public void validationResponseBodyInvalidEndpoint() {
        getUserPage.responseBodyInvalidEndpoint();
    }

    @And("hit API get blank header")
    public void hitAPIGetBlankHeader() {
        getUserPage.hitAPIBlankHeader();
    }

    @And("validate data should be contain {string} and {string}")
    public void validateDataShouldBeContainAnd(String firstName, String lastName) {
        getUserPage.validateParams(firstName, lastName);
    }

    @And("validate data user should be contain {string} and {string}")
    public void validateDataUserShouldBeContainAnd(String page, String limit) {
        getUserPage.validatePage(page, limit);
    }
}
