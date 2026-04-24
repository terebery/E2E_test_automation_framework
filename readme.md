# Selenium E2E Test Framework

End-to-end test automation framework for [DemoQA](https://demoqa.com/) built in Java with Selenium WebDriver, JUnit 5, and Allure Reports. CI/CD pipeline runs tests automatically on every push via GitHub Actions.

---

## Tech stack

| Tool | Version | Purpose |
|---|---|---|
| Java | 17 | Language |
| Selenium WebDriver | 4.18.1 | Browser automation |
| JUnit 5 | 5.10.2 | Test runner |
| Allure Reports | 2.25.0 | Test reporting |
| Maven | 3.9+ | Build & dependency management |
| GitHub Actions | — | CI/CD pipeline |

---

## Project structure

```
selenium-e2e-tests/
├── .github/
│   └── workflows/
│       └── tests.yml                        # CI/CD pipeline
├── src/
│   ├── main/java/
│   │   └── pages/
│   │       ├── BasePage.java                # shared WebDriver utilities
│   │       └── forms/
│   │           └── PracticeFormPage.java    # Practice Form page object
│   └── test/java/
│       └── tests/
│           ├── BaseTest.java                # driver setup & teardown
│           ├── ScreenshotOnFailureExtension.java
│           └── forms/
│               └── PracticeFormTest.java    # form test scenarios
├── pom.xml
└── README.md
```

---

## Design patterns

**Page Object Model** — each page is represented by a dedicated class that encapsulates locators and actions. Tests never interact with raw Selenium selectors directly, which makes the suite resilient to UI changes.

**BaseTest + JUnit 5 Extension** — `BaseTest` handles WebDriver lifecycle (setup/teardown). `ScreenshotOnFailureExtension` implements `TestWatcher` to automatically capture and attach a screenshot to the Allure report whenever a test fails.

**BasePage** — shared utility methods (`click`, `type`, `waitForElement`, `scrollIntoView`) built on top of `WebDriverWait`, eliminating raw `Thread.sleep()` calls across the codebase.

---

## Running locally

**Prerequisites:** Java 17+, Maven 3.9+, Google Chrome installed.

Clone the repository and run all tests:

```bash
git clone https://github.com/terebery/selenium-e2e-tests.git
cd selenium-e2e-tests
mvn test
```

Run in headless mode (no browser window):

```bash
mvn test -Pci
```

Generate and open Allure report:

```bash
mvn allure:serve
```

---

## CI/CD

Every push to `main` triggers the GitHub Actions pipeline which:

1. Spins up an `ubuntu-latest` runner
2. Sets up Java 17
3. Runs all tests in headless mode (`-Pci`)
4. Uploads Allure results as a build artifact

Pipeline status:

![Tests](https://github.com/terebery/selenium-e2e-tests/actions/workflows/tests.yml/badge.svg)

---

## Test coverage

| Section | Page | Scenarios |
|---|---|---|
| Forms | Practice Form | Happy path, missing required fields, modal validation |

---

## Key implementation decisions

**`elementToBeClickable` over `visibilityOfElementLocated`** — used in the `click` helper to ensure elements are both visible and interactable before clicking. Prevents failures caused by elements that are rendered but temporarily disabled.

**`scrollIntoView` before interactions** — DemoQA renders ads that overlap interactive elements. Scrolling into view before each click prevents `ElementClickInterceptedException` without relying on arbitrary waits.

**Headless flag via Maven profile** — the `-Pci` profile sets `headless=true` as a system property, keeping CI configuration in `pom.xml` rather than scattered across test classes.