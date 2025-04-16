package bg.pragmatic.pages.adminarea;

import bg.pragmatic.core.BaseActions;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Checkout extends BaseActions {
    private static final By GUEST_CHECKOUT_RADIO_BUTTON = By.id("input-guest");
    private static final By NAME_FIELD = By.id("input-firstname");
    private static final By LASTNAME_FIELD = By.id("input-lastname");
    private static final By EMAIL_FIELD = By.id("input-email");
    private static final By ADRESS1_FIELD = By.id("input-shipping-address-1");
    private static final By POSTCODE_FIELD = By.id("input-shipping-postcode");
    private static final By CITY_FIELD = By.id("input-shipping-city");
    private static final By COUNTRY_SELECT = By.id("input-shipping-country");
    private static final By REGION_SELECT = By.id("input-shipping-zone");
    private static final By CONTINUE_BUTTON = By.id("button-register");
    private static final By MASSAGE_SUCCESSFUL_SAVED_GUEST_ACCOUNT = By.xpath("//div[@class='alert alert-success alert-dismissible']");

    /**
     * Selects the "Guest Checkout" radio button and verifies that it is selected.
     */
    public static void clickOnGuestCheckout() {
        click(GUEST_CHECKOUT_RADIO_BUTTON);
        Assert.assertTrue(isSelected(GUEST_CHECKOUT_RADIO_BUTTON));
    }

    /**
     * Fills in the personal details section of the checkout form.
     */
    public static void fillPersonalDetails(String name, String lastname, String email) {
        type(NAME_FIELD, name);
        type(LASTNAME_FIELD, lastname);
        type(EMAIL_FIELD, email);
    }

    /**
     * Fills in the shipping address details in the checkout form.
     */
    public static void fillShippingAddress(String adress1, String postCode, String city, String country, String region) {
        type(ADRESS1_FIELD, adress1);
        scrollToElement(COUNTRY_SELECT);
        selectOption(COUNTRY_SELECT, country);
        type(CITY_FIELD, city);
        type(POSTCODE_FIELD, postCode);
        selectOption(REGION_SELECT, region);
    }

    /**
     * Clicks the "Continue" button to save the guest account.
     */
    public static void clickOnContinueButton() {
        scrollToElement(CONTINUE_BUTTON);
        click(CONTINUE_BUTTON);
    }

    /**
     * Verifies that the expected success message is displayed after saving the guest account.
     */
    public static void verifyMessage(String expectedMessage) {
        Assert.assertEquals(getText(MASSAGE_SUCCESSFUL_SAVED_GUEST_ACCOUNT), expectedMessage);
    }
}
