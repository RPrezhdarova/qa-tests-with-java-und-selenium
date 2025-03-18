package bg.pragmatic.pages.adminarea.components;

import bg.pragmatic.core.BaseActions;
import org.openqa.selenium.By;

/**
 * AdminNavbar class provides navigation functionalities for the panel in admin webpage.
 */
public class AdminNavbar extends BaseActions {
    private static final By SALES_MENU = By.xpath("//a[@href='#collapse-4']");
    private static final By ORDER_MENU = By.xpath("(//ul[@class='collapse show']//li)[1]");

    /**
     * Clicks on the Sales menu to navigate to the Sales section.
     */
    public static void sales() {
       click(SALES_MENU);
    }

    /**
     * Clicks on the Orders menu to navigate to the Orders section.
     */
    public static void orders() {
        click(ORDER_MENU);
    }
}
