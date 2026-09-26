package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage {

    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public LeadPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // ============================================================
    // LOCATORS
    // ============================================================

    @FindBy(css = "img[alt='Create Lead...']")
    private WebElement addLead;

    @FindBy(name = "lastname")
    private WebElement lastName;

    @FindBy(name = "firstname")
    private WebElement firstName;

    @FindBy(name = "company")
    private WebElement companyName;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(name = "website")
    private WebElement website;

    @FindBy(id = "email")
    private WebElement email;

    // ============================================================
    // GETTER METHODS
    // ============================================================

    public WebElement getAddLead() {
        return addLead;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getCompanyName() {
        return companyName;
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getWebsite() {
        return website;
    }

    public WebElement getEmail() {
        return email;
    }
}
