package crm.vtiger.Organization;

import java.io.IOException;
import java.time.Duration;

import generic_utility.FileUtility;
import generic_utility.JavaUtility;
import generic_utility.WebDriverUtility;
import object_repository.HomePage;
import object_repository.LoginPage;
import object_repository.OrganizationPage;
import object_repository.VerifyOrganizationPage;
import org.apache.poi.ss.usermodel.*;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CreateOrganizationTest {
    public static void main(String[] args) throws InterruptedException, IOException, ParseException {
//        Get data from the JSON file................................

        String browser = FileUtility.getDataFromJsonFile("bro");
        String url = FileUtility.getDataFromJsonFile("url");
        String username = FileUtility.getDataFromJsonFile("un");
        String password = FileUtility.getDataFromJsonFile("pwd");


//        Get data from th Excel file.................................

//        long random = JavaUtility.generateRandomNumber();
        String orgName = FileUtility.getDataFromExcelFile("Organization", 1, 0);
        String billCity = FileUtility.getDataFromExcelFile("Organization", 1, 19);
        String web = FileUtility.getDataFromExcelFile("Organization", 1, 1);
        String phone = FileUtility.getDataFromExcelFile("Organization", 1, 7);

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
        OrganizationPage ohp = new OrganizationPage(driver);
        VerifyOrganizationPage vhp = new VerifyOrganizationPage(driver);

// Login
        driver.get(url);
        WebElement usernameField = lp.getUsername();
        WebElement passwordField = lp.getPassword();
        usernameField.sendKeys(username);
        passwordField.sendKeys(password + Keys.ENTER);

// Create product
        hp.getOrganizationLink().click();
        ohp.getAddOrganization().click();

// Filling Form

        
        WebElement orgField = ohp.getOrganizationName();
        orgField.sendKeys(orgName);

        WebElement billCityField = ohp.getOrganizationBilling();
        billCityField.sendKeys(billCity);

        WebElement phoneField = ohp.getOrganizationPhone();
        phoneField.sendKeys(phone);

        WebElement webField = ohp.getOrganizationWeb();
        webField.sendKeys(web);

// Save
        hp.getSaveButton().click();

// Verification
        String actOrgName = vhp.getSaveOrganizationName().getText();
        String actBillCity = vhp.getSaveOrganizationBill().getText();
        String actPhone = vhp.getSaveOrganizationPhone().getText();
        String actWeb = vhp.getSaveOrganizationWeb().getText();

        if (actOrgName.equals(orgName) && actBillCity.equals(billCity) && actPhone.equals(phone) && actWeb.equals(web)) {
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
        Thread.sleep(2000);
        driver.quit();
        }
    }
