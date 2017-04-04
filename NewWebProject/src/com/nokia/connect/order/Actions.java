package com.nokia.connect.order;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class Actions {
	
	private static Properties props;
	
	public Actions() throws FileNotFoundException, IOException{
		props = new Properties();
		props.load(new FileInputStream("files/config.properties"));
	}
	
	public static WebDriver driver;

	public static LinkedList<OrderResponse> raspuns = new LinkedList<>();
	public static LinkedList<SearchOrder> dateRaspuns = new LinkedList<>();
	public static LinkedList<WorkflowAction> workflow = new LinkedList<>();
	//public static List <WebElement> framesList = driver.findElements(By.xpath("//iframe"));

	public static void openWeb(){
		String driverPath = props.getProperty("driverPath");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public static void openWebPage(String link){
		driver.get(link);
	}

	public static void login(){
		String enterUsername = props.getProperty("enterUsername");
		String keyToSendUser = props.getProperty("keyToSendUser");
		String enterPassword = props.getProperty("enterPassword");
		String keyToSendPass = props.getProperty("keyToSendPass");
		findElement(enterUsername).sendKeys(keyToSendUser);
		findElement(enterPassword).sendKeys(keyToSendPass);
	}

	public static WebElement findElement(String findElement){

		WebElement el = null;
		try{
			el = driver.findElement(By.id(findElement));
			if (el != null){
				return el;
			}
			else{
				el  = driver.findElement(By.name(findElement));
				if (el != null){
					return el;
				}
				else{
					el = driver.findElement(By.xpath(findElement));
					if (el != null){
						return el;
					}
					else{
						el = driver.findElement(By.tagName(findElement));
						if (el != null){
							return el;
						}
						else{
							el = driver.findElement(By.cssSelector(findElement));
							if (el != null){
								return el;
							}
						}
					}
				}
			}

		}catch(Exception e){
			
		}
		return null;
	}



	public static void takeListFromOrderIL(){
		
		String tableILOrder = props.getProperty("tableILOrder");
		WebElement tabel1 = findElement(tableILOrder);

		List<WebElement> rand = tabel1.findElements(By.tagName("tr"));

		int dimensiuneRand = rand.size();
		System.out.println("randuri: "+dimensiuneRand);

		for(int i=0;i<dimensiuneRand;i++){

			WorkflowAction wfc = new WorkflowAction();
			List<WebElement> coloana = rand.get(i).findElements(By.tagName("td"));

			int dimensiuneColoana = coloana.size();
			if(dimensiuneColoana == 0){
				continue;
			}

			for(int j=0;j<dimensiuneColoana;j++){
				String celltext = coloana.get(j).getText();
				wfc.add(i, j, celltext);
				System.out.println("Cell Value Of row number "+i+" and column number "+j+" Is "+celltext);
			}
			workflow.add(wfc);
		}
	}

	public static void getOrderFromWorkflow(String findElement){

		WebElement tabel1 = findElement(findElement);

		List<WebElement> rand = tabel1.findElements(By.tagName("tr"));

		int dimensiuneRand = rand.size();
		System.out.println("randuri: "+dimensiuneRand);

		for(int i=0;i<dimensiuneRand;i++){

			WorkflowAction wfc = new WorkflowAction();
			List<WebElement> coloana = rand.get(i).findElements(By.tagName("td"));

			int dimensiuneColoana = coloana.size();
			if(dimensiuneColoana == 0){
				continue;
			}

			for(int j=0;j<dimensiuneColoana;j++){
				String celltext = coloana.get(j).getText();
				wfc.add(i, j, celltext);
				System.out.println("Cell Value Of row number "+i+" and column number "+j+" Is "+celltext);
			}
			workflow.add(wfc);
		}
	}

	/*public static void searchElementInAllFrames(){

		WebElement frameEl = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frameEl);
		//for(WebElement frame:framesList){
		//DO something with frame
		//frame.getText();
		//}
		 * 
		 * 
		 * public void getIframe(final WebDriver driver, final String id) {
    	final List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
    	for (WebElement iframe : iframes) {
        if (iframe.getAttribute("id").equals(id)) {
        // TODO your stuff.
        }
    }
}
	}*/

	public static void waitForAlert(){

		Alert alt = driver.switchTo().alert();
		alt.accept();

	}

	public static void waitForStatus() throws InterruptedException{
		String status = props.getProperty("wfcFirstNotifyStatusOrder");
		String findElement = props.getProperty("findElement");
		getOrderFromWorkflow(findElement);
		for(WorkflowAction wla : workflow){
			try{		
				if(wla.getStatus().equals(status)){
					break;
				}
			} catch (Exception e) {
				Thread.sleep(5000);
			}
			clearAndRetry();
		}
		
	}

	private static void clearAndRetry() throws InterruptedException {
				
				String searchButton = props.getProperty("searchOrderButton");
				//clear lists
				workflow.clear();
				dateRaspuns.clear();
				raspuns.clear();

				//sleep
				Thread.sleep(5000);

				//press search for refresh
				findElement(searchButton).click();
	}
	
	public void enterOrder(){
		
		String enterOrder  = props.getProperty("enterOrder");
		String orderId = props.getProperty("OE_PRODUCT_ID");
		StringBuilder sb = new StringBuilder();
		sb.append(enterOrder).append(orderId);
	}
	private void exitOrder() {
		String goBackToOrderList = props.getProperty("goBackToOrderList");
		findElement(goBackToOrderList).click();	
	}
}
