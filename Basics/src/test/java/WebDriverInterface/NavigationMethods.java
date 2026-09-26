package WebDriverInterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com/");

        Thread.sleep(1000);

        WebDriver.Navigation nav =  driver.navigate();

        nav.to("https://www.x.com/");

        Thread.sleep(1000);

        nav.back();

        Thread.sleep(1000);

        nav.forward();

        Thread.sleep(1000);

        nav.refresh();

        Thread.sleep(4000);

        driver.quit();

    }
}
