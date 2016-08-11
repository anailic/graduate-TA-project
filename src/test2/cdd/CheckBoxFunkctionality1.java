package test2.cdd;

import org.testng.annotations.Test;

import library.data.Property;
import library.pages.CDDPage;
import library.pages.HomePage;
import library.pages.LoginPage;
import library.pages.SearchResultPage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterClass;


public class CheckBoxFunkctionality1 {
	
	private static WebDriver driver;

	boolean b = false;
	boolean isCheckd = false;

	LoginPage loginPage1;
	HomePage homePage1;
	SearchResultPage searchResultPage1;
	CDDPage cddPage;

	String message1;
	@BeforeClass
	  public void beforeClass() {
		
		  FirefoxDriver driver = new FirefoxDriver();
		  driver.manage().window().maximize();
		  
		  loginPage1 = new LoginPage(driver);
	
		  
		  
	  }
	CDDPage cddP;
	SearchResultPage searchResultPage;
	LoginPage loginPage;
	HomePage homePage;
	String message;
	
  @Test
  public void login () {
	  
		  loginPage1.typeUsername(Property.username).typePassword(Property.password);
		  homePage1 = loginPage1.clickOnLoginButton();
		  
		  message1 = homePage1.getTextFromLoginInfoLabel();
		  System.out.println(message1);
		   
		  assert message1.contains("You are logged in as") : "You are not logged in. Test Faild";
		  System.out.println("Test passed");
		  
		  homePage1.typeSearchValueIntoSearchField("input");
		  Sleeper.sleepTightInSeconds(4);
			
		  searchResultPage1 = homePage1.clickOnGoButton();
		  Sleeper.sleepTightInSeconds(3);
			
		  cddP= searchResultPage1.ClickOnCDDlink();
		  Sleeper.sleepTightInSeconds(3);
	   }
	
  
  
  
  @AfterClass
  public void afterClass() {

			driver.quit();

			if (isCheckd) {
				driver = new FirefoxDriver();
				loginPage1 = new LoginPage(driver);
				loginPage1.typeUsername(Property.username).typePassword(Property.password);
				homePage1 = loginPage1.clickOnLoginButton();
				message1 = homePage1.getTextFromLoginInfoLabel();
				System.out.println(message1);
				assert message1.contains("You are logged in as") : "You are not logged in. Test Failed.";
				homePage1.typeSearchValueIntoSearchField("career");
				searchResultPage1 = homePage1.clickOnGoButton();
				cddPage = searchResultPage1.ClickOnCDDlink();
				assert cddPage.isFirstCheckBoxSelected() : "Check box should be selected";
				cddPage.UncheckFirstCheckBox();
				loginPage1 = cddPage.clickOnLogOutLink();
				driver.quit();
			}

			if (b) {

				System.out.println("Test passed");
			} else {
				System.out.println("Test failed");
			}

  
  }

}
