package tests.forms;
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
        form.open();
    }
    @Test
    @DisplayName("FR-01: Successful form submission shows confirmation modal")
    @Description("Fill all required fields and verify success modal appears")
    @Severity(SeverityLevel.BLOCKER)
    void shouldShowSuccessModalAfterValidSubmission(){
        form.enterFirstName(FIRST_NAME);
        form.enterLastName(LAST_NAME);
        form.enterEmailInput(EMAIL);
        form.selectGenderMale();
        form.enterMobile(MOBILE);
        form.submitForm();

        assertThat(form.isSuccessModalDisplayed())
                .as("Success modal should be visible after valid form submission")
                .isTrue();
        assertThat(form.getModalTitle())
                .as("Modal title should confirm form submission")
                .isEqualTo("Thanks for submitting the form");
    }
}


