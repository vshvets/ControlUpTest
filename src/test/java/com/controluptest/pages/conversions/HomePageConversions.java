package com.controluptest.pages.conversions;

import com.controluptest.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageConversions extends BasePage {

    @FindBy(xpath = "//a[@title='Temperature Conversion']")
    private WebElement temperatureLink;

    @FindBy(xpath = "//a[@title='Weight Conversion']")
    private WebElement weightLink;

    @FindBy(xpath = "//a[@title='Length Conversion']")
    private WebElement lengthLink;

    @FindBy(id = "ez-accept-all")
    private WebElement cookiesBanner;

    public HomePageConversions(WebDriver driver) {
        super(driver);
    }

    public void handleCookies() {
        waitForClickability(cookiesBanner);
        cookiesBanner.click();
    }

    public HomePageConversions openTemperatureConversion() {
        waitForClickability(temperatureLink);
        temperatureLink.click();
        return this;
    }

    public HomePageConversions openWeightConversion() {
        waitForClickability(weightLink);
        weightLink.click();
        return this;
    }

    public HomePageConversions openLengthConversion() {
        waitForClickability(lengthLink);
        lengthLink.click();
        return this;
    }
}
