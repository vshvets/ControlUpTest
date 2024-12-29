package com.controluptest.tests.convertions;

import com.controluptest.pages.conversions.HomePageConversions;
import com.controluptest.pages.conversions.UnitConversionPage;
import com.controluptest.tests.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class ConversionTests extends BaseTest {

    @BeforeMethod
    public void navigateToUnitConversionBaseUrl() {
        navigateToBaseUrl("unitConversionBaseUrl");
        HomePageConversions homePage = new HomePageConversions(driver);
        homePage.handleCookies();
    }

    @Test
    public void testCelsiusToFahrenheitConversion() {
        UnitConversionPage conversionPage = new UnitConversionPage(driver);
        HomePageConversions homePage = new HomePageConversions(driver);

        homePage.openTemperatureConversion();
        String result = conversionPage
                .selectUnitFrom("Celsius")
                .selectUnitTo("Fahrenheit")
                .enterValue("100")
                .getConversionResult();

        Assert.assertEquals(result, "100°C = 212.00°F", "Conversion result is incorrect!");
    }

    @Test
    public void testMetersToFeetConversion() {
        HomePageConversions homePage = new HomePageConversions(driver);
        UnitConversionPage conversionPage = new UnitConversionPage(driver);

        homePage.openLengthConversion();
        String result = conversionPage
                .selectUnitFrom("Meters")
                .selectUnitTo("Feet")
                .enterValue("1")
                .getConversionResult();

        Assert.assertEquals(result, "1m = 3.2808ft", "Conversion result is incorrect!");
    }

    @Test
    public void testOuncesToGramsConversion() {
        HomePageConversions homePage = new HomePageConversions(driver);
        UnitConversionPage conversionPage = new UnitConversionPage(driver);

        homePage.openWeightConversion();
        String result = conversionPage
                .selectUnitFrom("Ounces")
                .selectUnitTo("Grams")
                .enterValue("1")
                .getConversionResult();

        Assert.assertEquals(result, "1oz = 28.349g", "Conversion result is incorrect!");
    }
}
