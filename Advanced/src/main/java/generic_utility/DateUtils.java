package generic_utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DateUtils {
    public static void enterDate(WebDriver driver, By dateFieldLocator, String dateValue) {
        WebElement dateField = driver.findElement(dateFieldLocator);
        dateField.clear();
        dateField.sendKeys(dateValue);
    }
}
