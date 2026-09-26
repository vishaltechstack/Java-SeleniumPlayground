package Synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ThreadSleepDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("D:\\Software Testing Workspace\\AutomationTesting\\Learning\\src\\test\\resources\\htmlfiles\\Synchronization\\sync_demo.html");
            driver.manage().window().maximize();

            System.out.println("Page loaded. Waiting for 4 seconds...");

            // ==========================================
            // Thread.sleep() Example
            // ==========================================
            try {
                // Halts the Java execution thread for exactly 4000 milliseconds (4 seconds).
                // Required to be wrapped in a try-catch block for InterruptedException.
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                // This block executes if the sleeping thread is interrupted by another thread
                System.out.println("Wait was interrupted!");
                e.printStackTrace();
            }

            // After exactly 4 seconds, execution resumes.
            // If the element appeared at 3 seconds, we wasted 1 second.
            // If the element takes 5 seconds, this findElement call will crash with NoSuchElementException.

            WebElement delayedButton = driver.findElement(By.id("delayed-btn"));
            System.out.println("Button located successfully!");
            System.out.println("Button Text: " + delayedButton.getText());
            delayedButton.click();

        } finally {
            Thread.sleep(4000);
            driver.quit();
        }
    }
}
