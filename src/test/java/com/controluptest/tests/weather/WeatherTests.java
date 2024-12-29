package com.controluptest.tests.weather;

import com.controluptest.pages.weather.WeatherHomePage;
import com.controluptest.tests.BaseTest;
import com.controluptest.utils.WeatherApiClient;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class WeatherTests extends BaseTest {
   private WeatherHomePage weatherHomePage;

    @BeforeMethod
    public void navigateToUnitConversionBaseUrl() {
        navigateToBaseUrl("weatherBaseUrl");
        weatherHomePage = new WeatherHomePage(driver);
        weatherHomePage.handleCookies();
    }

    @Test
    public void testSearchForZipCode() {
        weatherHomePage.searchPlace("20852", "North Bethesda, MD");
        BigDecimal temperatureFahrenheit = weatherHomePage.getCurrantPlaceTemperature();
        BigDecimal apiTemperatureFahrenheit = WeatherApiClient.getCurrentTemperatureFahrenheit("20852");

        BigDecimal difference = temperatureFahrenheit.subtract(apiTemperatureFahrenheit).abs();
        BigDecimal tolerance = apiTemperatureFahrenheit.multiply(new BigDecimal("0.10"));

        Assert.assertTrue(difference.compareTo(tolerance) <= 0, "The temperature difference is more than 10%");
    }
}
