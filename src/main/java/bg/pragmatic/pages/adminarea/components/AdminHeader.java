package bg.pragmatic.pages.adminarea.components;

import bg.pragmatic.core.BaseActions;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AdminHeader extends BaseActions {

    private static final By LOGOUT_BUTTON = By.cssSelector("li#nav-logout span");

    /**
     * Asserts that the logout button text is as expected based on provided parameter
     * @param expectedLoginButtonText the expected text you would want to see in the logout button
     * @param messageOnFailure the message that will appear in your test reports in case of failure
     */
    public static void verifyLogoutButtonText(String expectedLoginButtonText, String messageOnFailure) {
        String actualLoginButtonText = getText(LOGOUT_BUTTON);
        Assert.assertEquals(actualLoginButtonText, expectedLoginButtonText, messageOnFailure);
    }
}
