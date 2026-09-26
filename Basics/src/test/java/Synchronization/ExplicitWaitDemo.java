package Synchronization;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("D:\\Software Testing Workspace\\AutomationTesting\\Learning\\src\\test\\resources\\htmlfiles\\Synchronization\\explicit_wait_demo.html");
            driver.manage().window().maximize();

            // 1. Initialize WebDriverWait with a max timeout of 10 seconds
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // ==========================================
            // Scenario A: Wait for Visibility of Element
            // ==========================================
            // Checks that the element is present in DOM AND visible on screen (height/width > 0)
            WebElement visibleText = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("hidden-text"))
            );
            System.out.println("Revealed Text: " + visibleText.getText());

            // ==========================================
            // Scenario B: Wait for Element to be Clickable
            // ==========================================
            // Checks that the element is visible AND enabled (not disabled)
            WebElement payButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("disabled-btn"))
            );
            payButton.click();
            System.out.println("Pay button clicked successfully!");

            // ==========================================
            // Scenario C: Wait for Specific Text to be Present
            // ==========================================
            // Returns a boolean once the innerText matches the expected string
            Boolean isStatusCompleted = wait.until(
                    ExpectedConditions.textToBePresentInElementLocated(By.id("status-label"), "Status: Completed")
            );
            System.out.println("Status completed verified: " + isStatusCompleted);

            // ==========================================
            // Scenario D: Wait for Alert (if applicable)
            // ==========================================
            // wait.until(ExpectedConditions.alertIsPresent());

            // ==========================================
            // Scenario E: Wait for Invisibility/Disappearance
            // ==========================================
            // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-spinner")));

        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
