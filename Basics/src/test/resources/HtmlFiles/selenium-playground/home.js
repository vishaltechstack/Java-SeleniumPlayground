// home.js — hero warm-up widget on index.html

function runDemo(){
  const out = document.getElementById('demoOut');
  if (out) out.textContent = 'clicked at ' + new Date().toLocaleTimeString();
}
