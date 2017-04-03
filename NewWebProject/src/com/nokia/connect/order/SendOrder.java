package com.nokia.connect.order;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SendOrder  extends Actions {

	public SendOrder() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void sendOrder(){ 
	
		openWeb();
		openWebPage("http://ec2-52-63-80-249.ap-southeast-2.compute.amazonaws.com:44080/sas5");
		login();
	 
	}
}
