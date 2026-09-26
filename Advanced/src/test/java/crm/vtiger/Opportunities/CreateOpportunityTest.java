package crm.vtiger.Opportunities;

import generic_utility.DateUtils;
import generic_utility.DropdownUtils;
import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import object_repository.HomePage;
import object_repository.LoginPage;
import object_repository.OpportunityPage;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class CreateOpportunityTest {
    public  static void main(String[] args) throws InterruptedException, IOException, ParseException {

//        Get data from JSON file
        String browser = FileUtility.getDataFromJsonFile("bro");
        String url = FileUtility.getDataFromJsonFile("url");
        String username = FileUtility.getDataFromJsonFile("un");
        String password = FileUtility.getDataFromJsonFile("pwd");

//        Get data from the Excel file
        String oppName = FileUtility.getDataFromExcelFile("Opportunity", 1, 0);
        String closeDate = FileUtility.getDataFromExcelFile("Opportunity", 1, 7);
        String leadSource = FileUtility.getDataFromExcelFile("Opportunity", 1, 4);
        String salesStage =  FileUtility.getDataFromExcelFile("Opportunity", 1, 8);

//        open the browser
        WebDriver driver = null;
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        }else if (browser.equals("edge")){
            driver = new EdgeDriver();
        }else
            driver = new ChromeDriver();

        LoginPage lp = new LoginPage(driver);
        HomePage hp = new HomePage(driver);
        OpportunityPage opp = new OpportunityPage(driver);
        WebDriverUtility wdUtil = new WebDriverUtility(driver);


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


//        Login
        driver.get(url);
        WebElement usernameField = lp.getUsername();
        WebElement passwordField = lp.getPassword();
        usernameField.sendKeys(username);
        passwordField.sendKeys(password + Keys.ENTER);

//        Create opportunity
        hp.getOpportunityLink().click();
        opp.getAddOpportunityDetails().click();

//        Filling Form
        WebElement oppNameField = opp.getOpportunityName();
        oppNameField.sendKeys(oppName);

        By leadSourceLocator = By.name("leadsource");
        DropdownUtils.selectOptionByValue(driver, leadSourceLocator, leadSource);

        By salesStageLocator = By.name("sales_stage");
        DropdownUtils.selectOptionByValue(driver, salesStageLocator, salesStage);

        By closeDateLocator = By.name("closingdate");
        DateUtils.enterDate(driver, closeDateLocator, closeDate);

//        choose with the another window
        driver.findElement(By.cssSelector("[src='themes/softed/images/select.gif']")).click();

        String PID = driver.getWindowHandle();

        wdUtil.switchToWindowByUrl("vtlibPopupView");

        String relatedToOrg = FileUtility.getDataFromExcelFile("Opportunity", 1, 1);

        driver.findElement(By.name("search_text")).sendKeys(relatedToOrg + Keys.ENTER);

        driver.findElement(By.xpath("//a[text()='" + relatedToOrg + "']")).click();
//        driver.switchTo().alert().accept();

        driver.switchTo().window(PID);
        Thread.sleep(3000);

//        Save

        hp.getSaveButton().click();

//        Verification


//        Logout
        WebElement profile = hp.getLogOutLink();
        wdUtil.hover(profile);
        hp.getLogOutButtonClick().click();


//        Close the browser
        Thread.sleep(2000);
        driver.quit();
    }
}
