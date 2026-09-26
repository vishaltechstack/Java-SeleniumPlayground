package crm.vtiger.Product;

import java.io.IOException;
import java.time.Duration;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import object_repository.HomePage;
import object_repository.LoginPage;
import object_repository.ProductPage;
import object_repository.VerifyProductPage;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateProductTest {
    public static void main(String[] args) throws InterruptedException, IOException, ParseException {
//        Get data from the JSON file.........................
        String browser = FileUtility.getDataFromJsonFile("bro");
        String url = FileUtility.getDataFromJsonFile("url");
        String username = FileUtility.getDataFromJsonFile("un");
        String password = FileUtility.getDataFromJsonFile("pwd");

//        Get data from the Excel file
        String prodName = FileUtility.getDataFromExcelFile("Product", 1, 0);
        String partNumber = FileUtility.getDataFromExcelFile("Product", 1, 2);
        String commRate = FileUtility.getDataFromExcelFile("Product", 1, 17);
        String qtyStock = FileUtility.getDataFromExcelFile("Product", 1, 18);
        String qtyUnit = FileUtility.getDataFromExcelFile("Product", 1, 19);
        String unitPrice = FileUtility.getDataFromExcelFile("Product", 1, 16);



// open the browser
        WebDriver driver = null;
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        }else if (browser.equals("edge")) {
            driver = new EdgeDriver();
        }else
            driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        LoginPage lp = new LoginPage(driver);
        HomePage hp = new HomePage(driver);
        ProductPage pp = new ProductPage(driver);
        VerifyProductPage vpp = new VerifyProductPage(driver);

// Login
        driver.get(url);
        WebElement usernameField = lp.getUsername();
        WebElement passwordField = lp.getPassword();
        usernameField.sendKeys(username);
        passwordField.sendKeys(password + Keys.ENTER);

// Create product
        hp.getProductLink().click();
        pp.getProductLink().click();


// Filling Form

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement prodNameField = wait.until(ExpectedConditions.visibilityOf(pp.getProductName()));
//        WebElement prodNameField = pp.getProductName();
        prodNameField.sendKeys(prodName);

        WebElement partNumberField = pp.getPartNumber();
        partNumberField.sendKeys(partNumber);

        WebElement commRateField = pp.getCommissionRate();
        commRateField.sendKeys(commRate);

        WebElement qtyStockField = pp.getQtyStock();
        qtyStockField.sendKeys(qtyStock);

        WebElement qtyUnitField = pp.getUnitPrice();
        qtyUnitField.sendKeys(qtyUnit);

        WebElement unitPriceField = pp.getUnitPrice();
        unitPriceField.sendKeys(unitPrice);

// Save
        hp.getSaveButton().click();


// Verification
        String actProdName = vpp.getSaveProductName().getText();
        String actPartNumber = vpp.getSavePartNumber().getText();
        String actCommRate = vpp.getSaveCommissionRate().getText();
        String actQtyStock = vpp.getSaveQtyStock().getText();
        String actQtyUnit = vpp.getSaveQtyUnit().getText();
        String actUnitPrice = vpp.getSaveUnitPrice().getText();

        if (actProdName.equals(prodName) && actPartNumber.equals(partNumber) && actCommRate.equals(commRate) && actQtyStock.equals(qtyStock) && actQtyUnit.equals(qtyUnit) && actUnitPrice.equals(unitPrice)) {
            System.out.println("[PASS] Organization Succesfully created !!!");
        } else {
            System.out.println("[FAIL] Organization creation verification failed");
        }

// logout
        WebElement profile = hp.getLogOutLink();
        WebDriverUtility wdUtil = new WebDriverUtility(driver);
        wdUtil.hover(profile);
        hp.getLogOutButtonClick().click();

// close the browser
        Thread.sleep(3000);
        driver.quit();


    }
}
