package pageEvents;

import org.testng.Assert;

import pageObjects.SignupPageElements;
import utils.ElementFetch;

public class SignupPageEvent {
	
	ElementFetch ele = new ElementFetch();
	public void verifySignupPageIsLoaded() {
		Assert.assertTrue(ele.getWebElements("XPATH", SignupPageElements.SignupText).size()>0, "Element not found");
	}
	
	public void entercredentails() {
		ele.getWebElement("XPATH", SignupPageElements.fullName).sendKeys("Dilusha Alponso");
		ele.getWebElement("XPATH", SignupPageElements.emailAddress).sendKeys("dilu@gamil.com");
		ele.getWebElement("XPATH", SignupPageElements.PasswordField).sendKeys("123");
		ele.getWebElement("XPATH", SignupPageElements.SignupButton).click();
	}

}
