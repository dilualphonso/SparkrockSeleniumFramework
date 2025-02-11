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
	
	@Test(priority = 1)
	
	public void enterReviewDetails()
	
	{
		reviewPage.enterReviews();
		reviewPage.enterReviewDetails();
		reviewPage.clickReviewSuccessButton();
	}
	
	@Test(priority = 2)
	public void enterReviewDetailsWithEmptyComment() {
		// Negative Test Case: Add review with empty comment (to test error handling)
		reviewPage.enterReviews();
		reviewPage.enterReviewDetailsWithEmptyComment();  // Call the method for empty comment scenario
		reviewPage.clickReviewSuccessButton();
	}
}
