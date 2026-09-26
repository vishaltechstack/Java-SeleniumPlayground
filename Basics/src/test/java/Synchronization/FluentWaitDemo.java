package Synchronization;

import java.time.Duration;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitDemo {
    public static void main(String[] args) throws  InterruptedException{
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("D:\\Software Testing Workspace\\AutomationTesting\\Learning\\src\\test\\resources\\htmlfiles\\Synchronization\\fluent_wait_demo.html");
            driver.manage().window().maximize();

            // ====================================================
            // 1. Configure FluentWait Instance
            // ====================================================
            Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                    // Maximum time to wait for the condition
                    .withTimeout(Duration.ofSeconds(10))
                    // Polling frequency (checks every 250 milliseconds)
                    .pollingEvery(Duration.ofMillis(250))
                    // Suppress exceptions thrown during polling attempts
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class)
                    // Custom failure message logged on TimeoutException
                    .withMessage("Element #success-banner was not found within the 10s FluentWait window.");


            // ====================================================
            // Approach A: Using FluentWait with ExpectedConditions
            // ====================================================
            WebElement successBannerEC = fluentWait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("success-banner"))
            );
            System.out.println("Approach A (EC) Text: " + successBannerEC.getText());


            // ====================================================
            // Approach B: Using FluentWait with Custom Lambda / Function
            // ====================================================
            // Useful when evaluating custom conditions or business logic
            WebElement customConditionElement = fluentWait.until(new Function<WebDriver, WebElement>() {
                @Override
                public WebElement apply(WebDriver d) {
                    WebElement el = d.findElement(By.id("success-banner"));
                    if (el.isDisplayed() && el.getText().contains("Order Placed")) {
                        return el;
                    }
                    return null; // Returning null causes FluentWait to continue polling
                }
            });

            // Alternatively with modern Java Lambda syntax:
            // WebElement customConditionElement = fluentWait.until(
            //     d -> {
            //         WebElement el = d.findElement(By.id("success-banner"));
            //         return (el.isDisplayed() && el.getText().contains("Order Placed")) ? el : null;
            //     }
            // );

            System.out.println("Approach B (Custom Function) Text: " + customConditionElement.getText());

        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
