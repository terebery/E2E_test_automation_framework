package tests.forms;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.forms.TextBoxPage;
import tests.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

@Feature("Text Box")
public class TextBoxTest extends BaseTest{
    private TextBoxPage form;

    // test data
    private static final String FULL_NAME = "Andrzej Nowak";
    private static final String EMAIL = "andrzejnowak@gmail.com";
    private static final String CURRENT_ADDRESS = "ul. Magnoliowa 21/37 \n  00-001 Warszawa";
    private static final String PERMANENT_ADDRESS = "ul. Brzozowa 4/10 \n 00-002 Kraków";

    @BeforeEach
    void openForm(){
        form = new TextBoxPage(page);
        Allure.step("Given user opens Text Box page", () -> form.open());
    }

    @Test
    @DisplayName("FR-05: Successful form submission displays output panel")
    @Description("Fill all fields and verify output panel is displayed with correct data")
    @Severity(SeverityLevel.NORMAL)
    void shouldDisplayOutputPanelAfterFormSubmission(){
        Allure.parameter("Full Name", FULL_NAME);
        Allure.parameter("Email", EMAIL);
        Allure.parameter("Current Address", CURRENT_ADDRESS);
        Allure.parameter("Permanent Address", PERMANENT_ADDRESS);

        Allure.step("When user fills out the form with valid data and submits", () -> {
            form.enterFullName(FULL_NAME);
            form.enterEmail(EMAIL);
            form.enterCurrentAddress(CURRENT_ADDRESS);
            form.enterPermanentAddress(PERMANENT_ADDRESS);
            form.submitForm();
        });

        Allure.step("Then submission window should be displayed", () ->{
            assertThat(form.outputFormIsVisible())
                    .as("Output panel should be visible after form submission")
                    .isTrue();
        });

        Allure.step("And data in the output window is equal to submitted data", () ->{
            assertThat(form.getOutputName())
                    .as("Output name should match submitted full name")
                    .isEqualTo(FULL_NAME);
            assertThat(form.getOutputMail())                    .as("Output email should match submitted email")
                    .isEqualTo(EMAIL);
            assertThat(form.getOutputCurrentAddress())
                    .as("Output current address should match submitted current address")
                    .isEqualTo(CURRENT_ADDRESS);
            assertThat(form.getOutputPermanentAddress())
                    .as("Output permanent address should match submitted permanent address")
                    .isEqualTo(PERMANENT_ADDRESS);
        });

    }

    @Test
    @DisplayName("FR-06: Output panel is not visible before submission")
    @Description("Check that output panel is not visible before form submission")
    @Severity(SeverityLevel.NORMAL)
    void outputPanelIsNOTVisibleBeforeSubmission (){
        Allure.step("Check that output panel is not visible before form submission", () -> {
            assertThat(form.outputFormIsVisible())
                    .as("Output panel should not be visible before form submission")
                    .isFalse();
        });
        }
    }