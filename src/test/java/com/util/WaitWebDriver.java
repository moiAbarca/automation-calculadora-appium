package com.util;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class WaitWebDriver {

    public WaitWebDriver() {
        super();
    }

    public static void waitVisibility(WebDriver driver, WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitClickable(WebDriver driver, WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitSelected(WebDriver driver, WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }

    public static void waitAlert(WebDriver driver, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void waitInvisibility(WebDriver driver, WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitLoadingWrapper(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement elementX = driver.findElement(By.xpath("//div[@class='fbra_loadingWrapper__overlay'] | //*[@class = 'blockUI blockMsg blockPage'] | //*[@class='blockUI blockOverlay']"));
            WaitWebDriver.waitVisibility(driver, elementX, 4);
            wait.until(ExpectedConditions.invisibilityOf(elementX));
        } catch (Exception e) {
            System.out.println("Loading wrapper timeout");
        }
    }

    public static void waitSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitVisibilitys(WebDriver driver, List<WebElement> element, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public static boolean isAlertPresent(WebDriver driver) {
        boolean presentFlag = false;
        try {
            // Check the presence of alert
            Alert alert = driver.switchTo().alert();
            // Alert present; set the flag
            presentFlag = true;
            // if present consume the alert
            alert.accept();
            System.out.println("Click Alert");
        } catch (NoAlertPresentException ex) {
            ex = null;
        }
        return presentFlag;
    }

    public static void textToBePresentInElement(WebDriver driver, String mensaje, WebElement elemento, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.textToBePresentInElement(elemento, mensaje));
    }
    public static void wastingTime(WebDriver driver, int seconds) {
		try {
			WaitWebDriver.waitVisibility(driver, driver.findElement(By.xpath("//p[@id='This-is-a-lie']")), seconds);
		} catch (Exception e) {
		}
	}
    
}
