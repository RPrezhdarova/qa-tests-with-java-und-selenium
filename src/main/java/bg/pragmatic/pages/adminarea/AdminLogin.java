package bg.pragmatic.pages.adminarea;

import bg.pragmatic.core.BaseActions;
import bg.pragmatic.utils.Browser;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AdminLogin extends BaseActions {

    private static String url = "http://auto.pragmatic.bg/manage";

    private static final By PASSWORD_INPUT_FIELD = By.id("input-password");
    private static final By USERNAME_INPUT_FIELD = By.id("input-username");
    private static final By LOGIN_BUTTON = By.cssSelector(".btn-primary");
    private static final By LOGIN_FORM_VALIDATION_MESSAGE = By.cssSelector(".alert-danger");

    /**
     * Opens the login page of the admin area of auto.pragmatic.bg/manage
     */
    public static void open() {
        Browser.driver.get(url);
    }

    /**
     * Logs into the admin area of auto.pragmatic.bg/manage with the provided
     * credentials
     * @param username the username you would like to login with
     * @param password the password you would like to login with
     */
    public static void login(String username, String password) {
        type(USERNAME_INPUT_FIELD, username);
        type(PASSWORD_INPUT_FIELD, password);
        click(LOGIN_BUTTON);
    }

    /**
     * Asserts that the login form validation message above in red is as we expect it
     * when wrong credentials are provided
     * @param expectedLoginFormValidationMessage the validation message we expect to be shown
     * @param messageOnFailure the message that will appear in your tests reports in case of failure
     */
    public static void verifyLoginFormValidationMessage(String expectedLoginFormValidationMessage, String messageOnFailure) {
        String actualLoginFormValidationMessage = getText(LOGIN_FORM_VALIDATION_MESSAGE);
        Assert.assertEquals(actualLoginFormValidationMessage, expectedLoginFormValidationMessage, messageOnFailure);
    }
}
