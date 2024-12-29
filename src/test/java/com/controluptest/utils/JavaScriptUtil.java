package com.controluptest.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavaScriptUtil {

    private WebDriver driver;

    public JavaScriptUtil(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForOpacityChange(String className, String targetOpacity, int timeoutMillis) {
        long startTime = System.currentTimeMillis();
        long endTime = startTime + timeoutMillis;

        while (System.currentTimeMillis() < endTime) {
            String opacity = (String) ((JavascriptExecutor) driver).executeScript(
                    "return window.getComputedStyle(document.querySelector('.' + arguments[0])).getPropertyValue('opacity');", className
            );
            if (opacity.equals(targetOpacity)) {
                return;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
