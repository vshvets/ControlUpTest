package com.controluptest.pages.conversions;

import com.controluptest.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UnitConversionPage extends BasePage {

    @FindBy(id = "unitFrom")
    private WebElement unitFromDropdown;

    @FindBy(id = "unitTo")
    private WebElement unitToDropdown;

    @FindBy(id = "arg")
    private WebElement inputField;

    @FindBy(id = "answerDisplay")
    private WebElement answerDisplay;


    public UnitConversionPage(WebDriver driver) {
        super(driver);
    }

    public UnitConversionPage selectUnitFrom(String unit) {
        Select select = new Select(unitFromDropdown);
        select.selectByVisibleText(unit);
        return this;
    }

    public UnitConversionPage selectUnitTo(String unit) {
        Select select = new Select(unitToDropdown);
        select.selectByVisibleText(unit);
        return this;
    }

    public UnitConversionPage enterValue(String value) {
        inputField.clear();
        inputField.sendKeys(value);
        return this;
    }

    public String getConversionResult() {
        return answerDisplay.getText();
    }
}
