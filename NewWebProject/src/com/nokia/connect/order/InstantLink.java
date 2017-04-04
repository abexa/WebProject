package com.nokia.connect.order;

import java.io.FileNotFoundException;
import java.io.IOException;

public class InstantLink  extends Actions {
	
	private String ilLink = "http://ec2-52-63-80-249.ap-southeast-2.compute.amazonaws.com:44080/sas5";
	private String driverPath = "C:\\Users\\abexa\\Documents\\Chorus\\chromedriver.exe";
	private String logInButton = "btnauthenticate";
	private String searchOrderButton = "";
	
	public InstantLink() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public void ilActions(){ 
	
		openWeb(driverPath);
		openWebPage(ilLink);
		login();
		clickButton(logInButton);
	}


}
