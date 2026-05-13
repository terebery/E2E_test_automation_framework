# Practice Form — Test Requirements

## FR-01: Successful form submission
**As a** user  
**I want to** fill in all required fields and submit the form  
**So that** I can see a confirmation modal with correct data

### Acceptance criteria
- Form accepts valid first name, last name, email, mobile and gender
- On submit a success modal appears with title "Thanks for submitting the form"
- Modal table contains correct student name in format "FirstName LastName"
- Modal table contains correct email address
- Modal table contains correct mobile number

---

## FR-02: Required field validation
**As a** user  
**I want to** be prevented from submitting an empty form  
**So that** I cannot send incomplete data

### Acceptance criteria
- Submitting empty form does not open success modal
- Required fields (first name, last name, gender, mobile) are visually marked as invalid

---

## FR-03: Student name displayed correctly in modal
**As a** user  
**I want to** see my full name in the confirmation modal  
**So that** I can verify my submission was recorded correctly

### Acceptance criteria
- Modal displays first name and last name concatenated with a space
- Value matches exactly what was entered in the form

---

## FR-04: Email displayed correctly in modal
**As a** user  
**I want to** see my email address in the confirmation modal  
**So that** I can verify my contact data was saved correctly

### Acceptance criteria
- Modal displays the exact email address that was entered
- Value is shown in the "Student Email" row of the summary table