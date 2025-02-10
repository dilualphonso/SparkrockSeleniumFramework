package qa.tests;

import org.testng.annotations.Test;

import base.baseTest;
import pageEvents.HomePageEvents;
import pageEvents.ReviewAddingEvent;
import utils.ElementFetch;

public class Testcase2 extends baseTest {
	
	ElementFetch ele = new ElementFetch();
	HomePageEvents homePage = new HomePageEvents();
	ReviewAddingEvent reviewPage = new ReviewAddingEvent();
	
	@Test
	
	public void enterReviewDetails()
	
	{
		reviewPage.enterReviews();
		reviewPage.enterReviewDetails();
	}
}
