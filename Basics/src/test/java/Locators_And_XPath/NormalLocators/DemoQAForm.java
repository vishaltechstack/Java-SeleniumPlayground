package Locators_And_XPath.NormalLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DemoQAForm {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://demoqa.com/automation-practice-form");

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("John");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Doe");

        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("johndoe@gmail.com");

        WebElement gender = driver.findElement(By.id("gender-radio-1"));
        gender.click();

        WebElement phone =  driver.findElement(By.id("userNumber"));
        phone.sendKeys("1234567890");

        WebElement dob =  driver.findElement(By.id("dateOfBirthInput"));
        dob.clear();
        dob.sendKeys("21 jan 1997");

        WebElement sub = driver.findElement(By.id("subjectsInput"));
        sub.sendKeys("Computer Science");

        WebElement subAuto =  driver.findElement(By.className("subjects-auto-complete__indicator-separator"));
        subAuto.click();

        WebElement hobby = driver.findElement(By.id("hobbies-checkbox-1"));
        hobby.click();

        WebElement picture = driver.findElement(By.id("uploadPicture"));
        picture.sendKeys("D:\\Wallpapers\\Wallpaper4.png");





        Thread.sleep(3000);
        driver.quit();
    }
}
