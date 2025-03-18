package bg.pragmatic.negative.adminarea;

import bg.pragmatic.core.BaseTest;
import bg.pragmatic.pages.adminarea.AdminLogin;
import org.testng.annotations.Test;

public class AdminLoginTests extends BaseTest {

    @Test
    public void unsuccessfulLoginWithWrongCreds() {
        AdminLogin.open();
        AdminLogin.login("asdflkjasflkjas", "fjasdkaskjfdha");
        AdminLogin.verifyLoginFormValidationMessage("No match for Username and/or Password.",
                "The validation message above the login form was not shown.");
    }
}
