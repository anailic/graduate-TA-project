package library.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternalSystem {

	@FindBy(xpath = "//div[contains(@class, 'box generalbox info')]/div[1]/p[1]")
	private WebElement infoBox;

	private WebDriver driver;

	public InternalSystem (WebDriver driver) {
		this.driver = driver;
		Sleeper.sleepTightInSeconds(3);
		PageFactory.initElements(driver, this);
	}

	public String getInfoBoxText() {
		return infoBox.getText();
	}
}
