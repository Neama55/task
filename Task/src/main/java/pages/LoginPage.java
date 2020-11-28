package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends GeneralPage{
	
		WebDriver driver;
		WebDriverWait wait;
		By emailTxt =By.id("email");
		By custPassword =By.id("passwd");
		By loginBtn =By.id("SubmitLogin");
		By signInBtn = By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a");
		By HeaderName = By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a/span");
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 200);
	}
/*	public void clickSignIn(){
	//	driver.findElement(signInBtn).click();
		ClickElement(driver, signInBtn);
	}
	public void setEmail(String email) throws InterruptedException{	
		Thread.sleep(1000);
		
	}
	public void setPassword(String password) throws InterruptedException{	
		Thread.sleep(1000);
		 
	}*/
	public void setLogin(String email,String password){
		 ClickElement(driver, signInBtn);
		 SetElement(driver, emailTxt , email);
		 SetElement(driver, custPassword , password);
		 clickLogin();
	}
	
	public void clickLogin(){
		ClickElement(driver, loginBtn);
	}
	public String getHeaderName() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(HeaderName));
		return driver.findElement(HeaderName).getText();

	}
	
}
