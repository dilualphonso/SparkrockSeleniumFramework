package pageEvents;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.baseTest;
import pageObjects.ReviewElements;
import pageObjects.SignupPageElements;
import utils.ElementFetch;

public class ReviewAddingEvent {
	
	ElementFetch ele = new ElementFetch();

	public void verifyIfLoginPageIsLoaded() {
		Assert.assertTrue(ele.getWebElements("XPATH", SignupPageElements.SignupText).size() > 0, "Element not found");

	}
	public void enterReviews() {

		ele.getWebElement("XPATH", ReviewElements.childCareName).click();

	}
	@Test(priority=1)
	public void enterReviewDetails() {
		ele.getWebElement("XPATH", ReviewElements.reviewName).sendKeys("Dilusha Alponso");
		ele.getWebElement("XPATH", ReviewElements.reviewComment).sendKeys("Test");
		//ele.getWebElement("XPATH", ReviewElements.reviewStar).click();
		WebElement starRadio = ele.getWebElement("XPATH", ReviewElements.reviewStar);
		
		JavascriptExecutor js = (JavascriptExecutor) baseTest.driver;
		js.executeScript("arguments[0].click();", starRadio);
		ele.getWebElement("XPATH", ReviewElements.reviewSubmit).click();
	}
	
	@Test
	public void enterReviewDetailsWithEmptyComment() {
		ele.getWebElement("XPATH", ReviewElements.reviewName).sendKeys("Dilusha Alponso");
		ele.getWebElement("XPATH", ReviewElements.reviewComment).clear(); // Leave comment empty
		WebElement starRadio = ele.getWebElement("XPATH", ReviewElements.reviewStar);
		JavascriptExecutor js = (JavascriptExecutor) baseTest.driver;
		js.executeScript("arguments[0].click();", starRadio);
		ele.getWebElement("XPATH", ReviewElements.reviewSubmit).click();

		// Assert that an error message is shown due to empty comment
//		WebElement errorMessage = ele.getWebElement("XPATH", "//*[contains(text(),'Please enter a comment')]");
//		softAssert.assertTrue(errorMessage.isDisplayed(), "Error message for empty review comment is not displayed");
	}
	
public void clickReviewSuccessButton() {
		
		WebElement reviewok = ele.getWebElement("XPATH", ReviewElements.reviewSuccess);
		JavascriptExecutor js = (JavascriptExecutor) baseTest.driver;
		js.executeScript("arguments[0].click();", reviewok);
		baseTest.driver.navigate().back();
	}
	
}
