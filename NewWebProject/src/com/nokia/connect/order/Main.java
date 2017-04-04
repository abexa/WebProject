package com.nokia.connect.order;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main{

	public static void main(String[] args) throws FileNotFoundException, IOException{

		InstantLink il = new InstantLink();
		WorkflowClient wfc = new WorkflowClient();
		
		il.ilActions();
		//wfc.wfcActions();
	}

}
