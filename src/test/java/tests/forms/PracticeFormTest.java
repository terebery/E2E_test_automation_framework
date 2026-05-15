package tests.forms;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.forms.PracticeFormPage;
import tests.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

@Feature("Practice Form")
class PracticeFormTest extends BaseTest {
    private PracticeFormPage form;

    //test data
    private static final String FIRST_NAME = "Jan";
    private static final String LAST_NAME = "Kowalski";
    private static final String EMAIL = "jan.kowalski@buziaczek.com";
    private static final String MOBILE = "1234567890";

    @BeforeEach
    void openForm(){
        form = new PracticeFormPage(page);
        Allure.step("Given user opens Practice Form page", () -> form.open());
    }
    @Test
    @DisplayName("FR-01: Successful form submission shows confirmation modal")
    @Description("Fill all required fields and verify success modal appears")
    @Severity(SeverityLevel.BLOCKER)
    void shouldShowSuccessModalAfterValidSubmission(){
        Allure.parameter("First Name", FIRST_NAME);
        Allure.parameter("Last Name", LAST_NAME);
        Allure.parameter("Email", EMAIL);
        Allure.parameter("Mobile", MOBILE);

        Allure.step("When user fills out the form with valid data and submits", () -> {
            form.enterFirstName(FIRST_NAME);
            form.enterLastName(LAST_NAME);
            form.enterEmailInput(EMAIL);
            form.selectGenderMale();
            form.enterMobile(MOBILE);
            form.submitForm();
        });

        Allure.step("Then a success modal should be displayed confirming form submission", () ->
        assertThat(form.isSuccessModalDisplayed())
                .as("Success modal should be visible after valid form submission")
                .isTrue()
        );
        Allure.step("And the modal title should confirm form submission", () ->
        assertThat(form.getModalTitle())
                .as("Modal title should confirm form submission")
                .isEqualTo("Thanks for submitting the form")
        );
    }

    @Test
    @DisplayName("FR-02: Required field validation prevents form submission")
    @Description("User is prevented from submitting an empty form")
    @Severity(SeverityLevel.BLOCKER)
    void  submittingEmptyFormDoesNotOpenSuccessModal(){
        Allure.step("When user submits empty form", () -> form.submitForm());

        Allure.step("Then success modal should not be displayed", () ->
        assertThat(form.isSuccessModalDisplayed())
                .as("Success modal should not be visible when required fields are empty")
                .isFalse()
        );

        Allure.step("And form enters validated state", () ->
        assertThat(form.isFormValidated())
                .as("Form should show validation errors when submitted empty")
                .isTrue());

        Allure.step("And required field: First Name is invalid",() ->
        assertThat(form.isFirstNameInvalid())
                .as("First Name field should be marked as invalid when empty")
                .isTrue());

        Allure.step("And required field: Last Name is invalid",() ->
        assertThat(form.isLastNameInvalid())
                .as("Last Name field should be marked as invalid when empty")
                .isTrue());

        Allure.step("And required field: Mobile is invalid",() ->
        assertThat(form.isMobileInvalid())
                .as("Mobile field should be marked as invalid when empty")
                .isTrue());

        Allure.step("And required field: Gender is invalid",() ->
        assertThat(form.isGenderInvalid())
                .as("Gender) field should be marked as invalid when not selected")
                .isTrue());
    }
}


