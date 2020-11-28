package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateUserPage extends GeneralPage{

	
    WebDriver driver  ;
	WebDriverWait wait;
	By signInBtn = By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a");
	By emailTxt =By.id("email_create");
	By createAcctBtn=By.id("SubmitCreate");
	//By custFirstName=By.id("customer_firstname");
    By custFirstName =By.xpath("/html//input[@id='customer_firstname']");
	By custLastName =By.id("customer_lastname");
	By custPassword =By.id("passwd");
	By day = By.id("days");
	By month = By.id("months");
	By year = By.id("years");
	By firstName = By.id("firstname");
	By lastName = By.id("lastname");
//	By company = By.id("alias");
	By address = By.id("address1");
	
	By city = By.id("city");
	By state2= By.xpath("//*[@id=\"uniform-id_state\"]/span");
	By state=By.id("//*[@id=\"id_state\"]/option[2]");
	By zip = By.id("postcode");
	By country = By.id("id_country");
	By mobilePhone = By.id("phone_mobile");
	By aliasFutureReference = By.id("alias");
	By registerBtn =By.id("submitAccount");
	
	public CreateUserPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 200);
	}
	public void clickSignIn(){
	//	driver.findElement(signInBtn).click();
		ClickElement(driver, signInBtn);
	}
	public void setEmail(String email) throws InterruptedException{	
		Thread.sleep(1000);
		 SetElement(driver, emailTxt , email);
	}
	public void clickCreateAcct(){
		ClickElement(driver, createAcctBtn);
	}
	public void setCustFirstName(String cust_FirstName) throws InterruptedException{
		wait.until(ExpectedConditions.visibilityOfElementLocated(custFirstName));
		 Scroll250(driver);
		 SetElement(driver, custFirstName , cust_FirstName);
	}
	public void setCustLastName(String cust_LastName){	
		 SetElement(driver, custLastName,cust_LastName);
	}
	public void setCustPassword(String cust_Password)
	{   Scroll250(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(custPassword));
		SetElement(driver, custPassword,cust_Password);
	}
	public void setAddress(String Address){
		 SetElement(driver, address , Address);
	}
	public void setCity(String City){
		 SetElement(driver, city , City);
	}
	public void setState(String State){
		wait.until(ExpectedConditions.visibilityOfElementLocated(state2));
		 ClickElement(driver,state);
		 SetElement(driver, state2 , State);
	}
	public void setZip(String Zip){
		 SetElement(driver, zip , Zip);
	}
	public void setCountry(String Country){
		SelectItemFromList(driver, country , Country);
	}
	public void setMobilePhone(String mobNum){
		SetElement(driver, mobilePhone , mobNum);
	}
	public void setAliasFutureReference (String Alias){
		SetElement(driver, aliasFutureReference , Alias);
	}
	public void clickRegisterBtn(){
		ClickElement(driver,registerBtn);
	}
	
	
	
}
