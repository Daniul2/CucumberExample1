package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.helpers.Helpers.waitForPageLoaded;

public class AddressFormPage {

    @FindBy(id = "address1")
    private WebElement addressLine1Input;

    @FindBy(id = "postcode")
    private WebElement postalCodeInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "phone")
    private WebElement homePhoneInput;

    @FindBy(id = "alias")
    private WebElement aliasInput;

    @FindBy(id = "submitAddress")
    private WebElement saveButton;


    public AddressFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        waitForPageLoaded(driver, By.cssSelector("#address1"), "address");
    }

    public void typeAddressLine(String line) {
        addressLine1Input.clear();
        addressLine1Input.sendKeys(line);
    }

    public void typePostalCode(String postalCode) {
        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);
    }

    public void typeCity(String city) {
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void typeHomePhone(String phone) {
        homePhoneInput.clear();
        homePhoneInput.sendKeys(phone);
    }

    public void typeAlias(String alias) {
        aliasInput.clear();
        aliasInput.sendKeys(alias);
    }

    public void clickSaveButton() {
        saveButton.click();
    }
}
