package pages.forms;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;
import com.microsoft.playwright.options.WaitForSelectorState;
import pages.BasePage;

public class TextBoxPage extends BasePage {
    private static final String URL = "https://demoqa.com/text-box" ;

    //Selectors - form
    private static final String inputFullName = "#userName";
    private static final String inputEmail = "#userEmail";
    private static final String currentAddress = "#currentAddress";
    private static final String permanentAddress = "#permanentAddress";
    private static final String submitButton = "#submit";

    // Selectors - output panel
    private static final String outputPanel = "#output";
    private static final String outputName = "#name";
    private static final String outputMail = "#email";
    private static final String outputCurrentAddress = "#currentAddress.mb-1";
    private static final String outputPermanentAddress = "#permamentAddress.mb-1";

    public TextBoxPage(Page page){
        super(page);
    }
    public void open(){
        page.navigate(URL);
    }

    public void enterFullName(String fullName){
        type(inputFullName, fullName);
    }

    public void enterEmail(String email){
        type(inputEmail,email);
    }

    public void enterCurrentAddress(String address){
        type(currentAddress,address);
    }

    public void enterPermanentAddress(String address){
        type(permanentAddress, address);
    }

    public void submitForm(){
        page.locator(submitButton).scrollIntoViewIfNeeded();
        page.locator(submitButton).click(new Locator.ClickOptions().setForce(true));
    }

    public boolean outputFormIsVisible(){
        try {
            page.locator(outputPanel).waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(5000)
            );
            return true;
        } catch (TimeoutError e) {
            return false;
        }
    }
    public String getOutputName(){
        return getText(outputName).replace("Name:", "").trim();
    }

    public String getOutputMail(){
        return getText(outputMail).replace("Email:", "").trim();
    }

    public String getOutputCurrentAddress(){
        return getText(outputCurrentAddress).replace("Current Address :", "").trim();
    }

    public String getOutputPermanentAddress(){
        return getText(outputPermanentAddress).replace("Permanent Address :", "").trim();
    }
}
