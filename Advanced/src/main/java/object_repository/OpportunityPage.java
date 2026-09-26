package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityPage {

    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public OpportunityPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // ============================================================
    // LOCATORS
    // ============================================================

    @FindBy(css = "img[alt='Create Opportunity...']")
    private WebElement addOpportunityDetails;

    @FindBy(name = "potentialname")
    private WebElement opportunityName;


    // ============================================================
    // GETTER METHODS
    // ============================================================

    public WebElement getAddOpportunityDetails() {
        return addOpportunityDetails;
    }

    public WebElement getOpportunityName() {
        return opportunityName;
    }
}
