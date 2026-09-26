package Locators_And_XPath.XPaths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathByTextDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("D:\\Software Testing Workspace\\Automation With Vishal\\SeleniumWorkspace\\src\\test\\resources\\HtmlFiles\\xpath\\xpath_text_demo.html");
            driver.manage().window().maximize();

            // 1. Locate heading using text()
            WebElement heading = driver.findElement(
                    By.xpath("//h1[text()='Welcome to Selenium']")
            );
            System.out.println("Heading: " + heading.getText());

            // 2. Locate link by exact text
            WebElement forgotPwdLink = driver.findElement(
                    By.xpath("//a[text()='Forgot Password?']")
            );
            forgotPwdLink.click();

            // 3. Locate button by exact text
            WebElement createAccountBtn = driver.findElement(
                    By.xpath("//button[text()='Create Account']")
            );
            createAccountBtn.click();

            // 4. Locate paragraph using '.' shorthand
            WebElement successMsg = driver.findElement(
                    By.xpath("//p[.='Logged in successfully']")
            );
            System.out.println("Message displayed: " + successMsg.isDisplayed());

        } finally {
            Thread.sleep(3000);
            driver.quit();
        }
    }
}
