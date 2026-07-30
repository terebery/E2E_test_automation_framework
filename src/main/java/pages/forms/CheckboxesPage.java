package pages.forms;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pages.BasePage;

import javax.swing.*;

public class CheckboxesPage extends BasePage {
    private final static String URL = "https://demoqa.com/checkbox";
    private static final String RESULT = "#result";

    //SELECTORS

    //Directories
    private final Locator HOME;
    private final Locator DESKTOP;
    private final Locator DOCUMENTS;
    private final Locator DOWNLOADS;
    private final Locator WORKSPACE;
    private final Locator OFFICE;

    //Files
    private final Locator NOTES;
    private final Locator COMMANDS;
    private final Locator REACT;
    private final Locator ANGULAR;
    private final Locator VUE;
    private final Locator PUBLIC;
    private final Locator PRIVATE;
    private final Locator CLASSIFIED;
    private final Locator GENERAL;
    private final Locator WORD_FILE;
    private final Locator EXCEL_FILE;

    public CheckboxesPage(Page page){
        super(page);
        this.HOME = page.getByLabel("Select Home");
        this.DESKTOP = page.getByLabel("Select Desktop");
        this.DOCUMENTS = page.getByLabel("Select Documents");
        this.DOWNLOADS = page.getByLabel("Select Downloads");
        this.WORKSPACE = page.getByLabel("Select WorkSpace");
        this.OFFICE = page.getByLabel("Select Office");

        this.NOTES = page.getByLabel("Select Notes");
        this.COMMANDS = page.getByLabel("Select Commands");
        this.REACT = page.getByLabel("Select React");
        this.ANGULAR = page.getByLabel("Select Angular");
        this.VUE = page.getByLabel("Select Vue");
        this.PUBLIC = page.getByLabel("Select Public");
        this.PRIVATE = page.getByLabel("Select Private");
        this.CLASSIFIED = page.getByLabel("Select Classified");
        this.GENERAL = page.getByLabel("Select General");
        this.WORD_FILE = page.getByLabel("Select Word File.doc");
        this.EXCEL_FILE = page.getByLabel("Select Excel File.doc");
    }


    public void select(Locator checkbox){
        if (!checkbox.isChecked()){
        checkbox.click();
        }

    }
    public void selectAll(){
        select(HOME);
        select(DESKTOP);
        select(DOCUMENTS);
        select(DOWNLOADS);
        select(WORKSPACE);
        select(OFFICE);
    }

    public void unselect(Locator checkbox){
        if (!checkbox.isChecked()) {
            checkbox.click();
        }
    }

    public void unselectAll(){
        unselect(HOME);
        unselect(DESKTOP);
        unselect(DOCUMENTS);
        unselect(DOWNLOADS);
        unselect(WORKSPACE);
        unselect(OFFICE);
    }

    public Boolean isCheckboxSelected(Locator checkbox){
       return checkbox.isChecked();
    }

    public void selectMultiple(Locator ... checkboxes){
        for (Locator checkbox : checkboxes) {
            select(checkbox);
        }
    }

    public void unselectMultiple(Locator ... checkboxes){
        for (Locator checkbox : checkboxes){
            unselect(checkbox);
        }
    }

    public boolean verifyResult(String expectedResult){
        String actualResult = getText(RESULT);
        return actualResult.contains(expectedResult);
    }

}