package library.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import library.data.Property;

public class LoginPage extends Page {
	
	@FindBy(id = "username")  //mapiranje elementa
	private WebElement usernameInputField;
	
	@FindBy (id = "password") 
	private WebElement passwordInputField;
	
	@FindBy (id = "loginbtn")
	private WebElement loginbtn;

	@FindBy(className = "error")
	private WebElement loginButton;
	
	//@FindBy(className = "error")
	//private WebElement errorLable;
	
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		driver.manage().window().maximize();
		driver.get(Property.URL);
		PageFactory.initElements(driver, this);
		
	}
	/**
	 * Type username into username input field
	 * @param username {String}
	 * @return {LoginPage}
	 */
	public LoginPage typeUsername (String username){
		
		usernameInputField.sendKeys(username);
		return this;
	}
	
	/**
	 * Type password into password input field
	 * @param password {String}
	 * @return {LoginPage}
	 */
public LoginPage typePassword(String password){
	
	passwordInputField.sendKeys(password);
	return this;
}
	
/**
 * Click on login button
 * @return {HomePage}
 */


public HomePage clickOnLoginButton(){
	
	loginbtn.click();
	return new HomePage(driver);
}

/**
 * Get text from error label
 * @return {String}
 */
	public String GetErrorMessage (){
		
		return loginButton.getText();
	
	}
	
	/**
	 * Click on login button when invalid data provided
	 * @return {LoginPage}
	 */
	public LoginPage clickOnLoginButtonInvalidData (){
		
		
		loginButton.click();
		return this;
	}

	public LoginPage clearUsernameAndPassword(){
		usernameInputField.clear();
		passwordInputField.clear();
		return this;
		
	}
	public String getTextFromErrorLable() {
		
		return loginButton.getText();

	}
}
