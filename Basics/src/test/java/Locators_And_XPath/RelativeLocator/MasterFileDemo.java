package Locators_And_XPath.RelativeLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Static import for cleaner Relative Locator syntax
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class MasterFileDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("D:\\Software Testing Workspace\\Automation With Vishal\\SeleniumWorkspace\\src\\test\\resources\\HtmlFiles\\Relative Locator\\RelativeLocators_MasterFile_Demo.html");
            driver.manage().window().maximize();

            // ----------------------------------------------------
            // 1. above()
            // Locate an element positioned visually ABOVE the reference element
            // ----------------------------------------------------
            WebElement passwordField = driver.findElement(By.id("password"));

            // Find the <input> directly above the password field
            WebElement usernameInput = driver.findElement(
                    with(By.tagName("input")).above(passwordField)
            );
            usernameInput.sendKeys("RelativeUser");
            System.out.println("Located element above password: " + usernameInput.getAttribute("id"));


            // ----------------------------------------------------
            // 2. below()
            // Locate an element positioned visually BELOW the reference element
            // ----------------------------------------------------
            WebElement usernameLabel = driver.findElement(By.id("lbl-username"));

            // Find the <label> directly below the username label
            WebElement passwordLabel = driver.findElement(
                    with(By.tagName("label")).below(usernameLabel)
            );
            System.out.println("Located element below username label: " + passwordLabel.getText());


            // ----------------------------------------------------
            // 3. toLeftOf()
            // Locate an element positioned visually to the LEFT of the reference element
            // ----------------------------------------------------
            WebElement submitBtn = driver.findElement(By.id("btn-submit"));

            // Find the <button> positioned to the left of the 'Submit' button
            WebElement cancelBtn = driver.findElement(
                    with(By.tagName("button")).toLeftOf(submitBtn)
            );
            System.out.println("Located button to the left: " + cancelBtn.getText());


            // ----------------------------------------------------
            // 4. toRightOf()
            // Locate an element positioned visually to the RIGHT of the reference element
            // ----------------------------------------------------
            WebElement cancelReference = driver.findElement(By.id("btn-cancel"));

            // Find the <button> positioned to the right of the 'Cancel' button
            WebElement rightBtn = driver.findElement(
                    with(By.tagName("button")).toRightOf(cancelReference)
            );
            System.out.println("Located button to the right: " + rightBtn.getText());


            // ----------------------------------------------------
            // 5. near()
            // Locate an element positioned within ~50 pixels (or custom distance) of reference
            // ----------------------------------------------------
            WebElement termsText = driver.findElement(By.id("terms-text"));

            // Find the checkbox located near the terms text (default: within 50px)
            WebElement checkbox = driver.findElement(
                    with(By.tagName("input")).near(termsText)
            );
            checkbox.click();
            System.out.println("Checkbox clicked via near(): " + checkbox.isSelected());

            // You can also specify an explicit pixel distance: near(WebElement, int distanceInPx)
            WebElement customNearCheckbox = driver.findElement(
                    with(By.tagName("input")).near(termsText, 100)
            );
            System.out.println("Found with custom 100px proximity: " + customNearCheckbox.getAttribute("id"));


            // ----------------------------------------------------
            // Chaining Relative Locators
            // You can combine multiple relative conditions together
            // ----------------------------------------------------
            WebElement chainedInput = driver.findElement(
                    with(By.tagName("input"))
                            .above(passwordField)
                            .below(usernameLabel)
            );
            System.out.println("Chained search target ID: " + chainedInput.getAttribute("id"));

        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
