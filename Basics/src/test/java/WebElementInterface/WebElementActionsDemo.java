package WebElementInterface;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementActionsDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("D:\\Software Testing Workspace\\Automation With Vishal\\SeleniumWorkspace\\src\\test\\resources\\HtmlFiles\\WebElement\\actions_demo.html");
            driver.manage().window().maximize();

            // ----------------------------------------------------
            // 1. sendKeys(CharSequence... keysToSend)
            // Types text into an input field or sends keyboard keys (ENTER, TAB, etc.)
            // ----------------------------------------------------
            WebElement emailField = driver.findElement(By.id("email-input"));

            // Appends text to the existing value
            emailField.sendKeys(" - appending extra text");
            System.out.println("Current value: " + emailField.getAttribute("value"));


            // ----------------------------------------------------
            // 2. clear()
            // Clears existing text from an <input> or <textarea> element
            // ----------------------------------------------------
            emailField.clear();
            System.out.println("Value after clear(): '" + emailField.getAttribute("value") + "'");

            // Re-type a fresh email and press ENTER using Keys enum
            emailField.sendKeys("automation_user@example.com", Keys.TAB);


            // ----------------------------------------------------
            // 3. click()
            // Simulates clicking buttons, checkboxes, radio buttons, or links
            // ----------------------------------------------------
            // Click a checkbox to select it
            WebElement newsletterChk = driver.findElement(By.id("newsletter-checkbox"));
            newsletterChk.click();
            System.out.println("Checkbox selected: " + newsletterChk.isSelected());

            // Click a standard button
            WebElement customBtn = driver.findElement(By.id("btn-clickable"));
            customBtn.click();

            // Handle alert triggered by the click
            driver.switchTo().alert().accept();


            // ----------------------------------------------------
            // 4. submit()
            // Submits the enclosing <form>. Can be called on the form itself
            // OR any input/button element contained inside that form.
            // ----------------------------------------------------
            WebElement formElement = driver.findElement(By.id("registration-form"));

            // Submit form directly without having to locate the submit button
            formElement.submit();

            // Handle the alert triggered by the form submission
            driver.switchTo().alert().accept();

            // Note: submit() can also be called directly on an input element inside the form:
            // emailField.submit();

        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
