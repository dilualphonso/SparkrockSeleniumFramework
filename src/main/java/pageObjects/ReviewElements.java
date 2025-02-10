package pageObjects;

public interface ReviewElements {
    String childCareName = "//div[contains(@class, 'daycare__name-container')]//a/div[text()='Sunshine Childcare']";
    String reviewHeading = "";
    String reviewName ="//*[@id=\"fullname\"]";
    String reviewComment ="//*[@id=\"message\"]";
    String reviewStar ="//*[@id=\"root\"]/section/div/section/form/div/div[2]/div[2]/div/label[3]/input";
    String reviewSubmit = "//*[@id=\"root\"]/section/div/section/form/div/div[2]/div[4]/button";
}
