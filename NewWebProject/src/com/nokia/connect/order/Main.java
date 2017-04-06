package com.nokia.connect.order;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main{

	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException{
		
		String xmlFile2Send = "C:\\Users\\abexa\\Documents\\Chorus\\Broadband_Connect.xml";
		
		InstantLink il = new InstantLink();
		WorkflowClient wfc = new WorkflowClient();
		
		Xml.sendXml(xmlFile2Send, true);
		il.ilFirstAction();
		wfc.wfcActions();
		il.ilSecondAction();
	}

}
