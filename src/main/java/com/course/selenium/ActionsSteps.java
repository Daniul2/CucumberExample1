package com.course.selenium;

import com.course.selenium.helpers.BrowserFactory;
import com.course.selenium.pages.HomePage;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class ActionsSteps {
    private final WebDriver driver = BrowserFactory.getDriver();


    @Given("the user move mouse to SingInButton and Holds")
    public void theUserMoveMouseToSingInButtonAndHolds() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.moveToSingInAndHold();
    }


}
