package com.epam.ta.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWaits {
    private static final int WAIT_TIMEOUT_SECONDS = 10;

    public static void waitForPageLoaded(WebDriver driver){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(CustomConditions.waitForLoad());
    }

    public static void waitForElementClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .refreshed(ExpectedConditions.or(
                                ExpectedConditions.elementToBeClickable(element))));
    }

    public static void waitForElementLocated(WebDriver driver, String xpath){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
    }
}
