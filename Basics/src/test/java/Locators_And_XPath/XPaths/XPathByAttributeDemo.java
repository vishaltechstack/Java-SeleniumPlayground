package Locators_And_XPath.XPaths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathByAttributeDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("D:\\Software Testing Workspace\\Automation With Vishal\\SeleniumWorkspace\\src\\test\\resources\\HtmlFiles\\xpath\\xpath_attribute_demo.html");
            driver.manage().window().maximize();

            // 1. Locate by 'name' attribute
            WebElement emailInput = driver.findElement(
                    By.xpath("//input[@name='user_email']")
            );
            emailInput.sendKeys("tester@example.com");

            // 2. Locate by 'id' attribute
            WebElement passInput = driver.findElement(
                    By.xpath("//input[@id='user_pass']")
            );
            passInput.sendKeys("SecurePass123!");

            // 3. Locate by a custom attribute 'data-test'
            WebElement submitBtn = driver.findElement(
                    By.xpath("//button[@data-test='login-button']")
            );
            submitBtn.click();

        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
