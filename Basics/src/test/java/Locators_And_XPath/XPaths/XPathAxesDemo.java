package Locators_And_XPath.XPaths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathAxesDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("D:\\Software Testing Workspace\\Automation With Vishal\\SeleniumWorkspace\\src\\test\\resources\\HtmlFiles\\xpath\\xpath_axes_demo.html");
            driver.manage().window().maximize();

            // 1. following-sibling: Finds sibling nodes AFTER the current node at the same level
            // Example: Find the role ('Admin') that comes after the name 'Sarah Connor'
            WebElement followingSib = driver.findElement(
                    By.xpath("//td[text()='Sarah Connor']/following-sibling::td[@class='role']")
            );
            System.out.println("Role: " + followingSib.getText()); // Output: Admin

            // 2. preceding-sibling: Finds sibling nodes BEFORE the current node at the same level
            // Example: Find the username td that sits before the td with role 'Editor'
            WebElement precedingSib = driver.findElement(
                    By.xpath("//td[text()='Editor']/preceding-sibling::td[@class='name']")
            );
            System.out.println("Username: " + precedingSib.getText()); // Output: John Doe

            // 3. parent: Selects the immediate parent node (one level up)
            // Example: Move from the td to its parent <tr>
            WebElement parentRow = driver.findElement(
                    By.xpath("//td[text()='Sarah Connor']/parent::tr")
            );
            System.out.println("Parent Row ID: " + parentRow.getAttribute("id")); // Output: row-1

            // 4. child: Selects immediate children of the current node (one level down)
            // Example: Select the <h2> child inside the <section>
            WebElement childHeader = driver.findElement(
                    By.xpath("//section[@id='user-management']/child::h2")
            );
            System.out.println("Child Header Text: " + childHeader.getText()); // Output: User List

            // 5. ancestor: Selects all ancestor nodes (parent, grandparent, etc.)
            // Example: Jump from a button up to the container <section>
            WebElement ancestorSection = driver.findElement(
                    By.xpath("//button[@class='btn-delete']/ancestor::section")
            );
            System.out.println("Ancestor ID: " + ancestorSection.getAttribute("id")); // Output: user-management

            // 6. descendant: Selects all descendants (children, grandchildren, etc.)
            // Example: Find the delete button inside the entire table
            WebElement descendantBtn = driver.findElement(
                    By.xpath("//table[@id='users-table']/descendant::button[1]")
            );
            System.out.println("Descendant Button: " + descendantBtn.getText()); // Output: Delete

        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
