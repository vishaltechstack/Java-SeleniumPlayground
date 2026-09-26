package Locators_And_XPath.NormalLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicLocatorsTest {
    public static void main(String[] args) {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Open the local HTML file (replace with your file path or URL)
            driver.get("D:\\Software Testing Workspace\\Automation With Vishal\\SeleniumWorkspace\\src\\test\\resources\\HtmlFiles\\index.html");
            driver.manage().window().maximize();

            // 1. By.id
            // Locates the element with id="username"
            WebElement usernameField = driver.findElement(By.id("username"));
            usernameField.sendKeys("john_doe");

            // 2. By.name
            // Locates the element with name="userPassword"
            WebElement passwordField = driver.findElement(By.name("userPassword"));
            passwordField.sendKeys("SecretPass123");

            // 3. By.linkText
            // Locates an <a> anchor tag matching the exact visible text
            WebElement fullLink = driver.findElement(By.linkText("Visit Official Website"));
            System.out.println("Full Link URL: " + fullLink.getAttribute("href"));

            // 4. By.partialLinkText
            // Locates an <a> anchor tag matching a substring of the visible text
            WebElement partialLink = driver.findElement(By.partialLinkText("Official"));
            System.out.println("Partial Link Text: " + partialLink.getText());

            // 5. By.className
            // Locates the element containing class="btn-submit"
            WebElement submitButton = driver.findElement(By.className("btn-submit"));
            System.out.println("Button text: " + submitButton.getText());

            // 6. By.tagName
            // Locates the first HTML element with tag <p>
            WebElement paragraph = driver.findElement(By.tagName("p"));
            System.out.println("Paragraph text: " + paragraph.getText());

            // 7. By.cssSelector
            // Locates the element using CSS selector syntax (by attribute, class, or id)
            WebElement emailField = driver.findElement(By.cssSelector("input[data-test='user-email']"));
            emailField.sendKeys("john@example.com");

        } finally {
            // Close the browser session
            driver.quit();
        }
    }
}
