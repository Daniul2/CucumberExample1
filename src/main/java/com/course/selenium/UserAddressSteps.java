package com.course.selenium;

import com.course.selenium.helpers.BrowserFactory;
import com.course.selenium.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static com.course.selenium.helpers.Helpers.getRandomAlias;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserAddressSteps {

    private final WebDriver driver = BrowserFactory.getDriver();

    private HomePage homePage;
    AuthPage authPage;
    private MyAccountPage myAccountPage;
    private MyAddressesPage myAddressesPage;
    private AddressFormPage addressFormPage;

    private String addressAlias;

    @Given("a logged in user is on the home page")
    public void aLoggedInUserIsOnTheHomePage() {
        homePage = new HomePage(driver);
        homePage.clickSingIn();

        authPage = new AuthPage(driver);
        authPage.typeEmailIntoLogin("foo@bar.com");
        authPage.typePasswordIntoLogin("foobar");
        authPage.clickSingInButton();

        myAccountPage = new MyAccountPage(driver);
        myAccountPage.navbar.clickLogo();


    }

    @And("the user chooses Accounts from the navbar dropdown")
    public void theUserChoosesAccountsFromTheNavbarDropdown() {
        homePage = new HomePage(driver);
        homePage.navbar.toggleUserDropdown();
        homePage.navbar.selectAccounts();

    }

    @And("the user clicks My Addresses on my account page")
    public void theUserClicksMyAddressesOnMyAccountPage() {
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickMyAddresses();

    }

    @When("the user click Add a new address button")
    public void theUserClickAddANewAddressButton() {
        myAddressesPage = new MyAddressesPage(driver);
        myAddressesPage.clickAddNewAddressButton();

    }

    @And("the user fills the address form")
    public void theUserFillsTheAddressForm() {
        addressAlias = getRandomAlias();

        addressFormPage = new AddressFormPage(driver);
        addressFormPage.typeAddressLine("Prosta 51");
        addressFormPage.typePostalCode("00-838");
        addressFormPage.typeCity("Warszawa");
        addressFormPage.typeHomePhone("555-555-123");
        addressFormPage.typeAlias(addressAlias);
    }

    @And("the user clicks the Save button")
    public void theUserClicksTheSaveButton() {
        addressFormPage =  new AddressFormPage(driver);
        addressFormPage.clickSaveButton();

    }

    @Then("my addresses page should include the new address")
    public void myAddressesPageShouldIncludeTheNewAddress() {
        myAddressesPage = new MyAddressesPage(driver);
        Map<String, String> addressesByAlias = myAddressesPage.getAddressesByAlias();
        String key = addressAlias.toUpperCase();
        assertTrue(addressesByAlias.containsKey(key));
        assertEquals("Foo Bar Prosta 51 00-838 Warszawa Poland 555-555-123", addressesByAlias.get(key));
    }

    @Then("the MyAddresses page should display error {string}")
    public void theMyAddressesPageShouldDisplayError(String arg0) {
        Assert.assertTrue(myAddressesPage.getErrorMessage().contains(arg0));
    }
}
