package bg.pragmatic.pages.adminarea;
import bg.pragmatic.core.BaseActions;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Orders extends BaseActions {

    private static final By FILTER_BUTTON = By.id("button-filter");
    private static final By CUSTOMER_NAME = By.xpath("//table/tbody//td[4]");
    private static final By VIEW_ORDER_BUTTON = By.xpath("//a[@aria-label='View']");
    private static final By ORDER_ID_FIELD = By.name("filter_order_id");

    /**
     * Verifies that the expected customer name is visible in the orders table.
     * It waits until the customer name is updated and then asserts that it matches the expected name.
     */
    public static void verifyOrderIsVisible(String ExpectedCustomerName) {

        waitUntilElementIsUpdated(CUSTOMER_NAME,ExpectedCustomerName );
        Assert.assertEquals(getText(CUSTOMER_NAME), ExpectedCustomerName);
    }

    /**
     * Filters orders by entering a specific order ID and clicking the filter button.
     */

    public static void filterOrderByID(String idOrder) {
        type(ORDER_ID_FIELD, idOrder);
        click(FILTER_BUTTON);
    }

/* to be continue...
    public static void viewOrder() {
        WebElement submitButton = driver.findElement(By.id("form-order"));
        submitButton.click();

        WebElement form = driver.findElement(By.id("form-order"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.findElement(VIEW_ORDER_BUTTON).isDisplayed());
        click(VIEW_ORDER_BUTTON);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    */
}
