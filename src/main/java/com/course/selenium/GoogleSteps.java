package com.course.selenium;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSteps {

    private WebDriver driver;

    @Given("an open browser with google.com")
    public void anOpenBrowserWithGoogleCom() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
        WebElement elementCookiesWindow = driver.findElement(By.xpath("//button/*[contains(text(),'Zaakceptuj')]"));
        elementCookiesWindow.click();
    }

    @When("a {string} selenium is entered in input field")
    public void aKeywordSeleniumIsEnteredInInputField(String keyword) {
        WebElement element = driver.findElement(By.name("q"));
        element.clear();
        element.sendKeys(keyword);
        element.submit();
    }



    @And("close browser")
    public void closeBrowser() {
        driver.quit();
    }

    @Then("the first one should contain {string}")
    public void theFirstOneShouldContain(String arg0) {
        Assert.assertTrue(driver.findElement(By.cssSelector(".a4bIc #APjFqb")).getText().contains(arg0));
    }
}
