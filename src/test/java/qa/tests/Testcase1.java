package qa.tests;

import org.testng.annotations.Test;

import base.baseTest;
import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;
import utils.ElementFetch;

public class Testcase1 extends baseTest{
	ElementFetch ele = new ElementFetch();
	HomePageEvents homePage = new HomePageEvents();
	LoginPageEvents loginPage = new LoginPageEvents();
	
  @Test
  public void samplwMethodforEnteringCredentials() {
	  homePage.SignInButton();
	  loginPage.verifyIfLoginPageIsLoaded();
	  loginPage.enterCredentials();
	  
  }
}
