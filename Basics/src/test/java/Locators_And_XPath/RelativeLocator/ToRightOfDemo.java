package Locators_And_XPath.RelativeLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Required static import for relative locators
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class ToRightOfDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("D:\\Software Testing Workspace\\Automation With Vishal\\SeleniumWorkspace\\src\\test\\resources\\HtmlFiles\\Relative Locator\\to_right_of_demo.html");
            driver.manage().window().maximize();

            // Step 1: Find the base/reference element (the 'Cancel' button on the left)
            WebElement cancelButton = driver.findElement(By.id("btn-cancel"));

            // Step 2: Locate the <button> visually positioned to the RIGHT of 'Cancel'
            WebElement submitButton = driver.findElement(
                    with(By.tagName("button")).toRightOf(cancelButton)
            );

            // Step 3: Perform action or print details
            System.out.println("Located element text: " + submitButton.getText());
            System.out.println("Located element ID: " + submitButton.getAttribute("id"));

            submitButton.click();

        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}