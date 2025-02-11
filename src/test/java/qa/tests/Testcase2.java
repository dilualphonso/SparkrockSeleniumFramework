package qa.tests;

import org.testng.annotations.Test;

import base.baseTest;
import pageEvents.HomePageEvents;
import pageEvents.ReviewAddingEvent;
import pageEvents.SignupPageEvent;
import utils.ElementFetch;

public class Testcase2 extends baseTest {
	
	ElementFetch ele = new ElementFetch();
	HomePageEvents homePage = new HomePageEvents();
	ReviewAddingEvent reviewPage = new ReviewAddingEvent();
	
	@Test
	
	public void enterRevieDetails() {
		reviewPage.enterReviews();
		reviewPage.enterReviewDetails();
		reviewPage.clickReviewSuccessButton();
		
	
	}

}
