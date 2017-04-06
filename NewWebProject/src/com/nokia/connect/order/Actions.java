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

	private Properties props;
	protected String keyToSendUser = "Administrator";
	protected String keyToSendPass = "guiadmin";

	public Actions() throws FileNotFoundException, IOException {
		props = new Properties();
		props.load(new FileInputStream("files/config.properties"));
	}

	public WebDriver driver;

	public LinkedList<OrderResponse> raspuns = new LinkedList<>();
	public LinkedList<SearchOrder> dateRaspuns = new LinkedList<>();
	public LinkedList<WorkflowObject> workflow = new LinkedList<>();
	private int primul;
		
	public void openWeb(String driverPath) {

		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void openWebPage(String link) {
		driver.get(link);
	}

	public void login(String enterUsername, String enterPassword) {

		sendKey(enterUsername, keyToSendUser);
		sendKey(enterPassword, keyToSendPass);
	}

	public WebElement findElement(String findElement) {

		final List<WebElement> iframes = driver.findElements(By.tagName("frameset"));
		final List<WebElement> wfcFrames = driver.findElements(By.tagName("iframe"));
		WebElement el = null;

		if (iframes.size() != 0) {
			for (WebElement iframe : iframes) {
				List<WebElement> frame = driver.findElements(By.tagName("frame"));
				for (WebElement frames : frame) {
					driver.switchTo().frame(frames);
					try {
						el = driver.findElement(By.id(findElement));
						if (el != null) {
							return el;
						}
					} catch (Exception e) {

					}
					try {
						el = driver.findElement(By.name(findElement));
						if (el != null) {
							return el;
						}
					} catch (Exception e) {

					}
					try {
						el = driver.findElement(By.xpath(findElement));
						if (el != null) {
							return el;
						}
					} catch (Exception e) {

					}
					try {
						el = driver.findElement(By.tagName(findElement));
						if (el != null) {
							return el;
						}
					} catch (Exception e) {

					}
					try {
						el = driver.findElement(By.cssSelector(findElement));
						if (el != null) {
							return el;
						}
					} catch (Exception e) {

					}
					driver.switchTo().defaultContent();
				}
			}
		} else if(wfcFrames.size()!=0){
			for (WebElement iframe : wfcFrames) {
				//List<WebElement> frame = driver.findElements(By.tagName("frame"));
				//for (WebElement frames : frame) {
					driver.switchTo().frame(iframe);
					try {
						el = driver.findElement(By.id(findElement));
						if (el != null) {
							return el;
						}
					} catch (Exception e) {

					}
					try {
						el = driver.findElement(By.name(findElement));
						if (el != null) {
							return el;
						}
					} catch (Exception e) {

					}
					try {
						el = driver.findElement(By.xpath(findElement));
						if (el != null) {
							return el;
						}
					} catch (Exception e) {

					}
					try {
						el = driver.findElement(By.tagName(findElement));
						if (el != null) {
							return el;
						}
					} catch (Exception e) {

					}
					try {
						el = driver.findElement(By.cssSelector(findElement));
						if (el != null) {
							return el;
						}
					} catch (Exception e) {

					}
					driver.switchTo().defaultContent();
				//}
			}
		} else {
			try {
				el = driver.findElement(By.id(findElement));
				if (el != null) {
					return el;
				}
			} catch (Exception e) {

			}
			try {
				el = driver.findElement(By.name(findElement));
				if (el != null) {
					return el;
				}
			} catch (Exception e) {

			}
			try {
				el = driver.findElement(By.xpath(findElement));
				if (el != null) {
					return el;
				}
			} catch (Exception e) {

			}
			try {
				el = driver.findElement(By.tagName(findElement));
				if (el != null) {
					return el;
				}
			} catch (Exception e) {

			}
			try {
				el = driver.findElement(By.cssSelector(findElement));
				if (el != null) {
					return el;
				}
			} catch (Exception e) {

			}
		}
		return null;
	}

	public void takeListFromOrderIL(String table1IlXpath) {

		WebElement tabel1 = findElement(table1IlXpath);

		List<WebElement> rand = tabel1.findElements(By.tagName("tr"));

		int dimensiuneRand = rand.size();
		System.out.println("randuri: " + dimensiuneRand);

		for (int i = 0; i < dimensiuneRand; i++) {

			WorkflowObject wfc = new WorkflowObject();
			List<WebElement> coloana = rand.get(i).findElements(By.tagName("td"));

			int dimensiuneColoana = coloana.size();
			if (dimensiuneColoana == 0) {
				continue;
			}

			for (int j = 0; j < dimensiuneColoana; j++) {
				String celltext = coloana.get(j).getText();
				wfc.add(i, j, celltext);
				System.out.println("Cell Value Of row number " + i + " and column number " + j + " Is " + celltext);
			}
			workflow.add(wfc);
		}
	}

	public void getOrderIdFromWorkflow(String tableWfcXpath) {

		WebElement tabel1 = findElement(tableWfcXpath);

		List<WebElement> rand = tabel1.findElements(By.tagName("tr"));

		int dimensiuneRand = rand.size();
		System.out.println("randuri: " + dimensiuneRand);

		for (int i = 0; i < dimensiuneRand; i++) {

			WorkflowObject wfc = new WorkflowObject();
			List<WebElement> coloana = rand.get(i).findElements(By.tagName("td"));

			int dimensiuneColoana = coloana.size();
			if (dimensiuneColoana == 0) {
				continue;
			}

			for (int j = 0; j < dimensiuneColoana; j++) {
				String celltext = coloana.get(j).getText();
				wfc.add(i, j, celltext);
				System.out.println("Cell Value Of row number " + i + " and column number " + j + " Is " + celltext);
			}
			workflow.add(wfc);
		}
	}

	public void waitForAlert() {

		Alert alt = driver.switchTo().alert();
		alt.accept();

	}

	public void waitForStatus(String status, String tableWfcXpath, String searchButton) throws InterruptedException {

		while(true){
			getOrderIdFromWorkflow(tableWfcXpath);
			for (WorkflowObject wla : workflow) {
				try {
					if (wla.getStatus().contains(status)) {
						return;
					}
				} catch (Exception e) {
					Thread.sleep(5000);
				}
			}
			clearAndRetry(searchButton);
		}
	}
	
	public void waitForActivities(String activity, String table2IlXpath, String searchButton) throws InterruptedException{
		
		while(true){
			getStatusOrderInstantLink(table2IlXpath);
			for (SearchOrder so : dateRaspuns){
				try {
					if (so.getActivities().equals(activity)) {
						return;
					}
				} catch (Exception e) {
					Thread.sleep(5000);
				}
			}
			clearAndRetry(searchButton);
		}
	}

	public void clearAndRetry(String searchButton) throws InterruptedException {

		// clear lists
		workflow.clear();
		dateRaspuns.clear();
		raspuns.clear();

		// sleep
		Thread.sleep(5000);

		// press search for refresh
		findElement(searchButton).click();
	}

	public void enterWfcOrder() {
		
		primul = workflow.getFirst().getRow();
		StringBuilder sb = new StringBuilder();
		sb.append("//*[@id=\"mainForm:workspace_working_area_view:actionTicketListingTable:").append(primul-1).append(":_idJsp60\"]");
		clickButton(sb.toString());
	}
	
	public void enterIlOrder() {
		
		String orderId = dateRaspuns.getLast().getInternalId();
		StringBuilder sb = new StringBuilder();
		sb.append("http://cfiwn02-app2.nz.alcatel-lucent.com:44080/sas5/order_management_servlet/showOrderDetails?baseline=false&showDetails=DEFAULT&requestId=").append(orderId);
		openWebPage(sb.toString());
	}
	
	public void exitOrder(String goBackToWorkItemsButton) {

		findElement(goBackToWorkItemsButton).click();
	}

	public void clickButton(String el) {
		findElement(el).click();
		driver.switchTo().defaultContent();
	}
	
	public void sendKey(String el, String keyToSend){
		findElement(el).sendKeys(keyToSend);
		driver.switchTo().defaultContent();
	}
	
	public void doManualActivationNGBCircuitFallout(){

		clickButton("tab2href");
		clickButton("ACTION_MANUAL");
		clickButton("//*[@id=\"submitInnerFormButton\"]");

	}
	
	public void sendContinueManualActivation(){

		clickButton("tab2href");
		clickButton("//*[@id=\"submitInnerFormButton\"]");
	}
	
	public void getStatusOrderInstantLink(String table2IlXpath){

		WebElement tabel1 = findElement(table2IlXpath);
		List<WebElement> rand = tabel1.findElements(By.tagName("tr"));
		int dimensiuneRand = rand.size();
		//System.out.println("randuri: "+dimensiuneRand);

		for(int i=0;i<dimensiuneRand;i++){
			SearchOrder searchOrder = new SearchOrder();
			List<WebElement> coloana = rand.get(i).findElements(By.tagName("td"));
			int dimensiuneColoana = coloana.size();
			if(dimensiuneColoana == 0 || coloana.get(0).getText().isEmpty()){
				continue;
			}
			for(int j=0;j<dimensiuneColoana;j++){
				String celltext = coloana.get(j).getText();
				searchOrder.add(j, celltext);
				//System.out.println("Cell Value Of row number "+i+" and column number "+j+" Is "+celltext);
			}
			if(dimensiuneColoana != 0){
				dateRaspuns.add(searchOrder);
			}
		}
	}
}
