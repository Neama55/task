package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.GeneralPage;
import pages.LoginPage;

public class LoginTest extends TestData{
	   WebDriver driver ;
	   LoginPage login;
	   String name= "neama mohamed";
	   GeneralPage GenPage;
	   
	   
		@BeforeTest
		public void test() throws InterruptedException{

			driver=new ChromeDriver();
			driver.get("http://automationpractice.com/index.php");  
			driver.manage().window().maximize();
			Thread.sleep(1000);
			
		 }
		
		@Test(dataProvider="loginData")
		public void login(String email,String password) throws InterruptedException{
			
			login =new LoginPage(driver);
			login.setLogin(email,password);
		//	login.clickLogin();
			GenPage.MyAssert_equal(name, login.getHeaderName());
			System.out.println("header name : " + login.getHeaderName());			
		}
		@DataProvider
		public Object[][] loginData() throws Exception {

			Object[][] testObjArray = TestData.fetchData("login");

			return (testObjArray);
		}
		@AfterTest
		public void afterMethod() {
			//Close the browser
			driver.quit();
		}
		
}
