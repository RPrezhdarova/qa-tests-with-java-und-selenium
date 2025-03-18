package bg.pragmatic.pages.adminarea;

import bg.pragmatic.core.BaseActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static bg.pragmatic.utils.Browser.driver;

public class ShoppingCard extends BaseActions {
    private static final By CHECKOUT_BUTTON = By.xpath("//a[@class='btn btn-primary']");

    /**
     * Verifies that the specified product is displayed in the shopping cart.
     */
    public static void verifyProduct(String productName) {
        WebElement productNameLink = driver.findElement(By.linkText(productName));
        Assert.assertTrue(productNameLink.isDisplayed(), String.format("The link '%s' is not displayed on the page.", productName));
    }

/** Clicks the checkout button */
    public static void clickOnCheckoutButton() {
        scrollDownThePage();
        click(CHECKOUT_BUTTON);
    }
}
