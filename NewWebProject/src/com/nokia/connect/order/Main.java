package com.nokia.connect.order;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main{

	public static void main(String[] args) throws FileNotFoundException, IOException{
		
		SendOrder so = new SendOrder();
		so.sendOrder();
		so.enterOrder();
	}

}
