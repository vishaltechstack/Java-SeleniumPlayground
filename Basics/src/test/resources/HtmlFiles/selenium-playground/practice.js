// practice.js — logic for the 13 Selenium concept labs on practice.html

// 04 WebElement interface
function toggleWe(){
  const btn = document.getElementById('weBtn');
  if (!btn) return;
  const wasDisabled = btn.hasAttribute('disabled');
  if (wasDisabled) { btn.removeAttribute('disabled'); } else { btn.setAttribute('disabled',''); }
  const out = document.getElementById('weOut');
  if (out) out.textContent = 'isEnabled(): ' + wasDisabled;
}

// 05 Synchronization
function runSync(){
  const out = document.getElementById('syncOut');
  if (!out) return;
  out.innerHTML = '<span class="spinner"></span> loading…';
  const delay = 1400 + Math.random() * 1200;
  setTimeout(() => {
    out.innerHTML = '<span id="syncResult">report ready — ' + Math.round(delay) + 'ms</span>';
  }, delay);
}

// 06 Dropdown / auto-suggestion
document.addEventListener('DOMContentLoaded', () => {
  const browsers = ['Chrome', 'Firefox', 'Safari', 'Edge', 'WebKit', 'Brave'];
  const suggestInput = document.getElementById('suggestInput');
  const suggestList = document.getElementById('suggestList');

  if (suggestInput && suggestList) {
    suggestInput.addEventListener('input', () => {
      const v = suggestInput.value.trim().toLowerCase();
      suggestList.innerHTML = '';
      if (!v) { suggestList.classList.remove('show'); return; }
      const matches = browsers.filter(b => b.toLowerCase().includes(v));
      if (!matches.length) { suggestList.classList.remove('show'); return; }
      matches.forEach(m => {
        const d = document.createElement('div');
        d.textContent = m;
        d.onclick = () => { suggestInput.value = m; suggestList.classList.remove('show'); };
        suggestList.appendChild(d);
      });
      suggestList.classList.add('show');
    });
  }

  // 07 Actions class — drag and drop
  const tile = document.getElementById('dragTile');
  const zone = document.getElementById('dropZone');
  if (tile && zone) {
    tile.addEventListener('dragstart', e => e.dataTransfer.setData('text/plain', 'tile'));
    zone.addEventListener('dragover', e => { e.preventDefault(); zone.classList.add('over'); });
    zone.addEventListener('dragleave', () => zone.classList.remove('over'));
    zone.addEventListener('drop', e => {
      e.preventDefault();
      zone.classList.remove('over');
      zone.textContent = 'dropped ✓';
      zone.style.color = 'var(--green)';
      zone.style.borderColor = 'var(--green)';
    });
  }

  // 10 Shadow DOM — real shadow root
  const host = document.getElementById('shadowHost');
  if (host && host.attachShadow) {
    const root = host.attachShadow({ mode: 'open' });
    root.innerHTML = `
      <style>
        .sd-box{ font-family:'JetBrains Mono',monospace; font-size:12px; color:#59E8B0; }
        button{ margin-top:8px; background:#F0A94E; border:none; color:#2A1900; padding:8px 14px; border-radius:6px; font-weight:700; cursor:pointer; font-family:'Sora',sans-serif; }
      </style>
      <div class="sd-box">shadow root content — invisible to a plain findElement()</div>
      <button id="shadowBtn">Click inside shadow root</button>
    `;
    const shadowBtn = root.getElementById('shadowBtn');
    if (shadowBtn) {
      shadowBtn.addEventListener('click', () => {
        root.querySelector('.sd-box').textContent = 'clicked inside the shadow root ✓';
      });
    }
  }
});

// 07 Actions class — double click / right click
function dblOut(){
  const out = document.getElementById('actOut');
  if (out) out.textContent = 'double-click registered at ' + new Date().toLocaleTimeString();
}
function rightOut(e){
  e.preventDefault();
  const out = document.getElementById('actOut');
  if (out) out.textContent = 'context-click (right-click) registered';
  return false;
}

// 08 TakesScreenshot
function toggleShot(){
  const el = document.getElementById('shotTarget');
  if (el) el.classList.toggle('highlighted');
}

// 09 JavascriptExecutor
function scrollToTarget(){
  const el = document.getElementById('jsTarget');
  if (el) el.scrollIntoView({ behavior: 'smooth', block: 'center' });
}

// 12 Pop-ups
function popupOut(val){
  const out = document.getElementById('popupResult');
  if (out) out.textContent = 'dialog result: ' + (val === null ? 'dismissed / cancelled' : String(val));
}
