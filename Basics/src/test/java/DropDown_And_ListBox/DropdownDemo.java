package DropDown_And_ListBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DropdownDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        driver.get("D:\\Software Testing Workspace\\Automation Using Java\\BasicSeleniumPlayground\\src\\test\\resources\\HtmlFiles\\Dropdown\\List Box and Auto Suggestion\\dropdown_demo.html");

//        1. Standard Single Select
        WebElement StandardNativeSelect = driver.findElement(By.id("country-select"));

        Select countrySelect = new Select(StandardNativeSelect);

        countrySelect.selectByVisibleText("India");


//        2. Multi-Select Listbox
        WebElement NativeMultiSelect = driver.findElement(By.id("skills-select"));

        Select skillsSelect = new Select(NativeMultiSelect);

        skillsSelect.selectByVisibleText("Python");
        skillsSelect.selectByVisibleText("Java");


//        3. Searchable Autocomplete (Datalist)
        WebElement autocomplete = driver.findElement(By.id("browser-input"));

        autocomplete.clear();
        autocomplete.sendKeys("Google Chrome");
        autocomplete.click();
//        autocomplete.click();
//        WebElement autoSelected = driver.findElement(By.tagName("browsers"));
//        Select  autoSelect = new Select(autoSelected);
//        autoSelect.selectByIndex(0);

        Thread.sleep(3000);
        driver.quit();
    }
}
