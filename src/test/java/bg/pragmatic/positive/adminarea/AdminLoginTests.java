package bg.pragmatic.positive.adminarea;

import bg.pragmatic.core.BaseTest;
import bg.pragmatic.pages.adminarea.AdminLogin;
import bg.pragmatic.pages.adminarea.components.AdminHeader;
import bg.pragmatic.utils.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminLoginTests extends BaseTest {

    @Test
    public void successfulLogin() {
        AdminLogin.open();
        AdminLogin.login("admin", "parola123!");
        AdminHeader.verifyLogoutButtonText("Logout",
                "The Logout button text was not present, logout does not work.");
    }

}
