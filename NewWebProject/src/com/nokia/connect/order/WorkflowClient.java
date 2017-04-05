package com.nokia.connect.order;

import java.io.FileNotFoundException;
import java.io.IOException;

public class WorkflowClient extends Actions{
	
	private String wfcLink = "http://cfiwn02-app2.nz.alcatel-lucent.com:44380/wfc_ui";
	private String logInButton = "//*[@id=\"login-table-background\"]/table[2]/tbody/tr/td/button[1]";
	private String enterUsername = "j_username";
	private String enterPassword = "j_password";
	private String workQueueXpath = "//*[@id=\"mainForm\"]/table/tbody/tr/td/table[2]/tbody/tr[1]/td/div[1]/a";
	private String clearButton = "//*[@id=\"mainForm:workspace_working_area_view:_idJsp59\"]";
	private String productIdXpath = "//*[@id=\"mainForm:workspace_working_area_view:additionalSearchFields_14\"]";
	private String searchButton = "//*[@id=\"mainForm:workspace_working_area_view:_idJsp58\"]";
	private String wfcFirstNotifyStatusOrder = "Notify Activate NGB Circuit Fallout";
	private String wfcSecondNotifyStatusOrder = "Wait For Manual Activation";	
	private String tableWfcXpath = "//*[@id=\"mainForm:workspace_working_area_view:actionTicketListingTable\"]";
	
	
	public WorkflowClient() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public void wfcActions(){ 
		
		openWebPage(wfcLink);
		login(enterUsername, enterPassword);
		clickButton(logInButton);
		
	}
}
