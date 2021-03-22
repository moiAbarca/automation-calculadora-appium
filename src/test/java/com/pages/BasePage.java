package com.pages;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BasePage {

	public AndroidDriver connect() {
		try {
			DesiredCapabilities dc = new DesiredCapabilities();

			dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
			dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5556"); // Android Emulator
			dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
			dc.setCapability(MobileCapabilityType.NO_RESET, true);
			dc.setCapability("appPackage", "com.android.calculator2");
			dc.setCapability("appActivity", "com.android.calculator2.Calculator");
			dc.setCapability("noSign", true);
			dc.setCapability("autoGrantPermissions", true); // (you can get it from apk info app)

			URL url = new URL("http://127.0.0.1:4723/wd/hub");

			AndroidDriver driver = new AndroidDriver(url, dc);
			return driver;
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}

	}

}
