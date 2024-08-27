package com.course.selenium;

import com.course.selenium.helpers.BrowserFactory;
import com.course.selenium.pages.AuthPage;
import com.course.selenium.pages.CreateAccountPage;
import com.course.selenium.pages.HomePage;
import com.course.selenium.pages.MyAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static com.course.selenium.helpers.Helpers.getRandomEmail;

public class AccountRegistrationSteps {

    private final WebDriver driver = BrowserFactory.getDriver();

    AuthPage authPage;
    CreateAccountPage createAccountPage;
    MyAccountPage myAccountPage;

    @Given("the user is on the authentication page")
    public void theUserIsOnTheAuthenticationPage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSingIn();

        authPage = new AuthPage(driver);
    }

    @When("the user types a random email into the create account email input")
    public void theUserTypesARandomEmailIntoTheCreateAccountEmailInput() {
        authPage.typeEmailIntoCreateAccount(getRandomEmail());
    }

    @And("the user clicks on the create an account button")
    public void theUserClicksOnTheCreateAnAccountButton() {
        authPage.clickCreateAccountButton();
    }

    @And("the user fills the required fields on the create account form")
    public void theUserFillsTheRequiredFieldsOnTheCreateAccountForm() {
        createAccountPage = new CreateAccountPage(driver);
        createAccountPage.typeFirstName("John");
        createAccountPage.typeLastName("Doe");
        createAccountPage.typePassword("s3cret");
    }

    @And("the user clicks the register button")
    public void theUserClicksTheRegisterButton() {
        createAccountPage = new CreateAccountPage(driver);
        createAccountPage.clickRegisterButton();
    }

    @Then("the user should be logged in their account page")
    public void theUserShouldBeLoggedInTheirAccountPage() {
        myAccountPage = new MyAccountPage(driver);
    }

    @And("the account page should display welcome message {string}")
    public void theAccountPageShouldDisplayWelcomeMessage(String arg0) {
        Assert.assertEquals(arg0, myAccountPage.getSuccessMessage());
    }

    @When("the user types an existing email {string} into the create account email input")
    public void theUserTypesAnExistingEmailIntoTheCreateAccountEmailInput(String arg0) {
        authPage.typeEmailIntoCreateAccount(arg0);
    }

    @Then("the page should display error {string}")
    public void thePageShouldDisplayError(String arg0) {
        Assert.assertEquals(arg0,
                authPage.getErrorMessage());
    }

    @Then("the input email contains error border")
    public void theInputIsMarkedWithRedBorder() {
        authPage.shouldEmailCreateError();
    }

    @And("the user fills the create account form with {string}, {string}, {string}")
    public void theUserFillsTheCreateAccountFormWith(String firstName, String lastName, String password) {
        createAccountPage = new CreateAccountPage(driver);
        createAccountPage.typeFirstName(firstName);
        createAccountPage.typeLastName(lastName);
        createAccountPage.typePassword(password);
    }
}
