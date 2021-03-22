package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.util.WaitWebDriver;

import io.appium.java_client.android.AndroidDriver;

public class CalculatorPage {

	BasePage bases = new BasePage();
	AndroidDriver<WebElement> driver = bases.connect();

	WebElement seven = driver.findElementByXPath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.Button[1]");

	WebElement three = driver.findElementByXPath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.Button[9]");

	WebElement eigth = driver.findElementByXPath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.Button[2]");

	WebElement nine = driver.findElementByXPath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.Button[3]");

	WebElement four = driver.findElementByXPath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.Button[4]");

	WebElement five = driver.findElementByXPath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.Button[5]");

	WebElement six = driver.findElementByXPath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.Button[6]");

	WebElement one = driver.findElementByXPath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.Button[7]");

	WebElement two = driver.findElementByXPath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.Button[8]");

	WebElement cero = driver.findElementByXPath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.Button[11]");

	WebElement point = driver.findElementByXPath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.Button[10]");

	WebElement results = driver.findElementByXPath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText[1]");
	
	WebElement plus = driver.findElementByXPath("//android.widget.Button[@content-desc=\"plus\"]");
	
	WebElement minus = driver.findElementByXPath("//android.widget.Button[@content-desc=\"minus\"]");

	WebElement multiply = driver.findElementByXPath("//android.widget.Button[@content-desc=\"times\"]");

	WebElement divide = driver.findElementByXPath("//android.widget.Button[@content-desc=\"divide\"]");

	WebElement delete = driver.findElementByXPath("//android.widget.Button[@content-desc=\"delete\"]");
	
	WebElement equalTo = driver.findElementByXPath("//android.widget.Button[@content-desc=\"equals\"]");

	public void presionarValores(String[] valor, WebElement element) {
		try {
			List<WebElement> xpath = relacion(valor);
			for (int i = 0; i < xpath.size(); i++) {
				xpath.get(i).click();
			}
				element.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public List<WebElement> relacion(String[] valor) {
		List<WebElement> WebElementArray = new ArrayList<WebElement>();
		for (int i = 0; i < valor.length; i++) {
			char[] numeroSeparado = valor[i].toCharArray();
			for (int j = 0; j < numeroSeparado.length; j++) {
				int inicio = 0;
				String subs = String.valueOf(numeroSeparado[j]).substring(inicio, inicio + 1);			
				int numero = Integer.parseInt(subs);
				switch (numero) {
				case 0:
					WebElementArray.add(cero);
					break;
				case 1:
					WebElementArray.add(one);
					break;
				case 2:
					WebElementArray.add(two);
					break;
				case 3:
					WebElementArray.add(three);
					break;
				case 4:
					WebElementArray.add(four);
					break;
				case 5:
					WebElementArray.add(five);
					break;
				case 6:
					WebElementArray.add(six);
					break;
				case 7:
					WebElementArray.add(seven);
					break;
				case 8:
					WebElementArray.add(eigth);
					break;
				case 9:
					WebElementArray.add(nine);
					break;
				default:
					break;
				}
				inicio++;
			}
		}
		return WebElementArray;
	}



	public WebElement operacionesMatematicas(String elemento) {
		WebElement webElement = null;
		if (elemento == "suma") {
			webElement = plus;
		}
		if (elemento == "resta") {
			webElement = minus;
		}
		if (elemento == "mult") {
			webElement = multiply;
		}
		if (elemento == "div") {
			webElement = divide;
		}
		if (elemento == "coma") {
			webElement = point;
		}
		return webElement;
	}
	
	public void ingresoNumeros(String[] array, String operacionMatematica) {
		try {
			WebElement nuevoWebElement = operacionesMatematicas(operacionMatematica);
			presionarValores(array, nuevoWebElement);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void resultado() {
		try {
			WaitWebDriver.wastingTime(driver, 5);
			equalTo.click();
			System.out.println("El resultado es: " + results.getText().toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}



}
