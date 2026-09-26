/**
 * Working in Selenium - Client Core Engine
 */

document.addEventListener("DOMContentLoaded", () => {
  let completedScenarios = new Set();
  const totalScenarios = 7;

  // ----------------------------------------------------
  // 1. LIVE EVENT LOGGER
  // ----------------------------------------------------
  const consoleOutput = document.getElementById("console-logs");
  const clearConsoleBtn = document.getElementById("btn-clear-console");

  function logEvent(type, message) {
    const entry = document.createElement("div");
    entry.className = `log-entry ${type}`;
    const timestamp = new Date().toTimeString().split(" ")[0];
    entry.textContent = `[${timestamp}] ${message}`;
    consoleOutput.appendChild(entry);
    consoleOutput.scrollTop = consoleOutput.scrollHeight;
  }

  clearConsoleBtn.addEventListener("click", () => {
    consoleOutput.innerHTML = "";
    logEvent("info", "Console cleared.");
  });

  // Track Progress Helper
  function markScenarioComplete(scenarioId) {
    if (!completedScenarios.has(scenarioId)) {
      completedScenarios.add(scenarioId);
      document.getElementById("tracker-counter").textContent = `${completedScenarios.size} / ${totalScenarios}`;
      const fillPercentage = (completedScenarios.size / totalScenarios) * 100;
      document.getElementById("tracker-fill").style.width = `${fillPercentage}%`;
      logEvent("success", `Challenge unlocked: Module ${scenarioId} completed!`);
    }
  }

  // ----------------------------------------------------
  // 2. NAVIGATION & TABS
  // ----------------------------------------------------
  const menuItems = document.querySelectorAll(".menu-item");
  const modules = document.querySelectorAll(".module-card");

  menuItems.forEach((item) => {
    item.addEventListener("click", () => {
      menuItems.forEach((m) => m.classList.remove("active"));
      modules.forEach((mod) => mod.classList.remove("active"));

      item.classList.add("active");
      const targetId = item.getAttribute("data-target");
      document.getElementById(targetId).classList.add("active");
      logEvent("event", `Switched tab to: ${targetId}`);
    });
  });

  // ----------------------------------------------------
  // 3. MODULE 1: FORM & ELEMENT INTERACTIONS
  // ----------------------------------------------------
  const submitBtn = document.getElementById("btn-submit-form");
  submitBtn.addEventListener("click", () => {
    const nameVal = document.getElementById("student-name").value;
    const termsChecked = document.getElementById("terms-box").checked;

    logEvent("event", `Click: #btn-submit-form | Name="${nameVal}" | Terms=${termsChecked}`);
    document.getElementById("form-validation-msg").style.display = "block";
    markScenarioComplete("01");
  });

  // ----------------------------------------------------
  // 4. MODULE 2: DROPDOWNS & AUTO-SUGGESTION
  // ----------------------------------------------------
  const selectElem = document.getElementById("dropdown-framework");
  selectElem.addEventListener("change", (e) => {
    logEvent("event", `Dropdown selected: value="${e.target.value}" text="${e.target.options[e.target.selectedIndex].text}"`);
    markScenarioComplete("02");
  });

  const autoInput = document.getElementById("autosuggest-input");
  const suggestDropdown = document.getElementById("suggestion-dropdown");
  const sampleItems = ["Selenium WebDriver", "Selenium IDE", "Selenium Grid", "TestNG Annotations", "Automation Framework"];

  autoInput.addEventListener("input", (e) => {
    const val = e.target.value.toLowerCase().trim();
    suggestDropdown.innerHTML = "";
    if (val.length === 0) {
      suggestDropdown.style.display = "none";
      return;
    }
    const matches = sampleItems.filter((i) => i.toLowerCase().includes(val));
    if (matches.length > 0) {
      suggestDropdown.style.display = "block";
      matches.forEach((match) => {
        const li = document.createElement("li");
        li.textContent = match;
        li.onclick = () => {
          autoInput.value = match;
          suggestDropdown.style.display = "none";
          logEvent("event", `Auto-suggest picked: "${match}"`);
          markScenarioComplete("02");
        };
        suggestDropdown.appendChild(li);
      });
    } else {
      suggestDropdown.style.display = "none";
    }
  });

  // ----------------------------------------------------
  // 5. MODULE 3: ACTIONS (HOVER, DOUBLE CLICK, DRAG & DROP)
  // ----------------------------------------------------
  const doubleBtn = document.getElementById("btn-double-target");
  doubleBtn.addEventListener("dblclick", () => {
    document.getElementById("double-click-state").textContent = "Success: Double Click Verified!";
    document.getElementById("double-click-state").style.color = "#7ee787";
    logEvent("success", "Action Executed: doubleClick() confirmed.");
    markScenarioComplete("03");
  });

  const dragItem = document.getElementById("drag-source");
  const dropTarget = document.getElementById("drop-target");

  dragItem.addEventListener("dragstart", (e) => {
    e.dataTransfer.setData("text/plain", "drag-box");
    logEvent("event", "Drag started on #drag-source");
  });

  dropTarget.addEventListener("dragover", (e) => {
    e.preventDefault();
    dropTarget.classList.add("over");
  });

  dropTarget.addEventListener("dragleave", () => {
    dropTarget.classList.remove("over");
  });

  dropTarget.addEventListener("drop", (e) => {
    e.preventDefault();
    dropTarget.classList.remove("over");
    dropTarget.textContent = "✔ Successfully Dropped!";
    dragItem.style.display = "none";
    logEvent("success", "Action Executed: dragAndDrop() successful.");
    markScenarioComplete("03");
  });

  // ----------------------------------------------------
  // 6. MODULE 4: SHADOW DOM INJECTION
  // ----------------------------------------------------
  const shadowHost = document.getElementById("shadow-host-root");
  if (shadowHost) {
    const shadowRoot = shadowHost.attachShadow({ mode: "open" });
    shadowRoot.innerHTML = `
      <style>
        .shadow-inner {
          background: #1e1b4b;
          border: 1px solid #6366f1;
          padding: 12px;
          border-radius: 6px;
          color: #c7d2fe;
          font-family: inherit;
        }
        input {
          padding: 6px 8px;
          background: #0f172a;
          border: 1px solid #6366f1;
          border-radius: 4px;
          color: #fff;
          margin-top: 8px;
        }
      </style>
      <div class="shadow-inner">
        <div>Root: <strong>#shadow-root (open)</strong></div>
        <input type="text" id="shadow-target-input" placeholder="Inspect inside shadow tree" />
      </div>
    `;
  }

  // ----------------------------------------------------
  // 7. MODULE 5: ALERTS & POPUPS
  // ----------------------------------------------------
  document.getElementById("btn-native-alert").addEventListener("click", () => {
    logEvent("event", "Triggering window.alert()");
    alert("This is a native test alert from Working in Selenium.");
    document.getElementById("alert-return-text").textContent = "Alert accepted.";
    markScenarioComplete("05");
  });

  document.getElementById("btn-native-confirm").addEventListener("click", () => {
    logEvent("event", "Triggering window.confirm()");
    const res = confirm("Do you confirm this test execution?");
    document.getElementById("alert-return-text").textContent = `Confirm response: ${res}`;
    markScenarioComplete("05");
  });

  document.getElementById("btn-native-prompt").addEventListener("click", () => {
    logEvent("event", "Triggering window.prompt()");
    const text = prompt("Enter an automation token:", "Selenium-Token");
    document.getElementById("alert-return-text").textContent = `Prompt input received: ${text}`;
    markScenarioComplete("05");
  });

  document.getElementById("btn-open-new-window").addEventListener("click", () => {
    logEvent("event", "window.open() called. New window handle spawned.");
    window.open("about:blank", "AutomationWindow", "width=500,height=500");
    markScenarioComplete("05");
  });

  // ----------------------------------------------------
  // 8. MODULE 6: DYNAMIC ASYNC WAITS
  // ----------------------------------------------------
  const startAsyncBtn = document.getElementById("btn-start-async");
  const spinner = document.getElementById("loader-spinner");
  const asyncResult = document.getElementById("async-content-target");

  startAsyncBtn.addEventListener("click", () => {
    startAsyncBtn.disabled = true;
    spinner.style.display = "block";
    asyncResult.style.display = "none";
    logEvent("info", "Starting async task. Delay timer set to 4000ms.");

    setTimeout(() => {
      spinner.style.display = "none";
      asyncResult.style.display = "block";
      startAsyncBtn.disabled = false;
      logEvent("success", "Async element #async-content-target attached & visible.");
      markScenarioComplete("06");
    }, 4000);
  });

  // ----------------------------------------------------
  // 9. MODULE 7: WEBTABLE CHECK ALL
  // ----------------------------------------------------
  const checkAll = document.getElementById("check-all-table");
  checkAll.addEventListener("change", (e) => {
    const isChecked = e.target.checked;
    document.querySelectorAll(".row-chk").forEach((c) => (c.checked = isChecked));
    logEvent("event", `WebTable: selectAll state changed to ${isChecked}`);
    markScenarioComplete("07");
  });

  // ----------------------------------------------------
  // 10. CODE GENERATOR DRAWER
  // ----------------------------------------------------
  const codeDrawer = document.getElementById("code-drawer");
  const drawerBackdrop = document.getElementById("code-drawer-backdrop");
  const openDrawerBtn = document.getElementById("btn-code-generator");
  const closeDrawerBtn = document.getElementById("btn-close-drawer");
  const codeDisplay = document.getElementById("code-display");
  const tabBtns = document.querySelectorAll(".tab-btn");

  const snippets = {
    java: `// Selenium Java - Working In Selenium Sandbox Test
WebDriver driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("http://localhost:3000");

// 1. WebElements & Input
driver.findElement(By.id("student-name")).sendKeys("Jane Tester");

// 2. Selects
Select framework = new Select(driver.findElement(By.id("dropdown-framework")));
framework.selectByValue("sel-java");

// 3. Explicit Wait
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
driver.findElement(By.id("btn-start-async")).click();
WebElement payload = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("async-content-target")));
System.out.println(payload.getText());`,
    python: `# Selenium Python - Working In Selenium Sandbox Test
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait, Select
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Chrome()
driver.get("http://localhost:3000")

# 1. WebElements
driver.find_element(By.ID, "student-name").send_keys("Jane Tester")

# 2. Selects
framework = Select(driver.find_element(By.ID, "dropdown-framework"))
framework.select_by_value("sel-py")

# 3. Explicit Wait
wait = WebDriverWait(driver, 5)
driver.find_element(By.ID, "btn-start-async").click()
payload = wait.until(EC.visibility_of_element_located((By.ID, "async-content-target")))
print(payload.text)`
  };

  function updateCodeDisplay(lang) {
    codeDisplay.textContent = snippets[lang];
  }

  openDrawerBtn.addEventListener("click", () => {
    codeDrawer.classList.add("open");
    drawerBackdrop.classList.add("open");
    updateCodeDisplay("java");
  });

  closeDrawerBtn.addEventListener("click", () => {
    codeDrawer.classList.remove("open");
    drawerBackdrop.classList.remove("open");
  });

  drawerBackdrop.addEventListener("click", () => {
    codeDrawer.classList.remove("open");
    drawerBackdrop.classList.remove("open");
  });

  tabBtns.forEach((btn) => {
    btn.addEventListener("click", () => {
      tabBtns.forEach((b) => b.classList.remove("active"));
      btn.classList.add("active");
      updateCodeDisplay(btn.getAttribute("data-lang"));
    });
  });

  // Toggle Live Console on/off
  const toggleConsoleBtn = document.getElementById("btn-toggle-console");
  const liveConsole = document.getElementById("live-console");
  toggleConsoleBtn.addEventListener("click", () => {
    if (liveConsole.style.display === "none") {
      liveConsole.style.display = "flex";
      logEvent("info", "Console docked.");
    } else {
      liveConsole.style.display = "none";
    }
  });
});