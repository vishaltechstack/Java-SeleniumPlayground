package crm.vtiger.Leads;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import object_repository.HomePage;
import object_repository.LeadPage;
import object_repository.LoginPage;
import object_repository.VerifyLeadPage;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.IOException;
import java.time.Duration;

public class CreateLeadTest {
    public static void main(String[] args) throws InterruptedException, IOException, ParseException {
//        Get data from the JSON file
        String browser = FileUtility.getDataFromJsonFile("bro");
        String url = FileUtility.getDataFromJsonFile("url");
        String username = FileUtility.getDataFromJsonFile("un");
        String password = FileUtility.getDataFromJsonFile("pwd");

//        Get data from the Excel file
        String lastName = FileUtility.getDataFromExcelFile("Lead", 1, 2);
        String firstName = FileUtility.getDataFromExcelFile("Lead", 1, 1);
        String company = FileUtility.getDataFromExcelFile("Lead", 1, 3);
        String phone = FileUtility.getDataFromExcelFile("Lead", 1, 10);
        String website = FileUtility.getDataFromExcelFile("Lead", 1, 14);
        String email = FileUtility.getDataFromExcelFile("Lead", 1, 13);

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
        LeadPage ldp = new LeadPage(driver);
        VerifyLeadPage vlp = new VerifyLeadPage(driver);

// Login
        driver.get(url);
        WebElement usernameField = lp.getUsername();
        WebElement passwordField = lp.getPassword();
        usernameField.sendKeys(username);
        passwordField.sendKeys(password + Keys.ENTER);


// Create Leads

        hp.getLeadLink().click();
        ldp.getAddLead().click();


// Filling Lead

        WebElement firstNameField = ldp.getFirstName();
        firstNameField.sendKeys(firstName);

        WebElement lastNameField = ldp.getLastName();
        lastNameField.sendKeys(lastName);

        WebElement companyNameField = ldp.getCompanyName();
        companyNameField.sendKeys(company);

        WebElement phoneField = ldp.getPhone();
        phoneField.sendKeys(phone);

        WebElement websiteField = ldp.getWebsite();
        websiteField.sendKeys(website);

        WebElement emailField = ldp.getEmail();
        emailField.sendKeys(email);

// Save
        hp.getSaveButton().click();

// Verification
        String actFirstName = vlp.getFirstName().getText();
        String actLastName = vlp.getLastName().getText();
        String actCompanyName = vlp.getCompanyName().getText();
        String actPhone = vlp.getPhone().getText();
        String actWebsite = vlp.getWebsite().getText();
        String actEmail = vlp.getEmail().getText();
        if (actLastName.equals(lastName) &&  actCompanyName.equals(company) && actFirstName.equals(firstName) && actWebsite.equals(website) && actEmail.equals(email) && actPhone.equals(phone)) {
            System.out.println("Lead Succesfully created !!!");
        } else {
            System.out.println("Lead creation verification failed");
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
