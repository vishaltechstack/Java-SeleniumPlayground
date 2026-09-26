package Locators_And_XPath.RelativeLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Static import required for Relative Locators
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class NearDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("D:\\Software Testing Workspace\\Automation With Vishal\\SeleniumWorkspace\\src\\test\\resources\\HtmlFiles\\Relative Locator\\near_demo.html");
            driver.manage().window().maximize();

            // -----------------------------------------------------------
            // 1. Default near() — Finds element within 50 pixels
            // -----------------------------------------------------------
            // Reference element
            WebElement labelElement = driver.findElement(By.id("label-newsletter"));

            // Locate the <input> located within 50px of the label
            WebElement checkbox = driver.findElement(
                    with(By.tagName("input")).near(labelElement)
            );

            checkbox.click();
            System.out.println("Default near() found ID: " + checkbox.getAttribute("id"));
            System.out.println("Is checkbox checked? " + checkbox.isSelected());


            // -----------------------------------------------------------
            // 2. Custom distance near(WebElement, int atMostDistanceInPixels)
            // -----------------------------------------------------------
            // Reference element
            WebElement farLabel = driver.findElement(By.id("lbl-custom"));

            // Locate the <input> located within a custom 100-pixel radius
            WebElement farInput = driver.findElement(
                    with(By.tagName("input")).near(farLabel, 100)
            );

            farInput.sendKeys("Found via 100px proximity!");
            System.out.println("Custom distance near() found ID: " + farInput.getAttribute("id"));

        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
