package test.login;

import org.testng.annotations.Test;

import library.data.Property;
import library.pages.HomePage;
import library.pages.LoginPage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterClass;

public class Login {
	
  public static String username = "ivecluj1";
  public static String password = "IveParola2";
  
  public static String username1 = "ivecluj2";
  public static String password2 = "IveParola2";
  public static String invalidPassword1 = "lalala";
  public static String invalidUserName = "anaIlic";
  
  public static final String URL = "https://www.endavauniversity.com";

  
  private static WebDriver driver;
  
  LoginPage loginPage;
  HomePage homePage;
  
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
	   
	   
	   
	   /*
	   driver.findElement(By.id("username")).sendKeys(username);
	   driver.findElement(By.id("password")).sendKeys(password);
	   driver.findElement(By.id("loginbtn")).click();
	   
	   Sleeper.sleepTightInSeconds(5);
	   
	  String message = driver.findElement(By.className("logininfo")).getText();
	   System.out.println("Poruka: " + message);
	   */
	   assert message.contains("You are logged in as") : "You are not logged in. Test Faild";
	   System.out.println("Test passed");
	   
   }
  
  
  
  @Test()
  public void NeuspesnoLogovanje ()
  {
	  System.out.println("Prvi");
	  driver.findElement(By.id("username")).sendKeys(username);
	  driver.findElement(By.id("password")).sendKeys(invalidPassword1);
	  driver.findElement(By.id("loginbtn")).click();
	  
	  String message = driver.findElement(By.className("error")).getText();
	  System.out.println(message);
	  
	  assert message.contains("Invalid login") : "ERROR: You are logged in";
	  System.out.println("Test passed");
	  
	  
	  
  }

  @Test(dependsOnMethods = "NeuspesnoLogovanje")
  public void NeuspesnoLogovanje1 ()
  {
	  
	  driver.findElement(By.id("username")).sendKeys(invalidUserName);
	  driver.findElement(By.id("password")).sendKeys(password);
	  driver.findElement(By.id("loginbtn")).click();
	  
	  String message = driver.findElement(By.className("error")).getText();
	  System.out.println(message);
	  
	  assert message.contains("Invali login") : "ERROR: You are logged in";
	  System.out.println("Test passed");
	  
  }
  
  @Test(dependsOnMethods = "NeuspesnoLogovanje1")
  public void UspesnoLogovanje () {
	  System.out.println("Usao u Test");  

  driver.findElement(By.id("username")).sendKeys(username);
  driver.findElement(By.id("password")).sendKeys(password);
  driver.findElement(By.id("loginbtn")).click();
  
  Sleeper.sleepTightInSeconds(5);
  
 String message = driver.findElement(By.className("logininfo")).getText();
  System.out.println("Poruka: " + message);
  
  assert message.contains("You are logged in as") : "You are not logged in. Test Faild";
  System.out.println("Test passed");
  
  }
  
  @AfterClass
  public void afterClass() {
	  System.out.println("Usao u after class");
	  driver.quit();
  
  }

}
