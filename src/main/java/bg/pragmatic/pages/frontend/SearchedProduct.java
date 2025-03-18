package bg.pragmatic.pages.frontend;

import bg.pragmatic.core.BaseActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static bg.pragmatic.utils.Browser.driver;

public class SearchedProduct extends BaseActions {
    private static final By SEARCHED_ELEMENTS = By.xpath("//div[@class='content']//h4/a");
    private static final By ADD_TO_CARD_BUTTON = By.xpath("//h4/a[text()='Palm Treo Pro']/ancestor::div[contains(@class, 'product-thumb')]//button[@type='submit'][1]");
    private static final By MASSAGE_SUCCESSFUL_ADD_TO_CARD = By.xpath("//*[@id=\"alert\"]//div[@class='alert alert-success alert-dismissible']");
    private static final By SHOPING_CARD_BUTTON = By.xpath("//button[@class='btn btn-lg btn-inverse btn-block dropdown-toggle']");
    private static final By SHOPING_CARD_ALERT_LINK = By.xpath("//div[@id=\"alert\"]//div[@class='alert alert-success alert-dismissible']//a[text()='shopping cart']");
    /**
     * Verifies whether a product with the specified name is visible in the search results.
     * @param productName the name of the product to verify
     */
    public static void verifyVisibility(String productName) {
        boolean isProductFoundAndVisible = isElementPresentInList(SEARCHED_ELEMENTS, productName);
        Assert.assertTrue(isProductFoundAndVisible, "Product that you search was not found!");
    }

    /**
     * Scrolls the page down and clicks the "Add to Cart" button for the specified product.
     */
    public static void addToShoppingCard(String productName) {
        scrollDownThePage();
        click(ADD_TO_CARD_BUTTON);
    }

    /**
     * Verifies that the message displayed on the page matches the expected success message.
     * */
    public static void verifyMessage(String expectedMessage) {
        Assert.assertEquals(getText(MASSAGE_SUCCESSFUL_ADD_TO_CARD), expectedMessage);
    }
    /**
     * Clicks on the shopping cart alert link.
     * */
    public static void clickShopingCardButton() {
        click(SHOPING_CARD_ALERT_LINK);
    }
}
