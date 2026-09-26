package generic_utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropdownUtils {
    public static void selectOptionByValue(WebDriver driver, By dropdownLocator, String value) {
        WebElement dropdownField = driver.findElement(dropdownLocator);
        dropdownField.click();
        WebElement valueSelect = driver.findElement(By.xpath("//option[@value='" + value + "']"));
        valueSelect.click();
        dropdownField.click();
    }
}
