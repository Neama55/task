package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.GeneralPage;
import pages.LoginPage;
import pages.SelSubCategToPayPage;

public class SelSubCategToPayTest {

		WebDriver driver ;
		LoginPage login;
		SelSubCategToPayPage subCatPage;
		GeneralPage GenPage;
		String title="Product successfully added to your shopping cart";
		String bankWireVaildationMsg="BANK-WIRE PAYMENT.";
		String orderRef="";
		String orderConfirmationTxt ="";
		
		
		@BeforeTest
		public void open() throws InterruptedException{

			driver=new ChromeDriver();
			driver.get("http://automationpractice.com/index.php");  
			driver.manage().window().maximize();
			Thread.sleep(1000);
			login =new LoginPage(driver);
			subCatPage =new SelSubCategToPayPage(driver);
		 }
		
		@Test (priority =1)
		public void select_SubCategory() throws InterruptedException{			
			
			login.setLogin("neama@gmail.com", "neama1234");
			subCatPage.hoverWomenCategory();
			subCatPage.selectSubCategory();
		}
		@Test (priority=2)
		public void selectResult() throws InterruptedException{
			subCatPage.selectResult();
			GenPage.MyAssert_equal(title, subCatPage.getHeader());
			System.out.println(subCatPage.getHeader());
		}
		@Test(priority=3)
		public void checkoutProcedure(){
			subCatPage.proceedCheckOut();
			subCatPage.clickCheckoutSummaryPage();
			subCatPage.clickCheckoutAddressPage();
			subCatPage.clickServiceTerms();
			subCatPage.clickCheckoutShippingPage();
			
		}
	    @Test (priority =4)
	    public void clickBankByWire() throws InterruptedException{
	    	subCatPage.clickPayBankWire();
	    	GenPage.MyAssert_equal(bankWireVaildationMsg, subCatPage.getBankWirePaymentTxt());
	    	System.out.println(subCatPage.getBankWirePaymentTxt());
	    	subCatPage.clickConfirmOrderBtn();
	    }
		@Test (priority =5)
		public void orderHistory() throws InterruptedException{
		orderConfirmationTxt=subCatPage.getOrderReference();
		System.out.println(orderConfirmationTxt);
		subCatPage.clickBackToOrders();
		orderRef=subCatPage.getOrderHistoryActualValues().get(0);		
		System.out.println(orderRef);	
			GenPage.MyAssert_contain(orderRef,orderConfirmationTxt);
		}
		
	//	@AfterTest
		public void afterMethod() {
			//Close the browser
			driver.quit();
		}
	
	
	
}
