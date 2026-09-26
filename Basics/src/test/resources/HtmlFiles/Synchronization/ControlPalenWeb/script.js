/**
 * Application State & Initial Mock Data
 */
const appState = {
  activeView: 'members',
  filterQuery: '',
  statusFilter: 'all',
  currentPage: 1,
  pageSize: 3,
  members: [
    { id: 'USR-101', name: 'Alex Johnson', email: 'alex.j@example.com', status: 'Active' },
    { id: 'USR-102', name: 'Beatriz Chen', email: 'b.chen@example.com', status: 'Pending' },
    { id: 'USR-103', name: 'David Miller', email: 'dmiller@example.com', status: 'Suspended' },
    { id: 'USR-104', name: 'Emma Wilson', email: 'e.wilson@example.com', status: 'Active' },
    { id: 'USR-105', name: 'Frank Moore', email: 'f.moore@example.com', status: 'Pending' },
    { id: 'USR-106', name: 'Grace Taylor', email: 'g.taylor@example.com', status: 'Active' },
    { id: 'USR-107', name: 'Henry Adams', email: 'h.adams@example.com', status: 'Suspended' },
    { id: 'USR-108', name: 'Isla Green', email: 'i.green@example.com', status: 'Active' }
  ]
};

// DOM Node References
const tbody = document.getElementById('members-tbody');
const selectAllCheckbox = document.getElementById('select-all');
const searchInput = document.getElementById('search-query');
const statusSelect = document.getElementById('status-filter');
const pageSummary = document.getElementById('page-summary');
const exportBtn = document.getElementById('export-btn');

/**
 * Switch Active View (Tab switching for SPA navigation)
 */
function navigateTo(targetView) {
  // Update sidebar active link state
  document.querySelectorAll('.nav-item').forEach(item => {
    const link = item.querySelector('.nav-link');
    if (link && link.dataset.view === targetView) {
      item.classList.add('active');
    } else {
      item.classList.remove('active');
    }
  });

  // Switch visible main panel
  document.querySelectorAll('.view-panel').forEach(panel => {
    if (panel.id === `view-${targetView}`) {
      panel.classList.add('active');
    } else {
      panel.classList.remove('active');
    }
  });

  appState.activeView = targetView;
}

/**
 * Filter and Page the Member Records
 */
function getFilteredData() {
  return appState.members.filter(member => {
    const matchesQuery =
      member.name.toLowerCase().includes(appState.filterQuery.toLowerCase()) ||
      member.email.toLowerCase().includes(appState.filterQuery.toLowerCase());

    const matchesStatus =
      appState.statusFilter === 'all' || member.status === appState.statusFilter;

    return matchesQuery && matchesStatus;
  });
}

/**
 * Render the Table Body and Pagination Status
 */
function renderTable() {
  const filtered = getFilteredData();
  const totalEntries = filtered.length;
  const startIndex = (appState.currentPage - 1) * appState.pageSize;
  const pageItems = filtered.slice(startIndex, startIndex + appState.pageSize);

  tbody.innerHTML = '';

  if (pageItems.length === 0) {
    tbody.innerHTML = `
      <tr>
        <td colspan="5" style="text-align: center; color: var(--muted); padding: 24px;">
          No matching members found.
        </td>
      </tr>
    `;
  } else {
    pageItems.forEach(user => {
      const badgeClass = `badge-${user.status.toLowerCase()}`;
      const tr = document.createElement('tr');
      tr.innerHTML = `
        <td><input type="checkbox" class="row-checkbox" data-id="${user.id}" /></td>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.email}</td>
        <td><span class="badge ${badgeClass}">${user.status}</span></td>
      `;
      tbody.appendChild(tr);
    });
  }

  // Update footer summary text
  const currentEnd = Math.min(startIndex + appState.pageSize, totalEntries);
  pageSummary.textContent = `Showing ${totalEntries > 0 ? startIndex + 1 : 0} to ${currentEnd} of ${appState.members.length} entries`;

  // Attach individual row checkbox listeners to update "Select All" state
  document.querySelectorAll('.row-checkbox').forEach(cb => {
    cb.addEventListener('change', () => {
      const allChecked = Array.from(document.querySelectorAll('.row-checkbox')).every(c => c.checked);
      selectAllCheckbox.checked = allChecked;
    });
  });
}

/**
 * Export Visible Data as CSV
 */
function exportCSV() {
  const filtered = getFilteredData();
  let csvContent = 'User ID,Full Name,Email,Status\n';

  filtered.forEach(row => {
    csvContent += `"${row.id}","${row.name}","${row.email}","${row.status}"\n`;
  });

  const blob = new Blob([csvContent], { type: 'text/csv;charset=utf-8;' });
  const url = URL.createObjectURL(blob);
  const link = document.createElement('a');
  link.setAttribute('href', url);
  link.setAttribute('download', 'Member_Directory.csv');
  link.style.visibility = 'hidden';
  document.body.appendChild(link);
  link.click();
  document.body.removeChild(link);
}

/**
 * Event Listeners & Bootstrapping
 */
document.addEventListener('DOMContentLoaded', () => {
  // Navigation sidebar events
  document.querySelectorAll('.nav-link').forEach(link => {
    link.addEventListener('click', (e) => {
      e.preventDefault();
      const target = link.dataset.view;
      if (target) navigateTo(target);
    });
  });

  // Search input with real-time filtering
  searchInput.addEventListener('input', (e) => {
    appState.filterQuery = e.target.value;
    appState.currentPage = 1;
    renderTable();
  });

  // Status dropdown filter
  statusSelect.addEventListener('change', (e) => {
    appState.statusFilter = e.target.value;
    appState.currentPage = 1;
    renderTable();
  });

  // Select all checkbox functionality
  selectAllCheckbox.addEventListener('change', (e) => {
    const isChecked = e.target.checked;
    document.querySelectorAll('.row-checkbox').forEach(cb => {
      cb.checked = isChecked;
    });
  });

  // Pagination buttons
  document.querySelectorAll('.page-btn[data-page]').forEach(btn => {
    btn.addEventListener('click', (e) => {
      document.querySelectorAll('.page-btn[data-page]').forEach(b => b.classList.remove('current'));
      btn.classList.add('current');
      appState.currentPage = parseInt(btn.dataset.page, 10);
      renderTable();
    });
  });

  // CSV Export action
  exportBtn.addEventListener('click', exportCSV);

  // Initial table render
  renderTable();
});