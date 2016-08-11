package test2.login;

import org.testng.annotations.Test;

import library.data.Property;
import library.pages.CDDPage;
import library.pages.HomePage;
import library.pages.LoginPage;
import library.pages.SearchResultPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterClass;

public class TNGAnnotations {
	
	private static WebDriver driver;
	
	LoginPage loginPage;
	HomePage homepage;
	SearchResultPage searchResult;
	CDDPage cddPage;
	  
	
  @BeforeClass(alwaysRun = true)
  public void beforeClass() {
		System.out.println("Before Class");
		driver = new FirefoxDriver();
		loginPage = new LoginPage(driver);
	}
 
	 
  @BeforeMethod
	public void clearFields() {
		System.out.println("Before Method");
		loginPage.clearUsernameAndPassword();
	}

  
  @Test(dependsOnMethods = "NeuspesnoLogovanje")
	public void NeuspesnoLogovanje1() {
	  loginPage.typeUsername(Property.username1);
		loginPage.typePassword(Property.password);
		loginPage.clickOnLoginButton();
		Sleeper.sleepTightInSeconds(3);

		String message = loginPage.GetErrorMessage();
		System.out.println(message);

		assert message.contains("Invalid login") : "Error : You are logged in";

		System.out.println("Test passed");
		
	}@Test 
	public void NeuspesnoLogovanje() {
		System.out.println("Test: NeuspesnoLogovanje()");
		loginPage.typeUsername("nenad");
		loginPage.typePassword(Property.password);
		loginPage.clickOnLoginButtonInvalidData();
		String errorMessage = loginPage.GetErrorMessage();
		System.out.println(errorMessage);
		assert errorMessage.contains("Invalid login") : "ERROR: You are logged in";
		System.out.println("Test passed");
	}

	@Test(dependsOnMethods = "NeuspesnoLogovanje1")
	public void UspesnoLogovanje() {
		System.out.println("Test: UspesnoLogovanje");
		loginPage.typeUsername(Property.username).typePassword(Property.password);
		homepage = loginPage.clickOnLoginButton();
		String message = homepage.getTextFromLoginInfoLabel();
		System.out.println(message);
		assert message.contains("You are logged in as") : "You are not logged in. Test Failed.";
	}



  
  @AfterClass(alwaysRun = true)
  public void afterClass() {
  }

}
