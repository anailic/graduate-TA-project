package library.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.PageFactory;

public class CDDPage {

	private WebDriver driver;
	
	public CDDPage (WebDriver driver){
		
	this.driver = driver;
	Sleeper.sleepTightInSeconds(5);
	PageFactory.initElements(driver, this);
		
	}
}
