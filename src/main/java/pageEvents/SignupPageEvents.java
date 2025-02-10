package pageEvents;

import org.testng.Assert;

import pageObjects.SignupPageElements;
import utils.ElementFetch;

public class SignupPageEvents {
	
	ElementFetch ele = new ElementFetch();
	public void verifyIfLoginPageIsLoaded () {
		Assert.assertTrue(ele.getWebElements("XPATH", SignupPageElements.signupText).size()>0, "Element not found");

		
	}
	public void enterCredentials () {
      ele.getWebElement("XPATH", SignupPageElements.fullName).sendKeys("123");
      ele.getWebElement("XPATH", SignupPageElements.emailAddress).sendKeys("dilu@gmail.com");
      ele.getWebElement("XPATH", SignupPageElements.passwordField).sendKeys("123");
      ele.getWebElement("XPATH", SignupPageElements.signupButton).click();
		
	}

}
