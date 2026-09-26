package WebElementInterface;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementVerificationDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("D:\\Software Testing Workspace\\Automation With Vishal\\SeleniumWorkspace\\src\\test\\resources\\HtmlFiles\\WebElement\\verification_demo.html");
            driver.manage().window().maximize();

            // =======================================================
            // 1. isDisplayed()
            // Checks if the element is rendered and visible to the user.
            // Returns: true if visible, false if display:none / visibility:hidden
            // =======================================================
            WebElement visibleBtn = driver.findElement(By.id("btn-visible"));
            WebElement hiddenDisplayBtn = driver.findElement(By.id("btn-hidden-display"));
            WebElement hiddenVisibilityBtn = driver.findElement(By.id("btn-hidden-visibility"));

            System.out.println("--- isDisplayed() Checks ---");
            System.out.println("Visible Button is displayed: " + visibleBtn.isDisplayed()); // true
            System.out.println("Display:none Button is displayed: " + hiddenDisplayBtn.isDisplayed()); // false
            System.out.println("Visibility:hidden Button is displayed: " + hiddenVisibilityBtn.isDisplayed()); // false

            // Practical Test Assertion Example:
            if (visibleBtn.isDisplayed()) {
                System.out.println("Pass: Target button is visible for interaction.");
            }


            // =======================================================
            // 2. isEnabled()
            // Checks if an interactive element is active or disabled.
            // Returns: true if active, false if the 'disabled' attribute is present.
            // =======================================================
            WebElement activeInput = driver.findElement(By.id("input-active"));
            WebElement disabledInput = driver.findElement(By.id("input-disabled"));
            WebElement disabledBtn = driver.findElement(By.id("btn-disabled"));

            System.out.println("\n--- isEnabled() Checks ---");
            System.out.println("Active input is enabled: " + activeInput.isEnabled()); // true
            System.out.println("Disabled input is enabled: " + disabledInput.isEnabled()); // false
            System.out.println("Disabled button is enabled: " + disabledBtn.isEnabled()); // false

            // Practical Flow Control:
            if (activeInput.isEnabled()) {
                activeInput.sendKeys("Entering text into active field");
            }


            // =======================================================
            // 3. isSelected()
            // Checks if a toggleable element (Checkbox, Radio, Option) is checked/selected.
            // Returns: true if checked/selected, false otherwise.
            // =======================================================
            WebElement checkedBox = driver.findElement(By.id("chk-checked"));
            WebElement unCheckedBox = driver.findElement(By.id("chk-unchecked"));
            WebElement radioSelected = driver.findElement(By.id("radio-selected"));
            WebElement radioUnselected = driver.findElement(By.id("radio-unselected"));

            System.out.println("\n--- isSelected() Checks ---");
            System.out.println("Subscribed checkbox is selected: " + checkedBox.isSelected()); // true
            System.out.println("Notifications checkbox is selected: " + unCheckedBox.isSelected()); // false
            System.out.println("Radio Option A is selected: " + radioSelected.isSelected()); // true
            System.out.println("Radio Option B is selected: " + radioUnselected.isSelected()); // false

            // Practical Toggle Logic (Select only if not already checked):
            if (!unCheckedBox.isSelected()) {
                unCheckedBox.click();
                System.out.println("Notifications checkbox state after click: " + unCheckedBox.isSelected()); // true
            }

        } finally {
            Thread.sleep(3000);
            driver.quit();
        }
    }
}
