package bg.pragmatic.pages.frontend;

import bg.pragmatic.core.BaseActions;
import bg.pragmatic.utils.Browser;
import org.openqa.selenium.By;

public class HomePage extends BaseActions {

    private static String url = "http://auto.pragmatic.bg";
    private static final By SEARCH_FIELD = By.name("search");
    private static final By SEARCH_BUTTON = By.xpath("//div[@id='search']/button");

    /**
     * Searches for a product by entering the product name in the search field
     * and clicking the search button.
     * @param productName the name of the product to search for
     */
    public static void searchProduct(String productName) {
        type(SEARCH_FIELD, productName);
        click(SEARCH_BUTTON);

    }
    /**
     * Opens the homepage by navigating to the specified URL.
     */
    public static void open() {
        Browser.driver.get(url);
    }
}
