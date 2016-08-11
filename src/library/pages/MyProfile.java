package library.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.thoughtworks.selenium.webdriven.commands.GetTable;
import com.thoughtworks.selenium.webdriven.commands.GetText;

public class MyProfile {
	
	@FindBy(css = "a[href*='mailto']")
	private WebElement emailLabel;
	
	@FindBy (linkText = "Career Developmetn Discussion")
	private WebElement careerLabel;
	
	@FindBy(linkText = "Log out")
	private WebElement logOutLink;

	private WebDriver driver;

	
	public MyProfile (WebDriver driver){
		
		this.driver = driver;
		Sleeper.sleepTightInSeconds(3);
		PageFactory.initElements(driver, this);
	}
	
	public String getEmailAddress (){
		emailLabel.getText();
		return emailLabel.getText();
		
		
		
	}
	
		public String getCareer (){
			careerLabel.getText();
			return careerLabel.getText();
			
		}
		
		public LoginPage clicklogOut(){
		
			logOutLink.click();
		
		Sleeper.sleepTightInSeconds(3);
		return new LoginPage(driver);
	}
}
