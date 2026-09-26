package Locators_And_XPath.RelativeLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Static import required for RelativeLocator methods
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class ToLeftOfDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            // 1. Load the target web page
            driver.get("D:\\Software Testing Workspace\\Automation With Vishal\\SeleniumWorkspace\\src\\test\\resources\\HtmlFiles\\Relative Locator\\to_left_of_demo.html");
            driver.manage().window().maximize();

            // 2. Identify the anchor/reference element ("Next" button)
            WebElement nextButton = driver.findElement(By.id("btn-next"));

            // 3. Locate the <button> visually positioned to the LEFT of the reference element
            WebElement backButton = driver.findElement(
                    with(By.tagName("button")).toLeftOf(nextButton)
            );

            // 4. Perform an action on the located element
            System.out.println("Located Button ID: " + backButton.getAttribute("id"));
            System.out.println("Located Button Text: " + backButton.getText());
            backButton.click();

        } finally {
            Thread.sleep(2000);
            // 5. Clean up and close browser
            driver.quit();
        }
    }
}
