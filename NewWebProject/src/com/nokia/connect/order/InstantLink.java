package com.nokia.connect.order;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class InstantLink  extends Actions {
	
	private String ilLink = "http://ec2-52-63-80-249.ap-southeast-2.compute.amazonaws.com:44080/sas5";
	private String enterUsername = "username";
	private String enterPassword = "password";
	private String logInButton = "btnauthenticate";
	private String searchOrderButton = "btnclearSearchForm";
	private Properties props;
	private String orderManagement="http://ec2-52-63-80-249.ap-southeast-2.compute.amazonaws.com:44080/sas5/navigation_servlet/showOM";	
	
	public InstantLink() throws FileNotFoundException, IOException {
		super();
		props = new Properties();
		props.load(new FileInputStream("files/config.properties"));
		// TODO Auto-generated constructor stub
	}
	

	public void ilActions(){ 
		
		String driverPath = props.getProperty("driverPath");
		String order = props.getProperty("orderNo");
		openWeb(driverPath);
		openWebPage(ilLink);
		login(enterUsername, enterPassword);
		clickButton(logInButton);
		openWebPage(orderManagement);
		clickButton(searchOrderButton);
		driver.findElement(By.name("txtorderNo")).sendKeys(order);
		
	}


}
