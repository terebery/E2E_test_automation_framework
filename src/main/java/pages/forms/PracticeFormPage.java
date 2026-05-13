package pages.forms;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;
import com.microsoft.playwright.options.WaitForSelectorState;
import pages.BasePage;



public class PracticeFormPage extends BasePage {
    private static final String URL = "https://demoqa.com/automation-practice-form";

    //selectors
    private static final String firstNameInput = "#firstName";
    private static final String lastNameInput = "#lastName";
    private static final String emailInput = "#userEmail";
    private static final String mobileInput = "#userNumber";
    private static final String genderMale = "label[for='gender-radio-1']";
    private static final String genderFemale = "label[for='gender-radio-2']";
    private static final String genderOther = "label[for='gender-radio-3']";
    private static final String subjectsInput = "#subjectsInput";
    private static final String first_Subject_Suggestion = ".subjects-auto-complete__option";
    private static final String submitButton = "#submit";
    private static final String successModal = "#example-modal-sizes-title-lg";
    private static final String modalTableRows = ".table-responsive tbody tr";
    private static final String closeModalButton = "#closeLargeModal";

    public PracticeFormPage(Page page){
        super(page);
    }

    public void open(){
        page.navigate(URL);
    }

    public void enterLastName(String lastName){
        type(lastNameInput, lastName);
    }

    public void enterFirstName(String firstName){
        type(firstNameInput, firstName);
    }

    public void enterEmailInput(String email){
        type(emailInput, email);
    }

    public void enterMobile(String mobile){
        type(mobileInput, mobile);
    }

    public void selectGenderMale(){
        scrollIntoView(genderMale);
        click(genderMale);
    }

    public void selectGenderFemale() {
        scrollIntoView(genderFemale);
        click(genderFemale);
    }

    public void selectGenderOther() {
        scrollIntoView(genderOther);
        click(genderOther);
    }

    public void enterSubject(String subject){
        type(subjectsInput, subject);
        scrollIntoView(first_Subject_Suggestion);
        click(first_Subject_Suggestion);
    }

    public void submitForm(){
        page.locator(submitButton).scrollIntoViewIfNeeded();
        page.locator(submitButton).click(new Locator.ClickOptions().setForce(true));
    }

    public boolean isSuccessModalDisplayed(){
        try {
            page.locator(successModal).waitFor(
                    new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(10000)
            );
            return true;
        } catch (TimeoutError e) {
            return false;
        }
    }

    public String getModalTitle(){
        return getText(successModal);
    }

    public String getModalValue(String label){
       Locator rows = page.locator(modalTableRows);
       int count = rows.count();
        for (int i = 0; i < count; i++) {
            Locator cells = rows.nth(i).locator("td");
            if (cells.count() == 2) {
                String rowLabel = cells.nth(0).textContent();
                if (rowLabel != null && rowLabel.trim().equalsIgnoreCase(label)) {
                    String value = cells.nth(1).textContent();
                    return  value == null ? "": value.trim();
                }
            }
        }

        return "";
    }
    public void closeModal(){
        click(closeModalButton);
    }
}
