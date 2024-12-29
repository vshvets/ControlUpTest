package com.controluptest.pages.weather;

import com.controluptest.pages.BasePage;
import com.controluptest.utils.JavaScriptUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;

public class WeatherHomePage extends BasePage {

    @FindBy(id = "LocationSearch_input")
    private WebElement searchInput;

    @FindBy(id = "LocationSearch_listbox")
    private WebElement dropdownContainer;

    @FindBy(xpath = "//div[@aria-label='Saved Locations']//span[contains(@class, 'styles--temperature')]")
    private WebElement сurrentPlaceTemperature;

    @FindBy(xpath = "//iframe[contains(@title, 'Consent Message')]")
    private WebElement cookiesIframe;

    @FindBy(xpath = "//button[@title='Accept all']")
    private WebElement acceptCookiesButton;

    public WeatherHomePage(WebDriver driver) {
        super(driver);
    }

    public void handleCookies() {
            waitForVisibility(cookiesIframe);
            driver.switchTo().frame(cookiesIframe);

            waitForClickability(acceptCookiesButton);
            acceptCookiesButton.click();

            driver.switchTo().defaultContent();

            JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
            jsUtil.waitForOpacityChange("styles--LocalsuiteNav--SniWc", "0", 10000);
    }

    public WeatherHomePage searchPlace(String zipCode, String location) {
        waitForClickability(searchInput);
        searchInput.sendKeys(zipCode);
        waitForVisibility(dropdownContainer);
        WebElement locationOption = dropdownContainer.findElement(By.xpath(String.format(".//button[contains(text(), '%s')]", location)));
        waitForClickability(locationOption);
        locationOption.click();
        return this;
    }

    public BigDecimal getCurrantPlaceTemperature() {
        String temperatureText = сurrentPlaceTemperature.getText();
        return new BigDecimal(temperatureText.replace("°", "").trim());
    }
}
