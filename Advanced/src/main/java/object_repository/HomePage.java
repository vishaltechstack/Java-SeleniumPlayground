package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // ============================================================
    // Leads Page
    // ============================================================

    @FindBy(linkText = "Leads")
    private WebElement leadLink;

    public WebElement getLeadLink() {
        return leadLink;
    }

    // ============================================================
    // Organizations Page
    // ============================================================

    @FindBy(linkText = "Organizations")
    private WebElement organizationLink;

    public WebElement getOrganizationLink() {
        return organizationLink;
    }

    // ============================================================
    // Contacts Page
    // ============================================================

    @FindBy(linkText = "Contacts")
    private WebElement contactLink;

    public WebElement getContactLink() {
        return contactLink;
    }

    // ============================================================
    // Opportunities Page
    // ============================================================

    @FindBy(linkText = "Opportunities")
    private WebElement opportunityLink;

    public WebElement getOpportunityLink() {
        return opportunityLink;
    }

    // ============================================================
    // Products Page
    // ============================================================

    @FindBy(linkText = "Products")
    private WebElement productLink;

    public WebElement getProductLink() {
        return productLink;
    }

    // ============================================================
    // SIGN OUT BUTTON
    // ============================================================

    @FindBy(css = "img[src='themes/softed/images/user.PNG']")
    private WebElement logOutLink;

    public WebElement getLogOutLink() {
        return logOutLink;
    }

    // ============================================================
    // SAVE BUTTON
    // ============================================================

    @FindBy(css = "input[title='Save [Alt+S]']")
    private WebElement saveButton;

    public WebElement getSaveButton(){
        return saveButton;
    }

    // ============================================================
    // SIGN OUT BUTTON CLICK
    // ============================================================

    @FindBy(linkText = "Sign Out")
    private WebElement logOutButtonClick;

    public WebElement getLogOutButtonClick() {
        return logOutButtonClick;
    }

}
