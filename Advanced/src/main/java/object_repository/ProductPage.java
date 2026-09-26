package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // ============================================================
    // LOCATORS
    // ============================================================

    @FindBy(css = "img[alt='Create Product...']")
    private WebElement productLink;

    @FindBy(id = "productname")
    private WebElement productName;

    @FindBy(id = "productcode")
    private WebElement partNumber;

    @FindBy(id = "commissionrate")
    private WebElement commissionRate;

    @FindBy(id = "qtyinstock")
    private WebElement qtyStock;

    @FindBy(id = "qty_per_unit")
    private WebElement qtyUnit;

    @FindBy(id = "unit_price")
    private WebElement unitPrice;

    // ============================================================
    // GETTER METHODS
    // ============================================================

    public WebElement getProductLink() {
        return productLink;
    }

    public WebElement getProductName() {
        return productName;
    }

    public WebElement getPartNumber() {
        return partNumber;
    }

    public WebElement getCommissionRate() {
        return commissionRate;
    }

    public WebElement getQtyStock() {
        return qtyStock;
    }

    public WebElement getQtyUnit() {
        return qtyUnit;
    }

    public WebElement getUnitPrice() {
        return unitPrice;
    }
}
