package qa.tests;

import org.testng.annotations.Test;

import base.baseTest;
import pageEvents.HomePageEvents;
import pageEvents.SignupPageEvents;
import utils.ElementFetch;

public class Testcase1 extends baseTest{
	ElementFetch ele = new ElementFetch();
	HomePageEvents homePage = new HomePageEvents();
	SignupPageEvents signupPage = new SignupPageEvents();
	
  @Test
  public void samplwMethodforEnteringCredentials() {
	  homePage.SignInButton();
//	  loginPage.verifyIfLoginPageIsLoaded();
	  signupPage.enterCredentials();
	  
  }
}
