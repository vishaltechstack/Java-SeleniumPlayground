# Java-Automation-Lab

A structured repository containing practical implementations of Selenium WebDriver with Java, spanning fundamental browser automation mechanics to production-ready test automation frameworks and CI/CD pipelines.

---

## 📌 Repository Contents

### 🟢 Part 1: Core Selenium WebDriver

* **Architecture & Foundations**
  * Selenium WebDriver Architecture & Execution Flow
  * `SearchContext` & `WebDriver` Interfaces
  * First Test Script & Browser Initialization
  * HTML DOM Basics

* **Element Identification & Interaction**
  * Locators & Custom XPath Strategies
  * Relative Locators (Selenium 4)
  * `WebElement` Interface Methods
  * Handling Dynamic Elements

* **Advanced Browser Operations**
  * Synchronization Strategies (Implicit, Explicit, Fluent Waits)
  * Dropdowns, Multi-Select List Boxes, & Auto-Suggestions
  * Mouse & Keyboard Interactions (`Actions` Class)
  * JavaScript Execution (`JavascriptExecutor`)
  * Capturing Screenshots (`TakesScreenshot`)

* **Complex Component Handling**
  * Shadow DOM Elements
  * Nested Frames & iFrames
  * Alerts & JavaScript Pop-ups
  * Multi-Window & Tab Handling

---

### 🔵 Part 2: Advanced Automation & Framework Design

* **Prerequisites & Migrations**
  * Architectural Differences: Selenium 3 vs. Selenium 4
  * Migration: Standard Java Project to Apache Maven

* **Application Test Scenarios**
  * CRM Domain Overview & End-to-End Test Cases (vtiger CRM)
  * Smoke, Sanity, and Regression Suite Grouping

* **Data-Driven Testing & Generic Utilities**
  * Parameterization via `.properties` Files
  * Test Data Management with Apache POI (Excel)
  * Reusable Utilities: `JavaUtility`, `FileUtility`, `ExcelUtility`, `WebDriverUtility`

* **Design Patterns & Architecture**
  * Page Object Model (POM) & `PageFactory`
  * Base Class Architecture & Driver Life-Cycle Management
  * Framework Types, Architecture Layers, and Implementation Stages

* **Test Execution & Reporting (TestNG)**
  * Configuration Annotations (`@Before...` / `@After...`)
  * Assertions (Hard vs. Soft Assertions)
  * Helper Attributes (`priority`, `dependsOnMethods`, `invocationCount`)
  * Data Providers (`@DataProvider`) & Cross-Browser Execution (`@Parameters`)
  * Suite Execution Types (Parallel, Batch, Group)
  * Event Listeners (`ITestListener`, `IRetryAnalyzer`) & ExtentReports Integration

* **BDD, Build Management & CI/CD**
  * Behavior-Driven Development (BDD) with Cucumber & Gherkin
  * Build Lifecycle & Dependency Management via Apache Maven (`pom.xml`)
  * Version Control workflows using Git & GitHub
  * Continuous Integration & Automated Builds via Jenkins

---

## 🛠 Tech Stack

* **Language:** Java (JDK 17+)
* **Automation Engine:** Selenium WebDriver 4
* **Testing Frameworks:** TestNG, Cucumber BDD
* **Build Tool:** Apache Maven
* **Data Sources:** Apache POI (Excel), Properties
* **Reporting:** ExtentReports / TestNG Reports
* **CI/CD & VCS:** Git, GitHub, Jenkins
