package pages.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.List;

public class PracticeFormPage extends BasePage {
    private static final String URL = "https://demoqa.com/automation-practice-form";

    //locators
    private final By firstNameInput = By.id("firstName");
    private final By lastNameInput = By.id("lastName");
    private final By emailInput = By.id("userEmail");
    private final By mobileInput = By.id("userNumber");
    private final By genderMale = By.cssSelector("label[for='gender-radio-1']");
    private final By genderFemale = By.cssSelector("label[for='gender-radio-2']");
    private final By genderOther = By.cssSelector("label[for='gender-radio-3']");
    private final By subjectsInput = By.id("subjectsInput");
    private final By submitButton = By.id("submit");
    private final By successModal = By.id("example-modal-sizes-title-lg");
    private final By modalTableRows = By.cssSelector(".table-responsive tbody tr");
    private final By closeModalButton = By.id("closeLargeModal");

    public PracticeFormPage(WebDriver driver){
        super(driver);
    }

    public void open(){
        driver.get(URL);
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
        By firstSuggestion = By.cssSelector(".subjects-auto-complete__option");
        scrollIntoView(firstSuggestion);
        click(firstSuggestion);
    }

    public void submitForm(){
        scrollIntoView(submitButton);
    }

    public boolean isSuccessModalDisplayed(){
        return isDisplayed(successModal);
    }

    public String getModalTitle(){
        return getText(successModal);
    }

    public String getModalValue(String label){
        List<WebElement> rows = driver.findElements(modalTableRows);
        for (WebElement row : rows){
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.size() == 2 && cells.get(0).getText().equalsIgnoreCase(label)){
                return cells.get(1).getText();
            }
        }
        return "";
    }
    public void closeModal(){
        click(closeModalButton);
    }
}
