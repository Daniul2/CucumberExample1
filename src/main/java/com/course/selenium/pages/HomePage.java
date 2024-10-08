package com.course.selenium.pages;

import com.course.selenium.fragments.NavBar;
import com.course.selenium.fragments.SelectHotel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.helpers.Helpers.waitForPageLoaded;

public class HomePage {

    public NavBar navbar;
    public SelectHotel selectHotel;
    private final WebDriver driver;
    @FindBy(css = ".hide_xs")
    WebElement singInLink;

    @FindBy(id = "hotel_cat_name")
    WebElement dropdownArrow;

    @FindBy(id = "hotel_location")
    private WebElement hotelLocationInput;

    @FindBy(id = "check_in_time")
    private WebElement checkInTimeInput;

    @FindBy(id = "check_out_time")
    private WebElement checkOutTimeInput;

    @FindBy(id = "search_room_submit")
    private WebElement searchHotelButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitForPageLoaded(driver, By.cssSelector(".hide_xs"),"hotel-testlab.coderslab.pl");
        navbar = new NavBar(this.driver);
    }

    public void clickSingIn(){
        singInLink.click();
    }

    public void selectHotelCategoryByName(String categoryName) {
        dropdownArrow.click();
        String expression = String.format("//li[text()='%s']", categoryName);
        WebElement category = driver.findElement(By.xpath(expression));
        category.click();
    }

    public void typeLocation(String location) {
        hotelLocationInput.clear();
        hotelLocationInput.sendKeys(location);
    }
    public void typeCheckInDate(String ddMMyyyy) {
        checkInTimeInput.clear();
        checkInTimeInput.sendKeys(ddMMyyyy);
    }

    public void typeCheckOutDate(String ddMMyyyy) {
        checkOutTimeInput.clear();
        checkOutTimeInput.sendKeys(ddMMyyyy);
    }

    public void clickSearchButton() {
        searchHotelButton.click();
    }


    public void moveToSingInAndHold() throws InterruptedException {

        Actions action= new Actions(driver);

        action.clickAndHold(singInLink)
                .moveToElement(singInLink)
                .pause(java.time.Duration.ofSeconds(5))
                .release()
                .build()
                .perform();
    }
}
