package stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.CreateUserPage;

public class CreateUserStepDef {

    CreateUserPage createUserPage = new CreateUserPage();

    @Given("create user with valid request body")
    public void createUserWithValidRequestBody() {
        createUserPage.createUser();
    }

    @When("send request post user")
    public void sendRequestPostUser() {
        createUserPage.postUser();
    }


}
