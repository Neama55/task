package pages;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class GeneralPage {
	public static WebDriver driver  ;

	public Boolean ElementIsDisplayed(WebDriver driver, By element_locator) {
	
		try {
			driver.findElement(element_locator).isDisplayed();
			System.out.println(" the Element is Displayed successfully");
			return true;

		} catch (Exception e) {
			System.out.println(" the Element is not Displayed successfully");

			return false;
		}

	}
	public void SetElement(WebDriver driver, By element_locator, String value) {
		
		Boolean Flag_element = ElementIsDisplayed(driver, element_locator);
		
		try {
			if (Flag_element == true) {
				WebElement element = driver.findElement(element_locator);
				element.clear();
				Thread.sleep(3000);
				element.sendKeys(value);
				System.out.println("The value is set successfully ");
			} else {
				System.out.println("Can't Set Element");
			}
		} catch (Exception e) {
			System.out.println("Can't Set Element");
		}

	}
	public void SelectItemFromList(WebDriver driver, By element_locator, String value) {
		
		ClickElement(driver, element_locator);
		try {
			new Select(driver.findElement(element_locator)).selectByVisibleText(value);
			
		} catch (Exception e) {
			
			System.out.println(" Cannot find element in list");

		}
	}
	public void ClickElement(WebDriver driver, By element_locator) {
		

		Boolean flag = ElementIsDisplayed(driver, element_locator);
		try{
		if (flag == true) {
			WebElement element = driver.findElement(element_locator);
			element.click();
		System.out.println("Click on button successfully ");
		} else {
			System.out.println("Can't Click on button");
		}} catch (Exception e){
			System.out.println("Can't Click on button");
		}
		
	}
	public void Scroll250(WebDriver driver) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 250);");
		
	}
	public static void MyAssert_equal(String Expected, String Actual) throws InterruptedException{

		try {

			assertEquals(Expected, Actual);
			System.out.println("The expected element equals the actual element");
		} catch (Error e) {
			System.out.println("Not equaaaaaaaaal");
		}

	}
	public static void CloseBrowser() {
		
		try {
			driver.quit();
			System.out.println("Close The browser");
		} catch (Exception ex) {
			System.out.println("Couldn't close The browser");
		}
	}
	
	public void HoverElement(WebDriver driver, By element_locator) {
		WebElement element = driver.findElement(element_locator);

		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			System.out.println("Hover element and click ");
		} catch (Exception ex) {
			System.out.println("Can't Hover element ");
		}
	}
	public void clickCheckbox(WebDriver driver, By element_locator) {
		Boolean flag = ElementIsDisplayed(driver, element_locator);
		if (flag == true) {
			WebElement element = driver.findElement(element_locator);
			element.click();
			if(element.isSelected()){
				System.out.println("The elemnt is  selected");
			}else{
				System.out.println("The elemnt is not selected");
			}
			element.click();	
			}
		System.out.println("Click on button successfully ");
		} 
	public ArrayList<String> GetrowValuesFromGrid(WebDriver driver, By Table_Element_locator) {
		

		ElementIsDisplayed(driver, Table_Element_locator);
		WebElement Table_element = driver.findElement(Table_Element_locator);
		ArrayList<String> rows = new ArrayList<String>();
		List<WebElement> allRows = Table_element.findElements(By.tagName("tr"));
		for (WebElement row : allRows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));

			for (WebElement cell : cells) {
				
				rows.add(cell.getText());
			}
		}
		return rows;
	}
	public static void MyAssert_contain(String Expected, String Actual) {

	
		try {

			assertTrue(Actual.contains(Expected));
			System.out.println("The Actuaal value contains expected value");
		} catch (Error e) {
			System.out.println("The Actuaal value doesn't contain expected value");
		}

	}

}
