package library.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage {
	
	@FindBy (css = "a[title = 'My Account']")
	private WebElement myAccount;
	
	@FindBy (css = "a[title = 'My Profile']")
	private WebElement myProfile;
	
	@FindBy(className = "logininfo")
	private WebElement loginInfoLabel;

	
	@FindBy(id = "shortsearchbox")
	private WebElement searchInputField;

	// @FindBy (css = "input[type = 'submit'][value = 'GO']")
	
	@FindBy(css = "a[title='Endava University']")
	private WebElement endavaUniversity;
	
	@FindBy(css = "a[title='Internal systems self help']")
	private WebElement internalSystemSelfHelp;
	
	private WebElement goButton;
	
	@FindBy (xpath = "//input[contains(@value, 'GO') and contains(@type, 'submit')]")
	

	private WebDriver driver;
	
	
	public HomePage (WebDriver driver){
		this.driver = driver;
		Sleeper.sleepTightInSeconds(5);
		PageFactory.initElements(driver, this);
	}
	
	//prosledjuje se naziv linka Career Dev Discussion
	@FindBy(linkText = "Career Development Discussion")
	private WebElement cddLink;
	
	/**
	 * Get text form login info label
	 * @return {String}
	 */
	public String getTextFromLoginInfoLabel()
	{
		return loginInfoLabel.getText();
		
		
	}
	/**
	 * Type search value into search field
	 * @param value {String}
	 * @return {HomePage}
	 */
	
	public HomePage typeSearchValueIntoSearchField (String value)
	{
		searchInputField.sendKeys(value);
		return this;
		
	}
	public SearchResultPage clickOnGoButton (){
			//goButton.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", goButton);
		return new SearchResultPage(driver);
		
		
		
	}
	
	public HomePage inputIntoSearchField (String input) {
		
		searchInputField.sendKeys(input);
		return this;
	
}
	public HomePage clickOnMyAccount (){
		
		myAccount.click();
		return this;
	}
	
	
  public MyProfile clickOnMyPrifile(){
		
		myProfile.click();
		return new MyProfile(driver);
	}
  
  public HomePage clickOnEndavaUniversity(){
	endavaUniversity.click();
	return this;
}

  public InternalSystem clickOnISSH(){
	   internalSystemSelfHelp.click();
	   return new InternalSystem (driver);
	   
}
}