package WebDriverInterface;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ManageMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        WebDriver.Window win = driver.manage().window();

//        driver.manage().window().maximize();
//        driver.manage().window().minimize();
//        driver.manage().window().fullscreen();

//        win.maximize();
//        win.minimize();
//        win.fullscreen();

//        size of window

        win.setSize(new Dimension(300, 700));


        Dimension dim1 = win.getSize();

        int h = dim1.getHeight();
        int w = dim1.getWidth();

        System.out.println(dim1);
        System.out.println(w);
        System.out.println(h);




//        position of window
        Point pt1 = win.getPosition();

        int x = pt1.getX();
        int y = pt1.getY();

        System.out.println(pt1);
        System.out.println(x);
        System.out.println(y);


//        set the position
        win.setPosition(new Point(200, 100));



        Thread.sleep(2000);
        driver.quit();
    }
}
