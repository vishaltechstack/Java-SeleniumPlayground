package crm.vtiger.Contact;

import java.io.IOException;
import java.time.Duration;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CreateContactTest {
    public static void main(String[] args) throws InterruptedException, IOException, ParseException {

//        Get data from the JSON file
        String browser = FileUtility.getDataFromJsonFile("bro");
        String url = FileUtility.getDataFromJsonFile("url");
        String username = FileUtility.getDataFromJsonFile("un");
        String password = FileUtility.getDataFromJsonFile("pwd");

//        Get data from the Excel file
        String firstName = FileUtility.getDataFromExcelFile("Contact", 1, 1);
        String lastName = FileUtility.getDataFromExcelFile("Contact", 1, 2);
        String title = FileUtility.getDataFromExcelFile("Contact", 1, 5);
        String orgName = FileUtility.getDataFromExcelFile("Contact", 1, 3);
        String email = FileUtility.getDataFromExcelFile("Contact", 1, 7);
        String offPhone = FileUtility.getDataFromExcelFile("Contact", 1, 9);


// open the browser
        WebDriver driver = null;
        if (browser.equals("chrome")){
            driver = new ChromeDriver();
        }else if (browser.equals("edge")){
            driver = new EdgeDriver();
        }else {
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

// Login
        driver.get(url);
        WebElement usernameField = driver.findElement(By.name("user_name"));
        WebElement passwordField = driver.findElement(By.name("user_password"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password + Keys.ENTER);

// Create Contact
        driver.findElement(By.linkText("Contacts")).click();
        driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();

// Filling Form
        WebElement firstNameField = driver.findElement(By.name("firstname"));
        firstNameField.sendKeys(firstName);

        WebElement lastNameField = driver.findElement(By.name("lastname"));
        lastNameField.sendKeys(lastName);

        WebElement titleField = driver.findElement(By.id("title"));
        titleField.sendKeys(title);

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(email);

        WebElement offPhoneField = driver.findElement(By.id("phone"));
        offPhoneField.sendKeys(offPhone);

// Save
        driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();

// Verification
        String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
        if (actLastName.equals(lastName)) {
            System.out.println("Contact Successfully created !!!");
        } else {
            System.out.println("Contact creation verification failed");
        }

// logout
        WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
        WebDriverUtility wdUtil = new WebDriverUtility(driver);
        wdUtil.hover(profile);
        driver.findElement(By.linkText("Sign Out")).click();

// close the browser
        Thread.sleep(10000);
        driver.quit();
    }
}
