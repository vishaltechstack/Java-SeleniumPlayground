package Locators_And_XPath.XPaths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathMasterFileDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            // Load the HTML file (or your target web application URL)
            driver.get("D:\\Software Testing Workspace\\Automation With Vishal\\SeleniumWorkspace\\src\\test\\resources\\HtmlFiles\\xpath\\Xpath_MasterFile_Demo.html");
            driver.manage().window().maximize();

            // ==========================================
            // Standard XPath Strategies
            // ==========================================

            // a) XPath by Attribute
            // Syntax: //tagName[@attribute='value']
            WebElement byAttr = driver.findElement(
                    By.xpath("//input[@name='user_name']")
            );
            byAttr.sendKeys("admin_user");

            // b) XPath by Text Function
            // Syntax: //tagName[text()='exact_text']
            WebElement byText = driver.findElement(
                    By.xpath("//td[text()='Alex Mercer']")
            );
            System.out.println("User text: " + byText.getText());

            // c) XPath by contains(), starts-with(), normalize-space()
            // 1. contains() for dynamic IDs: //tag[contains(@attr, 'val')]
            WebElement byContains = driver.findElement(
                    By.xpath("//button[contains(@id, 'btn-submit')]")
            );

            // 2. starts-with() for prefix matching: //tag[starts-with(@attr, 'val')]
            WebElement byStartsWith = driver.findElement(
                    By.xpath("//button[starts-with(@id, 'btn-submit-')]")
            );

            // 3. normalize-space() strips leading/trailing/inner whitespace
            WebElement byNormalizeSpace = driver.findElement(
                    By.xpath("//button[normalize-space()='Login Now']")
            );
            System.out.println("Normalized button text: " + byNormalizeSpace.getText());

            // d) XPath by Multiple Attributes
            // Syntax: //tag[@attr1='val1' and @attr2='val2']
            WebElement byMultiAttr = driver.findElement(
                    By.xpath("//input[@name='user_name' and @data-test='user-input']")
            );
            System.out.println("Multi-attr input is displayed: " + byMultiAttr.isDisplayed());

            // e) XPath by Surroundings (Locating an element relative to its label/neighbor)
            // Locating the checkbox input directly following the label text
            WebElement bySurroundings = driver.findElement(
                    By.xpath("//label[text()='Subscribe']/following-sibling::input[@type='checkbox']")
            );
            bySurroundings.click();

            // f) XPath by Axes
            // 1. following-sibling: Get the 'Role' cell right next to 'Sarah Connor'
            WebElement followingSib = driver.findElement(
                    By.xpath("//td[text()='Sarah Connor']/following-sibling::td[@class='role']")
            );
            System.out.println("Sarah's Role: " + followingSib.getText());

            // 2. preceding-sibling: Locate 'Sarah Connor' by referencing the 'Editor' cell
            WebElement precedingSib = driver.findElement(
                    By.xpath("//td[text()='Editor']/preceding-sibling::td")
            );
            System.out.println("User found via preceding sibling: " + precedingSib.getText());

            // 3. ancestor: Jump up to the parent form or top-level wrapper
            WebElement ancestorEl = driver.findElement(
                    By.xpath("//input[@name='user_name']/ancestor::section[@id='login-section']")
            );
            System.out.println("Ancestor tag: " + ancestorEl.getTagName());

            // 4. descendant: Drill down to all buttons inside the table section
            WebElement descendantEl = driver.findElement(
                    By.xpath("//section[@id='table-section']//descendant::button[1]")
            );
            System.out.println("Descendant button text: " + descendantEl.getText());

            // 5. parent: Direct step to the immediate parent node (or /..)
            WebElement parentEl = driver.findElement(
                    By.xpath("//input[@name='user_name']/parent::form")
            );
            System.out.println("Parent ID: " + parentEl.getAttribute("id"));

            // 6. child: Direct step to immediate child node (or /childTag)
            WebElement childEl = driver.findElement(
                    By.xpath("//form[@id='auth-form']/child::button")
            );
            System.out.println("Child tag found: " + childEl.getTagName());

            // g) XPath by Indexing
            // Syntax: (//xpath_expression)[index]  -- note 1-based indexing in XPath
            WebElement secondRowUser = driver.findElement(
                    By.xpath("(//table[@id='users-table']//tbody//tr)[2]/td[1]")
            );
            System.out.println("Second row user: " + secondRowUser.getText());

            // ==========================================
            // Special XPath: SVG Elements
            // ==========================================
            // Standard '//svg' fails because SVG elements belong to the XML namespace.
            // Use local-name() or name() instead:

            // 1. Locating the root <svg> element
            WebElement svgRoot = driver.findElement(
                    By.xpath("//*[local-name()='svg' and @data-icon='search']")
            );
            System.out.println("SVG Width: " + svgRoot.getAttribute("width"));

            // 2. Locating a nested child tag within an SVG (e.g., <circle>, <path>, <g>)
            WebElement svgChild = driver.findElement(
                    By.xpath("//*[local-name()='svg']//*[name()='circle']")
            );
            System.out.println("Circle stroke color: " + svgChild.getAttribute("stroke"));

        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
