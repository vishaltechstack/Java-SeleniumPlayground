package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyOrganizationPage {
    public VerifyOrganizationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "dtlview_Organization Name")
    private WebElement saveOrganizationName;

    public WebElement getSaveOrganizationName(){
        return saveOrganizationName;
    }

    @FindBy(id = "dtlview_Billing City")
    private WebElement saveOrganizationBill;

    public WebElement getSaveOrganizationBill(){
        return saveOrganizationBill;
    }

    @FindBy(id = "dtlview_Phone")
    private WebElement saveOrganizationPhone;

    public WebElement getSaveOrganizationPhone(){
        return saveOrganizationPhone;
    }

    @FindBy(id = "dtlview_Website")
    private WebElement saveOrganizationWeb;

    public WebElement getSaveOrganizationWeb(){
        return saveOrganizationWeb;
    }
}
