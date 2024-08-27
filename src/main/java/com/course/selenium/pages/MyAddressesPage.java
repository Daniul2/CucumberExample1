package com.course.selenium.pages;

import com.course.selenium.fragments.AddressPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.course.selenium.helpers.Helpers.waitForElementVisible;

public class MyAddressesPage {

    private final WebDriver driver;

    @FindBy(css = "a[title='Add an address']")
    private WebElement addNewAddressButton;

    @FindBy(css = ".address")
    private List<WebElement> addresses;

    public MyAddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddNewAddressButton() {
        addNewAddressButton.click();
    }

    public Map<String, String> getAddressesByAlias() {
        Map<String, String> addressesByAlias = new HashMap<>();
        for (WebElement address : addresses) {
            AddressPanel addressPanel = new AddressPanel(address);
            addressesByAlias.put(addressPanel.header, addressPanel.content);
        }
        return addressesByAlias;
    }

    public String getErrorMessage() {
        waitForElementVisible(driver, By.cssSelector(".alert-danger"));
        return driver.findElement(By.cssSelector(".alert-danger")).getText();
    }
}
