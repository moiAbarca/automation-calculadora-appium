package com.util;

import com.google.gson.Gson;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Utilities {
    
    public static boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean verifyText(WebDriver driver, String text) {
        try {
            return driver.findElement(By.xpath("//*[text()='" + text + "']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean verifyContainsText(WebDriver driver, String text) {
        try {
            return driver.findElement(By.xpath("//*[contains(text(),'" + text + "')]")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public static void loadingSpinnerVisibility(WebDriver driver) {
        try {
            WebElement loadingSpinner = driver
                    .findElement(By.xpath("//*[@class='fbra_loadingSpinner__arc fbra_test_loadingSpinner__arc']"));
            WaitWebDriver.waitVisibility(driver, loadingSpinner, 10);
        } catch (Exception e) {
        }
    }

    public static void fakeThreadSleep(WebDriver driver, int time) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//html")));
        } catch (Exception e) {
            e = null;
        }
    }

    public static void clickHiddenElement(WebDriver driver, WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", webElement);
    }

    public static void clickMobileAndWeb(WebDriver driver, WebElement webElement) {
        if (System.getProperty("dlx.device").equals(null))
            webElement.click();
        else {
            TouchActions actions = new TouchActions(driver);
            actions.singleTap(webElement);
        }
    }

    public static void scrollToAnElement(WebDriver driver, WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public static void scrollToAnLocator(WebDriver driver, String locator) {
        WebElement webElement = driver.findElement(By.xpath(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public static void switchToIframeById(WebDriver driver, String id) {
        driver.switchTo().frame(driver.findElement(By.id(id)));
    }

    public static void switchToIframeByXpath(WebDriver driver, String xpath) {
        driver.switchTo().frame(driver.findElement(By.xpath(xpath)));
    }

    public static void switchToIframeByName(WebDriver driver, String name) {
        driver.switchTo().frame(driver.findElement(By.name(name)));
    }

    public static String randomNum(int largo) {
        String SALTCHARS = "1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < largo) { // length of the random string.
            if (salt.length() == 1) {
                SALTCHARS = "0123456789";
            }
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    public static boolean generaJson(Object objeto, String rutaJson) {
        try {
            Gson gson = new Gson();
            final String cadenaJson = gson.toJson(objeto);
            System.out.println("datosJson: " + cadenaJson);
            FileWriter fileWriter = new FileWriter(rutaJson);
            fileWriter.write(cadenaJson);
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
 // refrezca la pag
 	public static void refresh(WebDriver driver) {
 		try {
 			driver.navigate().refresh();

 			driver.switchTo().alert().accept();
 		} catch (Exception e) {
 		}
 		WaitWebDriver.waitLoadingWrapper(driver);
 	}
 	
}
