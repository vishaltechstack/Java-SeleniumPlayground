/*
• contains(): Matches elements where an attribute value or inner text contains a specific substring.

    • Attribute: //tagName[contains(@attribute, 'partialValue')]

    • Text: //tagName[contains(text(), 'partialText')]

• starts-with(): Matches elements where an attribute value or inner text begins with a specific prefix.

    • Attribute: //tagName[starts-with(@attribute, 'prefixValue')]

    • Text: //tagName[starts-with(text(), 'prefixText')]

• normalize-space(): Strips leading/trailing whitespace and compresses multiple consecutive spaces/newlines into a single space before comparing.

    • Exact text: //tagName[normalize-space()='exact cleaned text']

    • With contains(): //tagName[contains(normalize-space(), 'cleaned text')]
*/



package Locators_And_XPath.XPaths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicXpathDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("D:\\Software Testing Workspace\\Automation With Vishal\\SeleniumWorkspace\\src\\test\\resources\\HtmlFiles\\xpath\\dynamic_xpath_demo.html");
            driver.manage().window().maximize();

            // 1. contains() using an attribute
            // Locates the input even if 'sess_948271' changes on every page refresh
            WebElement dynamicInput = driver.findElement(
                    By.xpath("//input[contains(@id, 'user-input-')]")
            );
            dynamicInput.sendKeys("JohnDoe");

            // 2. starts-with() using an attribute
            // Matches elements whose ID starts with the static prefix 'btn-submit-'
            WebElement dynamicButton = driver.findElement(
                    By.xpath("//button[starts-with(@id, 'btn-submit-')]")
            );
            System.out.println("Button label: " + dynamicButton.getText());

            // 3. starts-with() using visible text
            WebElement textStartsWith = driver.findElement(
                    By.xpath("//button[starts-with(text(), 'Save')]")
            );
            System.out.println("Found button via text start: " + textStartsWith.getTagName());

            // 4. normalize-space() for clean text matching
            // Removes leading/trailing spaces and newlines, collapsing inner spaces to single spaces
            WebElement cleanLink = driver.findElement(
                    By.xpath("//a[normalize-space()='Download Latest Report']")
            );
            System.out.println("Link URL: " + cleanLink.getAttribute("href"));

            // 5. Combining normalize-space() inside contains()
            WebElement combinedLink = driver.findElement(
                    By.xpath("//a[contains(normalize-space(), 'Latest Report')]")
            );
            combinedLink.click();

        } finally {
            Thread.sleep(3000);
            driver.quit();
        }
    }
}
