package com.amazon.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Driver {
	
	

	private Driver() {
	}

	private static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			//String browser = System.getProperty("browser")
			//!=null? System.getProperty("browser"): ConfigurationReader.getProperty("browser");
			switch (ConfigurationReader.getProperty("browser")) {
			case "firefox":
				String firefoxPath = "/Users/imran/eclipse-workspace/XXXX/src/test/resources/drivers/geckodriver";
				System.setProperty("webdriver.gecko.driver", firefoxPath);
				driver = new FirefoxDriver();
				break;
			case "chrome":
				String chromePath = "/Users/imran/eclipse-workspace/XXXX/src/test/resources/drivers/chromedriver";
				System.setProperty("webdriver.gecko.driver", chromePath);
				driver = new ChromeDriver();
				break;
			}
		}
		return driver;
	}

	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
