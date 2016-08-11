package library.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import library.util.Wait;

public class Page {

	@FindBy (className = "logininfo")
	private WebElement loginInfoLabel;
	private WebDriver driver;
	
	public Page (WebDriver driver){
		this.driver = driver;
		//waitForPageToBeLoaded(driver, goButton, 5);
		PageFactory.initElements(driver, this);
		
		
		
	}
		
	/**
	 * Get text from login info label
	 *@return {String}
	*/
public String getTextFromLoginInfoLabel(){
	return getTextFromLoginInfoLabel();
}

public void waitForPageToBeLoaded(WebDriver driver, By element, int time){
	Wait.untilWebElementVisible(driver, loginInfoLabel, 5);
	
}





}
