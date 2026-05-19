# Radio Buttons — Test Requirements

## FR-10: Selecting a radio button displays correct result
**As a** user
**I want to** select a radio button option
**So that** I can see the selected value confirmed on screen

### Acceptance criteria
- Selecting "Yes" displays text "Yes" in result panel
- Selecting "Impressive" displays text "Impressive" in result panel
- Only one option can be selected at a time

---

## FR-11: Impressive option replaces Yes selection
**As a** user
**I want to** change my radio button selection
**So that** the result updates to reflect my new choice

### Acceptance criteria
- Selecting "Impressive" after "Yes" changes result panel text to "Impressive"
- "Yes" option is no longer selected after "Impressive" is clicked

---

## FR-12: No option radio button is disabled
**As a** user
**I want to** understand which options are available
**So that** I do not attempt to interact with disabled elements

### Acceptance criteria
- "No" radio button is present on the page
- "No" radio button is disabled and cannot be clicked