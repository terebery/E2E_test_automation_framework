# Checkboxes — Test Requirements

## FR-07: Selecting Home checkbox selects all children
**As a** user
**I want to** select the Home checkbox
**So that** all nested items are selected automatically

### Acceptance criteria
- Clicking Home checkbox marks Desktop, Documents and Downloads as selected
- Result panel displays all selected items

---

## FR-08: Deselecting a child does not deselect parent
**As a** user
**I want to** deselect a single child checkbox
**So that** only that item is unchecked while parent remains partially selected

### Acceptance criteria
- Parent checkbox changes to indeterminate state when child is deselected
- Remaining selected children still appear in result panel

---

## FR-09: Result panel reflects selected items correctly
**As a** user
**I want to** see which items I selected
**So that** I can confirm my selection before proceeding

### Acceptance criteria
- Result panel lists exactly the items that are checked
- Result panel is not visible when nothing is selected