package com.nokia.connect.order;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class InstantLink  extends Actions {
	
	private String ilLink = "http://ec2-52-63-80-249.ap-southeast-2.compute.amazonaws.com:44080/sas5";
	private String logInButton = "btnauthenticate";
	private String searchOrderButton = "";
	private Properties props;	
	
	public InstantLink() throws FileNotFoundException, IOException {
		super();
		props = new Properties();
		props.load(new FileInputStream("files/config.properties"));
		// TODO Auto-generated constructor stub
	}
	

	public void ilActions(){ 
		
		String driverPath = props.getProperty("driverPath");
		
		openWeb(driverPath);
		openWebPage(ilLink);
		login();
		clickButton(logInButton);
	}


}
