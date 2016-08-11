package test2.endavaUnivirsity;

import org.testng.annotations.Test;

import library.data.Property;
import library.pages.HomePage;
import library.pages.InternalSystem;
import library.pages.InternalSystem;
import library.pages.LoginPage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterClass;

public class TestEndavaUniversity {
  
	private WebDriver driver;
	LoginPage loginPage;
	HomePage homepage;
	InternalSystem internalSystem;
	String message;

	@BeforeClass
	public void beforeClass() {
		System.out.println("Usao u before");
		driver = new FirefoxDriver();
		loginPage = new LoginPage(driver);
		driver.manage().window().maximize();

		loginPage.typeUsername(Property.username);
		loginPage.typePassword(Property.password);
		homepage = loginPage.clickOnLoginButton();

		message = homepage.getTextFromLoginInfoLabel();
		System.out.println(message);

		assert message.contains("You are logged in as") : "You are not logged in. Test Failed.";

		homepage.clickOnEndavaUniversity();
		Sleeper.sleepTightInSeconds(3);
		internalSystem = homepage.clickOnISSH();
	}

	@Test
	public void EndavaUnivers () {
		System.out.println("Usao u test Endava University");
		Sleeper.sleepTightInSeconds(3);
		message = internalSystem.getInfoBoxText();
		System.out.println(message);
		assert message.contains(Property.infoText) : "Description is not correct.";
		System.out.println("Test passed");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Usao u after klasu");
		driver.quit();
	}


}
