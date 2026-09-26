package Locators_And_XPath.RelativeLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Required static import for Selenium 4 Relative Locators
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class AboveDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("D:\\Software Testing Workspace\\Automation With Vishal\\SeleniumWorkspace\\src\\test\\resources\\HtmlFiles\\Relative Locator\\above_demo.html");
            driver.manage().window().maximize();

            // Step 1: Identify the reference element (password input)
            WebElement passwordField = driver.findElement(By.id("user-password"));

            // Step 2: Locate the <input> positioned visually ABOVE the reference element
            WebElement emailField = driver.findElement(
                    with(By.tagName("input")).above(passwordField)
            );

            // Step 3: Interact with the located element
            emailField.sendKeys("user@example.com");
            System.out.println("Located element ID: " + emailField.getAttribute("id"));

        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
