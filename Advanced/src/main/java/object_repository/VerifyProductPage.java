package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyProductPage {

    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public VerifyProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // ============================================================
    // LOCATORS
    // ============================================================

    @FindBy(id = "dtlview_Product Name")
    private WebElement productName;

    @FindBy(id = "mouseArea_Part Number")
    private WebElement partNumber;

    @FindBy(id = "mouseArea_Commission Rate")
    private WebElement commissionRate;

    @FindBy(id = "mouseArea_Qty. in Stock")
    private WebElement qtyStock;

    @FindBy(id = "mouseArea_Qty/Unit")
    private WebElement qtyUnit;

    @FindBy(id = "mouseArea_Unit Price")
    private WebElement unitPrice;

    // ============================================================
    // GETTER METHODS
    // ============================================================

    public WebElement getSaveProductName() {
        return productName;
    }

    public WebElement getSavePartNumber() {
        return partNumber;
    }

    public WebElement getSaveCommissionRate() {
        return commissionRate;
    }

    public WebElement getSaveQtyStock() {
        return qtyStock;
    }

    public WebElement getSaveQtyUnit() {
        return qtyUnit;
    }

    public WebElement getSaveUnitPrice() {
        return unitPrice;
    }
}
