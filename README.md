# E2E Test Framework

End-to-end test automation framework for [DemoQA](https://demoqa.com/) built in Java with Playwright, JUnit 5, and Allure Reports. CI/CD pipeline runs tests automatically on every push via GitHub Actions.

---

## Tech stack

| Tool | Version | Purpose |
|---|---|---|
| Java | 17 | Language |
| Playwright for Java | 1.52.0 | Browser automation |
| JUnit 5 | 5.10.2 | Test runner |
| Allure Reports | 2.25.0 | Test reporting |
| Maven | 3.9+ | Build & dependency management |
| GitHub Actions | — | CI/CD pipeline |

---

## Project structure

```text
E2E_test_automation_framework/
├── .github/
│   └── workflows/
│       └── tests.yaml                       # CI/CD pipeline
├── src/
│   ├── main/java/
│   │   └── pages/
│   │       ├── BasePage.java                # shared Playwright utilities
│   │       └── forms/
│   │           └── PracticeFormPage.java    # Practice Form page object
│   └── test/java/
│       └── tests/
│           ├── BaseTest.java                # Playwright setup & teardown
│           ├── ScreenshotOnFailureExtension.java
│           └── forms/
│               └── PracticeFormTest.java    # form test scenarios
├── pom.xml
└── README.md