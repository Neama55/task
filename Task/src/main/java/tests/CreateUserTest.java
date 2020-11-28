package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CreateUserPage;



public class CreateUserTest  {
	
	
	CreateUserPage user;
    WebDriver driver ;
	@BeforeTest
	public void test() throws InterruptedException{

		driver=new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");  
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
	 }
	
	@Test
	public void createUser() throws InterruptedException{
		user =new CreateUserPage(driver);
		System.out.println("Create User ");
		user.clickSignIn();
		user.setEmail("neama56@gmail.com");
		user.clickCreateAcct();
		user.setCustFirstName("neama");
		user.setCustLastName("fouad");
		user.setCustPassword("12345678");
		user.setAddress("address");
		user.setCity("Cairo");
		user.setState("Alabama");
		user.setZip("11011");
		user.setCountry("United States");
		user.setMobilePhone("012345667890");
		user.setAliasFutureReference("Address");
		user.clickRegisterBtn();
	}
	
	
	
	
	
}
