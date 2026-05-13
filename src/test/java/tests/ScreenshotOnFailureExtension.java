package tests;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.*;

import java.io.ByteArrayInputStream;

public class ScreenshotOnFailureExtension implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        context.getTestInstance().ifPresent(instance -> {
            if (instance instanceof BaseTest baseTest && baseTest.page != null) {
                try{
                   byte[] screenshot = baseTest.page.screenshot();
                   Allure.addAttachment("Screenshot on Failure", new ByteArrayInputStream(screenshot));
            }     catch (Exception ignored) {
                    // Page/browser might already be closed during teardown.
                }
            }
        });
    }
}
