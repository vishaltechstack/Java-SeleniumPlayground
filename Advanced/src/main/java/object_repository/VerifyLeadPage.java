package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyLeadPage {

    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public VerifyLeadPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // ============================================================
    // LOCATORS
    // ============================================================

    @FindBy(id = "dtlview_Last Name")
    private WebElement lastName;

    @FindBy(id = "dtlview_First Name")
    private WebElement firstName;

    @FindBy(id = "dtlview_Company")
    private WebElement companyName;

    @FindBy(id = "mouseArea_Phone")
    private WebElement phone;

    @FindBy(id = "mouseArea_Website")
    private WebElement website;

    @FindBy(id = "mouseArea_Email")
    private WebElement email;

    // ============================================================
    // GETTER METHODS
    // ============================================================

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
