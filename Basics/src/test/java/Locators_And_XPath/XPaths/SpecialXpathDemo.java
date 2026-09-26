package Locators_And_XPath.XPaths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpecialXpathDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("D:\\Software Testing Workspace\\Automation With Vishal\\SeleniumWorkspace\\src\\test\\resources\\HtmlFiles\\xpath\\special_xpath_demo.html");
            driver.manage().window().maximize();

            // =========================================================================
            // 1. Locate Root <svg> by local-name() and Attribute
            // Syntax: //*[local-name()='svg' and @attribute='value']
            // =========================================================================
            WebElement searchSvg = driver.findElement(
                    By.xpath("//*[local-name()='svg' and @data-testid='svg-search']")
            );
            System.out.println("Search SVG width: " + searchSvg.getAttribute("width"));

            // =========================================================================
            // 2. Locate Nested <path> Tag inside <svg>
            // Syntax: //*[local-name()='svg']//*[name()='path']
            // =========================================================================
            WebElement searchPath = driver.findElement(
                    By.xpath("//*[local-name()='svg']//*[name()='path' and @id='search-path']")
            );
            System.out.println("Path Fill: " + searchPath.getAttribute("fill"));

            // =========================================================================
            // 3. Locate Root <svg> by class (using contains with local-name)
            // =========================================================================
            WebElement chartSvg = driver.findElement(
                    By.xpath("//*[local-name()='svg' and contains(@class, 'analytics-chart')]")
            );
            System.out.println("Chart SVG Aria-Label: " + chartSvg.getAttribute("aria-label"));

            // =========================================================================
            // 4. Locate Nested <g> (Group) tag inside <svg>
            // =========================================================================
            WebElement svgGroup = driver.findElement(
                    By.xpath("//*[local-name()='svg']/*[name()='g' and @id='chart-elements']")
            );
            System.out.println("Group Element Tag: " + svgGroup.getTagName());

            // =========================================================================
            // 5. Locate Nested Shapes (<circle>, <rect>) inside <svg>
            // =========================================================================
            WebElement circleShape = driver.findElement(
                    By.xpath("//*[local-name()='svg']//*[name()='circle' and @id='node-1']")
            );
            System.out.println("Circle fill color: " + circleShape.getAttribute("fill"));

            WebElement rectShape = driver.findElement(
                    By.xpath("//*[local-name()='svg']//*[name()='rect' and @id='bar-1']")
            );
            System.out.println("Rect width: " + rectShape.getAttribute("width"));

            // =========================================================================
            // 6. Traverse from an SVG element to its Parent HTML button
            // =========================================================================
            WebElement parentButton = driver.findElement(
                    By.xpath("//*[local-name()='svg' and @data-testid='svg-search']/parent::button")
            );
            System.out.println("Parent Button Title: " + parentButton.getAttribute("title"));

        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
