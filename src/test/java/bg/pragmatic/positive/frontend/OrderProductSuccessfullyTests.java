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
    public void findProductAndAddItToCard(){

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
        }
    }
