package Locators_And_XPath.XPaths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathByMultipleAttributesDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("D:\\Software Testing Workspace\\Automation With Vishal\\SeleniumWorkspace\\src\\test\\resources\\HtmlFiles\\xpath\\xpath_multi_attribute_demo.html");
            driver.manage().window().maximize();

            // 1. Using 'and' operator
            // Matches element where name is 'first_name' AND id is 'fname'
            WebElement firstNameInput = driver.findElement(
                    By.xpath("//input[@name='first_name' and @id='fname']")
            );
            firstNameInput.sendKeys("Jane");

            // 2. Using bracket chaining (equivalent to 'and')
            // Matches input tag where type is 'email' AND data-section is 'billing'
            WebElement emailInput = driver.findElement(
                    By.xpath("//input[@type='email'][@data-section='billing']")
            );
            emailInput.sendKeys("jane@example.com");

            // 3. Using 'or' operator
            // Useful for A/B testing or elements where one identifier might switch
            WebElement submitButton = driver.findElement(
                    By.xpath("//button[@data-action='place-order' or @name='submit_order']")
            );
            submitButton.click();

        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
