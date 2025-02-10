package pageEvents;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import pageObjects.ReviewElements;
import pageObjects.SignupPageElements;
import utils.ElementFetch;

public class ReviewAddingEvent {
	ElementFetch ele = new ElementFetch();
	
	public void verifyIfLoginPageIsLoaded () {
		Assert.assertTrue(ele.getWebElements("XPATH", SignupPageElements.signupText).size()>0, "Element not found");

		
	}
	public void enterReviews () {

	      ele.getWebElement("XPATH", ReviewElements.childCareName).click();
			
		}
	
	public void enterReviewDetails() {
			      ele.getWebElement("XPATH", ReviewElements.reviewName).sendKeys("Dilusha Alponso");
     ele.getWebElement("XPATH", ReviewElements.reviewComment).sendKeys("Test");
      ele.getWebElement("XPATH", ReviewElements.reviewStar).click();
      ele.getWebElement("XPATH", ReviewElements.reviewSubmit).click();
      
		
	}
}
