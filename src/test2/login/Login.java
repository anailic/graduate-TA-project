package test2.login;

import org.testng.annotations.Test;

import library.data.Property;
import library.pages.CDDPage;
import library.pages.HomePage;
import library.pages.LoginPage;
import library.pages.SearchResultPage;

import org.testng.annotations.BeforeClass;

import javax.naming.directory.SearchResult;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterClass;

public class Login {
  
  private static WebDriver driver;
  
  boolean isChecked = false;
  LoginPage loginPage;
  HomePage homePage;
  SearchResultPage searchResultPage;
  CDDPage cddPage;
  
  
  @BeforeClass
  public void beforeClass() {
	  
	  driver  = new FirefoxDriver();
	  driver.manage().window().maximize();
	  
	  loginPage = new LoginPage(driver);
	 // driver.get(URL);
	  //Sleeper.sleepTightInSeconds(5);
  }
   @Test //LOGIN preko Property-a
   public void login() {
	   
	   loginPage.typeUsername(Property.username).typePassword(Property.password);
	   
	   homePage = loginPage.clickOnLoginButton();
	   String message = homePage.getTextFromLoginInfoLabel();
	   System.out.println(message);
	   
	   
	   assert message.contains("You are logged in as") : "You are not logged in. Test Faild";
	   System.out.println("Test passed");
   
   
   }
   
/*
     public void search (){
	  homePage.typeSearchValueIntoSearchField(Property.input);
	  Sleeper.sleepTightInSeconds(10);
	  searchResultPage = homePage.clickOnGoButton();
	  Sleeper.sleepTightInSeconds(5);
  

  
   
   assert cddPage.isFirstCheckBoxSelected(): "Check box should be selected";
   loginPage = cddPage.clickOnLogOutLink ();
	  System.out.println("Test passed");
	   
  }
  
  */
  @AfterClass
  public void afterClass() {
	 /* System.out.println("Usao u after class");
	  driver.quit();
	  
	  if (isChecked){
	  driver = new FirefoxDriver();
	  loginPage = new LoginPage (driver);
	  
	 */
	  
  driver.quit();
  }
  }

