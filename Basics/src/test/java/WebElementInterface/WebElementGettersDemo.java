package WebElementInterface;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementGettersDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("D:\\Software Testing Workspace\\Automation With Vishal\\SeleniumWorkspace\\src\\test\\resources\\HtmlFiles\\WebElement\\getters_demo.html");
            driver.manage().window().maximize();

            WebElement button = driver.findElement(By.id("submit-btn"));
            WebElement header = driver.findElement(By.id("header-title"));

            // ----------------------------------------------------
            // 1. getTagName()
            // Returns the underlying HTML tag name of the element (e.g., button, h2, div)
            // ----------------------------------------------------
            String buttonTag = button.getTagName();
            String headerTag = header.getTagName();
            System.out.println("1. getTagName() -> Button: <" + buttonTag + ">, Header: <" + headerTag + ">");


            // ----------------------------------------------------
            // 2. getAttribute(String name)
            // Returns the value of the specified HTML attribute (or custom data-* attribute)
            // ----------------------------------------------------
            String btnClass = button.getAttribute("class");
            String btnTitle = button.getAttribute("title");
            String customAttr = button.getAttribute("data-testid");
            System.out.println("2. getAttribute() -> class: " + btnClass
                    + " | title: " + btnTitle
                    + " | data-testid: " + customAttr);


            // ----------------------------------------------------
            // 3. getCssValue(String propertyName)
            // Evaluates and returns the computed CSS style property of the element
            // (Colors are returned in rgb/rgba format, dimensions in px)
            // ----------------------------------------------------
            String bgColor = button.getCssValue("background-color");
            String fontSize = button.getCssValue("font-size");
            String fontColor = button.getCssValue("color");
            System.out.println("3. getCssValue() -> background: " + bgColor
                    + " | font-size: " + fontSize
                    + " | color: " + fontColor);


            // ----------------------------------------------------
            // 4. getText()
            // Returns the visible (rendered) inner text of the element and its sub-elements
            // ----------------------------------------------------
            String buttonText = button.getText();
            String headerText = header.getText();
            System.out.println("4. getText() -> Button: '" + buttonText + "' | Header: '" + headerText + "'");


            // ----------------------------------------------------
            // 5. getSize()
            // Returns the Dimension (width and height in pixels) of the element
            // ----------------------------------------------------
            Dimension btnSize = button.getSize();
            System.out.println("5. getSize() -> Width: " + btnSize.getWidth()
                    + "px, Height: " + btnSize.getHeight() + "px");


            // ----------------------------------------------------
            // 6. getLocation()
            // Returns the Point (x, y coordinates in pixels) of the top-left corner relative to page
            // ----------------------------------------------------
            Point btnLocation = button.getLocation();
            System.out.println("6. getLocation() -> X: " + btnLocation.getX()
                    + "px, Y: " + btnLocation.getY() + "px");


            // ----------------------------------------------------
            // 7. getRect()
            // Combines getSize() and getLocation() into a single Rectangle object (introduced in Selenium 3+)
            // ----------------------------------------------------
            Rectangle btnRect = button.getRect();
            System.out.println("7. getRect() -> Coordinates: (" + btnRect.getX() + ", " + btnRect.getY() + ")"
                    + " | Dimensions: [" + btnRect.getWidth() + "x" + btnRect.getHeight() + "]");

        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
