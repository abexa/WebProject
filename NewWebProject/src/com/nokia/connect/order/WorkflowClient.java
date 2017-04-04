package com.nokia.connect.order;

import java.io.FileNotFoundException;
import java.io.IOException;

public class WorkflowClient extends Actions{
	
	private String wfcLink = "http://cfiwn02-app2.nz.alcatel-lucent.com:44380/wfc_ui";

	
	public WorkflowClient() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public void wfcActions(){ 
		
		openWebPage(wfcLink);
		login();
	
	}
}
