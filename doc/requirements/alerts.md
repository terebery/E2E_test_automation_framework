# Browser Alerts — Test Requirements

## FR-13: Simple alert can be accepted
**As a** user
**I want to** trigger and accept a simple browser alert
**So that** I can confirm the interaction was handled correctly

### Acceptance criteria
- Clicking "Click me" button triggers a browser alert
- Alert can be accepted
- Page remains functional after alert is dismissed

---

## FR-14: Confirm alert returns correct result on accept
**As a** user
**I want to** accept a confirm dialog
**So that** the page displays "You selected Ok"

### Acceptance criteria
- Clicking confirm button triggers a confirm dialog
- Accepting dialog displays "You selected Ok" on the page
- Dismissing dialog displays "You selected Cancel" on the page

---

## FR-15: Prompt alert accepts and displays custom text
**As a** user
**I want to** enter text in a prompt dialog
**So that** the page displays my input back to me

### Acceptance criteria
- Clicking prompt button triggers a prompt dialog
- Entering text and confirming displays that text in the result on the page
- Result matches exactly what was typed into the prompt