package WebDriverInterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetCloseMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        // Load a new web page in the current browser window.
        driver.get("http://www.flipkart.com/");  // InvalidArgumentException: invalid argument

        Thread.sleep(1000);

        // Get the title of the current page
        String title = driver.getTitle();
        System.out.println(title);


        // Get the url of the current page
        String url =  driver.getCurrentUrl();
        System.out.println(url);


        // Gte the source code of the last loaded webpage
//        String sourceCode = driver.getPageSource();
//        System.out.println(sourceCode);


        Thread.sleep(2000);
//        driver.close();
//        it will close the current window
//        it will not stop the server

        driver.quit();
//        it will close all the windows
//        it will stop the server
    }
}
/*

 */