package TakeScreeshot;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class FacebookLoginPage {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.facebook.com/login/");
            driver.manage().window().maximize();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement loginBox = wait.until(
                    ExpectedConditions.presenceOfElementLocated(
                            By.xpath("//div[contains(@class, 'login_form_container')] | //form[@id='login_form']/..")
                    )
            );

            // Capture screenshot of the element
            File srcFile = loginBox.getScreenshotAs(OutputType.FILE);

            // Define destination path explicitly with .png extension
            File destFile = new File("./facebook_login.png");

            // Ensure directory exists
            destFile.getParentFile().mkdirs();

            // Save PNG file
            FileHandler.copy(srcFile, destFile);

            System.out.println("Saved PNG screenshot to: " + destFile.getAbsolutePath());

        } catch (IOException e) {
            System.err.println("Failed to save image: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
