package bg.pragmatic.positive.frontend;
import bg.pragmatic.core.BaseTest;
import bg.pragmatic.pages.adminarea.AdminLogin;
import bg.pragmatic.pages.adminarea.Checkout;
import bg.pragmatic.pages.adminarea.Orders;
import bg.pragmatic.pages.adminarea.ShoppingCard;
import bg.pragmatic.pages.adminarea.components.AdminHeader;
import bg.pragmatic.pages.adminarea.components.AdminNavbar;
import bg.pragmatic.pages.frontend.HomePage;
import bg.pragmatic.pages.frontend.SearchedProduct;
import org.testng.annotations.Test;

public class OrderProductSuccessfullyTests extends BaseTest {

    String productName="Palm Treo Pro";

    @Test
    public void placeOrderSuccessfully(){

        HomePage.open();
        HomePage.searchProduct(productName);
        SearchedProduct.verifyVisibility(productName);
        SearchedProduct.addToShoppingCard(productName);
        SearchedProduct.verifyMessage("Success: You have added " + productName + " to your shopping cart!");
        SearchedProduct.clickShopingCardButton();
        ShoppingCard.verifyProduct(productName);
        ShoppingCard.clickOnCheckoutButton();
        Checkout.clickOnGuestCheckout();
        Checkout.fillPersonalDetails("Rositsa", "Prezhdarova", "test123@abv.bg");
        Checkout.fillShippingAddress("LiegnitzerStr", "85435", "Erding", "Germany", "Bayern");
        Checkout.clickOnContinueButton();
        Checkout.verifyMessage("Success: Your guest account information has been saved!");


        //to be continue....

        /* Checkout.verifyProductDetails();
       Checkout.agreePrivacyPolicy();
        Checkout.clickOnContinue();
        Checkout.chooseShippingMethod();
        CheckOut.ChoosePaymentMethod();
        Checkout.clickConfirmOrderButton();
        ConfirmationOrder.verifyConfirmationText("Your order has been placed!");
        ConfirmationOrder.clickOnContinueButton();
        HomePage.verifyHomePageVisibility();
        */
    }

    @Test
    public void AddProductToExistingOrder(){

            //Login to backend
            AdminLogin.open();
            AdminLogin.login("admin", "parola123!");
            AdminHeader.verifyLogoutButtonText("Logout",
                    "The Logout button text was not present, logout does not work.");

            //Find the order which you want to add a product
            AdminNavbar.sales();
            AdminNavbar.orders();
            Orders.filterOrderByID("98");
            Orders.verifyOrderIsVisible("Rositsa Prezhdarova");

            //to be continue.. -> Add product

            /* Orders.viewOrder();
            Order.clickAddProductButton();
            AddItem.chooseProduct();
            AddItem.fillProductQuantity("2");
            AddItem.chooseRadio();
            AddItem.selectCheckbox();
            AddItem.fillText("test");
            AddItem.selectFromDropDown();
            AddItem.fillTextArea("testArea");
            AddItem.uploadFile();
            AddItem.acceptAllertMessage();
            AddItem.clickSaveButton();
            AddItem.verifyMessage("SuccessfullyModifiedTheProduct");
            AddItem.closeWindow();
            Order.verifyTheAddedProduct();
            */

        }
    }