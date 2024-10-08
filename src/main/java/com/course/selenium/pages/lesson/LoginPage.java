package com.course.selenium.pages.lesson;

import com.course.selenium.helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.helpers.Helpers.waitForPageLoaded;

public class LoginPage {

    @FindBy(css = "#field-email")
    WebElement emailInput;
    @FindBy(css = "#field-password")
    WebElement passwordInput;
    @FindBy(css = "#submit-login")
    WebElement signInButton;

    private final WebDriver driver;

    private By locatorEmailInput = By.cssSelector("#field-email");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        waitForPageLoaded(this.driver, By.cssSelector("#field-email"), "controller=authentication");
        PageFactory.initElements(this.driver, this);
    }

    public void loginAs(String mail, String password) {
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(mail);

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        signInButton.click();
    }

}
