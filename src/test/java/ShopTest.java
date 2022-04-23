import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ShopTest extends BaseTest {

    @Test
    public void useSearchFeatureTest(){
        mainPage.searchProduct("Blouse");
        assertTrue(searchPage.isSearchDoneCorrectly("Blouse","1"));
    }

    @Test
    public void buyProductTest(){
        mainPage.addMostPopularToCart();
        mainPage.proceedToCheckout();
        checkoutPage.proceedToSignIn();
        loginPage.fillLogin(loginUser,loginPass);
        loginPage.clickLogin();
        checkoutPage.proceedToShipping();
        checkoutPage.proceedToPayment();
        checkoutPage.payByBank();
        checkoutPage.confirmOrder();
        checkoutPage.isOrderCompleted();
    }

}
