package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelSubCategToPayPage extends GeneralPage {
	WebDriver driver;
	WebDriverWait wait;
	By womenCategory = By.xpath("//*[@id='block_top_menu']/ul/li[1]/a");
	By subCategory =By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[2]/a");
	//By selResult=By.xpath("//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[1]/span");
	By selResult=By.xpath("//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img");
	By addToCartBtn =By.xpath("//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[1]/span");
	By title= By.xpath("//*[@id='layer_cart']/div[1]/div[1]/h2");
	By proceedCheckOut= By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span");
	By bankWirePaymentTxt=By.xpath("//*[@id='center_column']/form/div/h3");
	By CheckoutSummaryPage =By.xpath("//*[@id='center_column']/p[2]/a[1]/span");
	By CheckoutAddressPage= By.xpath("//*[@id='center_column']/form/p/button/span");
	By serviceTermsBtn=By.id("uniform-cgv");
	By CheckoutShippingPage =By.xpath("//*[@id='form']/p/button/span");
	By payBankWire=By.xpath("//*[@id='HOOK_PAYMENT']/div[1]/div/p/a");
	By confirmOrderBtn=By.xpath("//*[@id='cart_navigation']/button/span");
	By backToOrders=By.xpath("//*[@id='center_column']/p/a");
	By historyTable=By.id("block-history");
	By orderRefernceTxt =By.xpath("//*[@id='center_column']/div");
	
	
	
	public SelSubCategToPayPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 200);
	}
	public void hoverWomenCategory(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(womenCategory));
		HoverElement(driver, womenCategory);
		
	}
	public void selectSubCategory(){	
		wait.until(ExpectedConditions.visibilityOfElementLocated(subCategory));
		ClickElement(driver,subCategory );
	}
	public void selectResult(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(selResult));
		HoverElement(driver,selResult);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartBtn));
		ClickElement(driver, addToCartBtn);
	}
	
	public String getHeader(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(title));
		return	driver.findElement(title).getText();
	}
	public void proceedCheckOut(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(proceedCheckOut));
		ClickElement(driver,proceedCheckOut);
		
	}
	public void clickCheckoutSummaryPage(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutSummaryPage));
		ClickElement(driver,CheckoutSummaryPage);
		
	}
	public void clickCheckoutAddressPage(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutAddressPage));
		ClickElement(driver,CheckoutAddressPage);
		
	}
	public void clickServiceTerms(){
		Scroll250(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(serviceTermsBtn));
		ClickElement(driver,serviceTermsBtn);
		
	}
	public void clickCheckoutShippingPage(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutShippingPage));
		ClickElement(driver,CheckoutShippingPage);
		
	}

	public void clickPayBankWire(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(payBankWire));
		ClickElement(driver,payBankWire);
	}
	public String getBankWirePaymentTxt(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(bankWirePaymentTxt));
		return	driver.findElement(bankWirePaymentTxt).getText();
		
	}
	public void clickConfirmOrderBtn(){	
	wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOrderBtn));
	ClickElement(driver,confirmOrderBtn);
		
	}
	public void clickBackToOrders(){	
	wait.until(ExpectedConditions.visibilityOfElementLocated(backToOrders));
	ClickElement(driver,backToOrders);
		
	}
	public ArrayList<String> getOrderHistoryActualValues() throws InterruptedException {
		Thread.sleep(3000);
		ArrayList<String> OrderHistoryTable = new ArrayList<String>();
		wait.until(ExpectedConditions.visibilityOfElementLocated(historyTable));
		OrderHistoryTable = GetrowValuesFromGrid(driver, historyTable);	
		/* for (int i = 0; i < OrderHistoryTable.size(); i++) {
		 System.out.println("OrderHistoryTable [" + i + "] =" + OrderHistoryTable.get(i));
		 }*/
		return OrderHistoryTable;
	}
	public String getOrderReference(){
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(orderRefernceTxt));
		return	driver.findElement(orderRefernceTxt).getText();
				
	}
	
	
	
}
