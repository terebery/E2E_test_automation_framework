package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.time.Duration;

public abstract class BasePage {
    protected Page page;

    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);

    public BasePage(Page page){
        this.page = page;
    }

    protected Locator locator(String selector){
        return page.locator(selector);
    }

    protected void click(String selector){
        page.locator(selector).click();

    }
    protected void type(String selector, String text){
        Locator element = page.locator(selector);
        element.clear();
        element.fill(text);

    }
    protected String getText(String selector){
        return page.locator(selector).textContent();
    }
    protected void scrollIntoView(String selector){
        page.locator(selector).scrollIntoViewIfNeeded();
    }
    protected boolean isDisplayed(String selector){
        return page.locator(selector).isVisible();
    }
}
