package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public OrganizationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // ============================================================
    // LOCATORS
    // ============================================================

    @FindBy(css = "img[alt='Create Organization...']")
    private WebElement addOrganization;

    @FindBy(name = "accountname")
    private WebElement organizationName;

    @FindBy(id = "bill_city")
    private WebElement organizationBilling;

    @FindBy(id = "phone")
    private WebElement organizationPhone;

    @FindBy(name = "website")
    private WebElement organizationWeb;


    // ============================================================
    // GETTER METHODS
    // ============================================================

    public WebElement getAddOrganization(){
        return addOrganization;
    }

    public WebElement getOrganizationName(){
        return organizationName;
    }

    public WebElement getOrganizationBilling(){
        return organizationBilling;
    }

    public WebElement getOrganizationPhone(){
        return organizationPhone;
    }

    public WebElement getOrganizationWeb(){
        return organizationWeb;
    }
}
