package Locators_And_XPath.RelativeLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Static import required for Relative Locators
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class BelowDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("D:\\Software Testing Workspace\\Automation With Vishal\\SeleniumWorkspace\\src\\test\\resources\\HtmlFiles\\Relative Locator\\below_demo.html");
            driver.manage().window().maximize();

            // Step 1: Locate the reference element (the label)
            WebElement emailLabel = driver.findElement(By.id("lbl-email"));

            // Step 2: Locate the <input> element positioned visually BELOW the reference element
            WebElement emailInput = driver.findElement(
                    with(By.tagName("input")).below(emailLabel)
            );

            // Step 3: Perform an action on the found element
            emailInput.sendKeys("alex@example.com");

            System.out.println("Located element ID: " + emailInput.getAttribute("id"));

        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
