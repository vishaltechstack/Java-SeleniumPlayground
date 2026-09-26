package Locators_And_XPath.XPaths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathByIndexingDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("D:\\Software Testing Workspace\\Automation With Vishal\\SeleniumWorkspace\\src\\test\\resources\\HtmlFiles\\xpath\\xpath_indexing_demo.html");
            driver.manage().window().maximize();

            // 1. Target the FIRST input field
            WebElement firstName = driver.findElement(
                    By.xpath("(//input[@class='field'])[1]")
            );
            firstName.sendKeys("John");

            // 2. Target the SECOND input field
            WebElement middleName = driver.findElement(
                    By.xpath("(//input[@class='field'])[2]")
            );
            middleName.sendKeys("William");

            // 3. Target the THIRD input field
            WebElement lastName = driver.findElement(
                    By.xpath("(//input[@class='field'])[3]")
            );
            lastName.sendKeys("Doe");

            // 4. Target the 2nd row, 1st column in the table
            WebElement secondProduct = driver.findElement(
                    By.xpath("(//table[@id='products']//tr)[2]/td[1]")
            );
            System.out.println("Second Product: " + secondProduct.getText());

            // 5. Using last() function (Bonus Indexing method to grab the final element)
            WebElement lastRowPrice = driver.findElement(
                    By.xpath("(//table[@id='products']//tr)[last()]/td[2]")
            );
            System.out.println("Last Product Price: " + lastRowPrice.getText());

        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
