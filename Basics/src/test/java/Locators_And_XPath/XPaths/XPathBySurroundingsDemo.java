package Locators_And_XPath.XPaths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathBySurroundingsDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("D:\\Software Testing Workspace\\Automation With Vishal\\SeleniumWorkspace\\src\\test\\resources\\HtmlFiles\\xpath\\xpath_surroundings_demo.html");
            driver.manage().window().maximize();

            // 1. Locate an input via its immediate static <label> sibling
            // Target: input directly beside/under "Primary Phone Number"
            WebElement phoneInput = driver.findElement(
                    By.xpath("//label[text()='Primary Phone Number']/following-sibling::input")
            );
            phoneInput.sendKeys("+1-555-0199");

            // 2. Locate an element by anchoring to its surrounding container ID
            // Target: checkbox inside the specific user card container
            WebElement adminToggle = driver.findElement(
                    By.xpath("//div[@id='card-john']//input[@type='checkbox']")
            );
            adminToggle.click();

            // 3. Locate a button relative to surrounding row context (same table row)
            // Target: The "Download PDF" button that belongs strictly to Invoice #1094
            WebElement invoiceDownloadBtn = driver.findElement(
                    By.xpath("//td[text()='Payment Invoice #1094']/..//button[text()='Download PDF']")
            );
            invoiceDownloadBtn.click();

        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
