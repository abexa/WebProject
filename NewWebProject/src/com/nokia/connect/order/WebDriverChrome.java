package com.nokia.connect.order;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverChrome {
	
	private static ChromeDriver webDriver;
	
	public static ChromeDriver getWebDriver() throws FileNotFoundException, IOException {
		Properties props = new Properties();
		props.load(new FileInputStream("files/config.properties"));
		if (webDriver == null ){
			String driverPath = props.getProperty("driverPath");
			System.setProperty("webdriver.chrome.driver", driverPath);
			webDriver = new ChromeDriver();
			webDriver.manage().window().maximize();
		}
		
		return webDriver;
	} 
	
	
}
