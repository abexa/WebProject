package com.nokia.connect.order;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class InstantLink  extends Actions {
	
	private String ilLink = "http://cfiwn02-app2.nz.alcatel-lucent.com:44080/sas5/";
	private String omIlLink = "http://cfiwn02-app2.nz.alcatel-lucent.com:44080/sas5/navigation_servlet/showOM";
	private String enterUsername = "username";
	private String enterPassword = "password";
	private String logInButton = "btnauthenticate";
	private String clearButton = "btnclearSearchForm";
	private String orderNoXpath = "txtorderNo";
	private String searchOrderButton = "//*[@id=\"OrdersForm\"]/div/table/tbody/tr[2]/td/table/tbody/tr/td/button[1]";
	private String table1IlXpath = "//*[@id=\"content\"]/form/table[2]";
	private String table2IlXpath = "//*[@id=\"OrdersForm\"]/table";
	private String activity = "3/3";
	private String orderStatus = "Wait for ICMS Service Order Closure";
	String xmlFile2Send = "C:\\Users\\abexa\\Documents\\Chorus\\NotifyOrderComplete.xml";
	private Properties props;	
	
	public InstantLink() throws FileNotFoundException, IOException {
		super();
		props = new Properties();
		props.load(new FileInputStream("files/config.properties"));
		// TODO Auto-generated constructor stub
	}


	public void ilFirstAction() throws InterruptedException{ 
		
		String driverPath = props.getProperty("driverPath");
		String orderNo = props.getProperty("orderNo");
		
		openWeb(driverPath);
		openWebPage(ilLink);
		login(enterUsername, enterPassword);
		clickButton(logInButton);
		openWebPage(omIlLink);
		clickButton(clearButton);
		sendKey(orderNoXpath, orderNo);
		clickButton(searchOrderButton);
		waitForActivities(activity, table2IlXpath, searchOrderButton);
		
	}
	
	public void ilSecondAction() throws InterruptedException, IOException{
		
		String orderNo = props.getProperty("orderNo");
		
		openWebPage(ilLink);
		openWebPage(omIlLink);
		clickButton(clearButton);
		sendKey(orderNoXpath, orderNo);
		clickButton(searchOrderButton);
		enterIlOrder();
		waitForStatus(orderStatus, table1IlXpath, searchOrderButton);
		Xml.sendXml(xmlFile2Send, true);
	}


}
