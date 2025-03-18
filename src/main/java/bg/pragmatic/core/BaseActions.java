package bg.pragmatic.core;

import bg.pragmatic.utils.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static bg.pragmatic.utils.Browser.driver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

/**
 * BaseActions class contains common reusable Selenium WebDriver actions.
 */
public class BaseActions {

    /**
     * Types the given text into the specified input field.
     * @param locator The By locator of the input field.
     * @param text The text to be entered.
     */
    protected static void type(By locator, String text) {
        Browser.driver.findElement(locator).sendKeys(text);
    }

    /**
     * Clicks on an element specified by the given locator.
     * @param locator The By locator of the element to be clicked.
     */
    protected static void click(By locator) {
        Browser.driver.findElement(locator).click();
    }

    /**
     * Retrieves and returns the text of an element.
     * @param locator The By locator of the element.
     * @return The text content of the element.
     */
    protected static String getText(By locator) {
        return Browser.driver.findElement(locator).getText();
    }
    /**
     * Finds and returns a list of elements matching the given locator.
     * @param locator The By locator of the elements.
     * @return A list of WebElements.
     */
    protected static List<WebElement> getElements(By locator) {
        return Browser.driver.findElements(locator);
    }
    /**
     * Checks if a specific text is present in a list of elements.
     * @param locator The By locator of the elements.
     * @param searchedElement The text to search for.
     * @return True if the text is found in any element, otherwise false.
     */
    protected static boolean isElementPresentInList(By locator, String searchedElement) {
        List<WebElement> searchedProducts = getElements(locator);
        for (WebElement e : searchedProducts) {
            if (e.getText().equals(searchedElement)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Scrolls down to the bottom of the page and waits until the scrolling is completed.
     */
    protected static void scrollDownThePage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> {
            long totalHeight = (Long) js.executeScript("return document.body.scrollHeight;");
            long currentPosition = (Long) js.executeScript("return window.pageYOffset + window.innerHeight;");
            return currentPosition >= totalHeight;
        });
    }

    /**
     * Waits until the specified element is visible on the page.
     * @param locatorToWait The By locator of the element to wait for.
     */
    protected static void waitUntilElementIsVisible(By locatorToWait){
        WebElement waitForElement = driver.findElement(locatorToWait);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(waitForElement));
    }

    /**
     * Waits until the text of the specified element matches the expected specific text.
     * @param locator The By locator of the specific element.
     * @param expectedText The expected text value.
     */
    protected static void waitUntilElementIsUpdated(By locator, String expectedText){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofMillis(500))
                .until(driver -> {
                    String acctualElementText = driver.findElement(locator).getText();
                    return acctualElementText.equals(expectedText);
                });
    }

    /**
     * Verifies the presence of a link with the specified product name.
     *
     * @param productName The name of the product whose link needs to be verified.
     */

    protected static void verifyLinkText(String productName) {
        WebElement palmTreoProLink = driver.findElement(By.linkText("Palm Treo Pro"));
    }

    /**
     * Checks if the specified element is selected.
     */
    protected static boolean isSelected (By locator){
        return driver.findElement(locator).isSelected();
    }
    /**
     * Selects an option from a dropdown menu based on visible text.
     */
    protected static void selectOption(By dropDownLocator, String wantedOption){
        WebElement dropdownElement = driver.findElement(dropDownLocator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(wantedOption);
    }
}
