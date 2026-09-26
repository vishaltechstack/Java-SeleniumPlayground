document.addEventListener("DOMContentLoaded", () => {
  // ----------------------------------------------------
  // 1. AUTO-SUGGESTION SYSTEM (services.html)
  // ----------------------------------------------------
  const searchInput = document.getElementById("course-search-suggest");
  const suggestionsBox = document.getElementById("suggestions-box");
  const courses = [
    "Selenium WebDriver with Java",
    "Selenium with Python",
    "Selenium Grid & Docker",
    "Cypress End-to-End Testing",
    "Playwright Automation Essentials",
    "Appium Mobile Automation",
    "API Automation using RestAssured"
  ];

  if (searchInput && suggestionsBox) {
    searchInput.addEventListener("input", (e) => {
      const query = e.target.value.toLowerCase().trim();
      suggestionsBox.innerHTML = "";
      if (query.length === 0) {
        suggestionsBox.style.display = "none";
        return;
      }
      const matches = courses.filter(item => item.toLowerCase().includes(query));
      if (matches.length > 0) {
        suggestionsBox.style.display = "block";
        matches.forEach(match => {
          const li = document.createElement("li");
          li.className = "suggest-item";
          li.textContent = match;
          li.onclick = () => {
            searchInput.value = match;
            suggestionsBox.style.display = "none";
          };
          suggestionsBox.appendChild(li);
        });
      } else {
        suggestionsBox.style.display = "none";
      }
    });

    document.addEventListener("click", (e) => {
      if (!searchInput.contains(e.target) && !suggestionsBox.contains(e.target)) {
        suggestionsBox.style.display = "none";
      }
    });
  }

  // ----------------------------------------------------
  // 2. ACTIONS CLASS: DRAG & DROP + HOVER (services.html)
  // ----------------------------------------------------
  const draggableItem = document.getElementById("drag-certificate");
  const dropZone = document.getElementById("drop-target");

  if (draggableItem && dropZone) {
    draggableItem.addEventListener("dragstart", (e) => {
      e.dataTransfer.setData("text/plain", e.target.id);
    });

    dropZone.addEventListener("dragover", (e) => {
      e.preventDefault();
      dropZone.classList.add("over");
    });

    dropZone.addEventListener("dragleave", () => {
      dropZone.classList.remove("over");
    });

    dropZone.addEventListener("drop", (e) => {
      e.preventDefault();
      dropZone.classList.remove("over");
      dropZone.textContent = "Certificate Verified & Claimed!";
      dropZone.style.backgroundColor = "#dcfce7";
      dropZone.style.borderColor = "#10b981";
      draggableItem.style.display = "none";
    });
  }

  const doubleClickBtn = document.getElementById("btn-double-click");
  if (doubleClickBtn) {
    doubleClickBtn.addEventListener("dblclick", () => {
      const msg = document.getElementById("double-click-msg");
      msg.textContent = "Enrollment Code Activated: #SEL-2026";
      msg.style.display = "block";
    });
  }

  // ----------------------------------------------------
  // 3. SHADOW DOM HOST CREATION (about.html)
  // ----------------------------------------------------
  const shadowHost = document.getElementById("open-shadow-host");
  if (shadowHost) {
    const shadowRoot = shadowHost.attachShadow({ mode: "open" });
    shadowRoot.innerHTML = `
      <style>
        .shadow-card {
          padding: 15px;
          border: 1px solid #6366f1;
          border-radius: 6px;
          background: #e0e7ff;
          color: #312e81;
          font-family: inherit;
        }
        input {
          padding: 8px;
          border: 1px solid #4f46e5;
          border-radius: 4px;
          width: 90%;
        }
      </style>
      <div class="shadow-card">
        <h4>Exclusive Student Secret Key</h4>
        <p>This element lives inside an <strong>Open Shadow Root</strong>.</p>
        <input type="text" id="shadow-key-input" placeholder="Enter student pass..." />
      </div>
    `;
  }

  // ----------------------------------------------------
  // 4. SYNCHRONIZATION / ASYNC LOADERS (contact.html)
  // ----------------------------------------------------
  const syncBtn = document.getElementById("btn-sync-trigger");
  const delayedResponse = document.getElementById("delayed-response-box");

  if (syncBtn && delayedResponse) {
    syncBtn.addEventListener("click", () => {
      delayedResponse.innerHTML = "<p><i>Requesting ticket status... Please wait (4 seconds)</i></p>";
      delayedResponse.style.display = "block";

      setTimeout(() => {
        delayedResponse.innerHTML = `
          <div style="background:#dcfce7; border:1px solid #16a34a; padding:12px; border-radius:6px; color:#14532d;">
            <strong>Success:</strong> Support Ticket #8849 Generated! (Target for WebDriverWait / FluentWait)
          </div>
        `;
      }, 4000);
    });
  }

  // ----------------------------------------------------
  // 5. MODAL POPUPS (contact.html)
  // ----------------------------------------------------
  const openModalBtn = document.getElementById("btn-open-modal");
  const closeModalBtn = document.getElementById("btn-close-modal");
  const modalBackdrop = document.getElementById("custom-modal-backdrop");

  if (openModalBtn && modalBackdrop && closeModalBtn) {
    openModalBtn.addEventListener("click", () => {
      modalBackdrop.style.display = "flex";
    });
    closeModalBtn.addEventListener("click", () => {
      modalBackdrop.style.display = "none";
    });
  }
});