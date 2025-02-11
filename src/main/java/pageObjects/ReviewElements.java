package pageObjects;

public interface ReviewElements {
	String childCareName = "//div[contains(@class, 'daycare__name-container')]//a/div[text()='Sunshine Childcare']";
	String reviewHeading = "";
	String reviewName = "//*[@id=\"fullname\"]";
	String reviewComment = "//*[@id=\"message\"]";
	String reviewStar = "//input[@name='starRate' and @value='2']"; 
	String reviewSubmit = "//*[@id=\"root\"]/section/div/section/form/div/div[2]/div[4]/button";
	String reviewSuccess = "//button[@class='swal2-confirm swal2-styled']";

}
