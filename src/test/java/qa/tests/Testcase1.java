package qa.tests;

import org.testng.annotations.Test;

import base.baseTest;
import pageEvents.HomePageEvents;
import pageEvents.SignupPageEvent;
import utils.ElementFetch;

public class Testcase1 extends baseTest{
	ElementFetch ele = new ElementFetch();
	HomePageEvents homePage = new HomePageEvents();
	SignupPageEvent signup = new SignupPageEvent();
	
  @Test
  public void samplwMethodforEnteringCredentials() {
	  homePage.SignInButton();
	  signup.entercredentails();
	  signup.verifySignupPageIsLoaded();
	  
  }
}
