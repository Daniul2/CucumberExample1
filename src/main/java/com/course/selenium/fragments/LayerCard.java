package com.course.selenium.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.course.selenium.helpers.Helpers.waitForElementVisible;
import static com.course.selenium.helpers.Helpers.waitForPageLoaded;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class LayerCard {

    @FindBy(css = "#layer_cart .button-medium")
    private WebElement proceedToCheckOut;

    private WebDriver driver;

    public LayerCard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitForPageLoaded(driver, By.cssSelector("#layer_cart .button-medium") ,"coderslab.pl");
    }

    public void clickProceedToCheckOut(){
        proceedToCheckOut.click();
    }

}
