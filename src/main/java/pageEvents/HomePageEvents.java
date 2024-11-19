package pageEvents;

import pageObjects.HomePageElements;
import utils.ElementFetch;

public class HomePageEvents {
	
	ElementFetch ele = new ElementFetch();

	public void SignInButton () {
		
		ele.getWebElement("XPATH", HomePageElements.startHereButton).click();
		
		
		
		
	}
}
