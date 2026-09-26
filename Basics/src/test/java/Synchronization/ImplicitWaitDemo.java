package Synchronization;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            // ==========================================
            // Set Implicit Wait (Global Configuration)
            // ==========================================
            // Instructs the driver to poll the DOM up to 10 seconds for any findElement call
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.get("D:\\Software Testing Workspace\\AutomationTesting\\Learning\\src\\test\\resources\\htmlfiles\\Synchronization\\implicit_wait_demo.html");
            driver.manage().window().maximize();

            long startTime = System.currentTimeMillis();

            // The button takes ~2 seconds to appear.
            // driver.findElement will poll until the element exists, then immediately proceed.
            WebElement dynamicBtn = driver.findElement(By.id("dynamic-btn"));

            long endTime = System.currentTimeMillis();
            System.out.println("Element found in: " + (endTime - startTime) + " ms");
            System.out.println("Button Text: " + dynamicBtn.getText());
            dynamicBtn.click();

        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
