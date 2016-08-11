package test2.myAccount;

import org.testng.annotations.Test;

import library.data.Property;
import library.pages.HomePage;
import library.pages.LoginPage;
import library.pages.MyProfile;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;


public class TestMyAccount {

	private WebDriver driver;
	
	MyProfile myProfile;
	LoginPage loginPage;
	HomePage homePage;
	String message;

 @BeforeClass
public void beforeClass() {
	  driver  = new FirefoxDriver();
	  loginPage = new LoginPage(driver);
	  driver.manage().window().maximize();
	  
	  loginPage.typeUsername(Property.username).typePassword(Property.password);
	   
	   homePage = loginPage.clickOnLoginButton();
	   message = homePage.getTextFromLoginInfoLabel();
	   System.out.println(message);
	   
	   assert message.contains("You are logged in as") : "You are not logged in. Test Faild";
	  
	
	   homePage.clickOnMyAccount();
	   myProfile = homePage.clickOnMyPrifile();
	   
	   System.out.println("Test passed");
   

}

  @Test (dependsOnMethods = "test2")
  public void test1() {
	  
	  System.out.println("Usao u prvi test");
	  
	  message = myProfile.getEmailAddress();
	  
	  assert message.contains(Property.email) : "You are nod logged in";
	  System.out.println("Test passed");
  }
 
  @Test 
  public void test2() {
	  System.out.println("Usao u drugi test");
	  
	  message = myProfile.getCareer();
	  
	  assert message.contains(Property.career) : "Test is not valid";
	  System.out.println("Test passed");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Usao u after klasu");
	  myProfile.clicklogOut();
	  System.out.println("Test je prosao");
	  driver.quit();
  }

}
