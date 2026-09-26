// main.js — shared behavior across every page (mobile nav toggle)

document.addEventListener('DOMContentLoaded', () => {
  const menuBtn = document.querySelector('.menu-btn');
  const links = document.querySelector('nav.links');
  if (!menuBtn || !links) return;

  menuBtn.addEventListener('click', () => {
    const isOpen = links.classList.toggle('open');
    menuBtn.setAttribute('aria-expanded', isOpen ? 'true' : 'false');
    menuBtn.textContent = isOpen ? '✕' : '☰';
  });

  // Close the mobile menu after a link is tapped
  links.querySelectorAll('a').forEach(a => {
    a.addEventListener('click', () => {
      links.classList.remove('open');
      menuBtn.textContent = '☰';
      menuBtn.setAttribute('aria-expanded', 'false');
    });
  });
});
