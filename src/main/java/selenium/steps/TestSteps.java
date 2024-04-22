package selenium.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selenium.util.SeleniumConfig;

/**
 * 
 * @author prototype360
 *
 */
public class TestSteps extends SeleniumConfig {

	public TestSteps(){
		
	}
	
	//provide xpath for clicking an element
	public void clickButton(String xpath) {
		wait.until(d->{
			driver.findElement(By.xpath(xpath)).click(); 
		return true;});
	}
	
	//provide xpath for input element and text to input
	public void inputText(String input, String xpath) {
		wait.until(d->{
			driver.findElement(By.xpath(xpath)).sendKeys(input); 
		return true;});		
	}
	
	//provide xpath to get list of elements
	public List<WebElement> getElementList(String xpath) {
		wait.until(d->
			driver.findElement(By.xpath(xpath)).isDisplayed());
		return driver.findElements(By.xpath(xpath));
		
	}
	
	//provide xpath to wait for a message to be displayed
	public boolean waitForMessage(String xpath) {
		wait.until(d->driver.findElement(By.xpath(xpath)).isDisplayed());
		return driver.findElement(By.xpath(xpath)).isDisplayed();
	}
	
	public boolean waitForMessageToClear(String xpath) {
		wait.until(d->driver.findElements(By.xpath(xpath)).isEmpty()==true);
		return true;
	}
}
