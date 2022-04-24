package com.autopractice.tests.account;

import com.autopractice.tests.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class MyAccountTest extends BaseTest {

    @Test
    public void addToWishListTest(){
        mainPage.goToSignIn();
        loginPage.fillLogin(loginUser,loginPass);
        loginPage.clickLogin();
        loginPage.goToMainPage();
        mainPage.goToMostPopularProductPage();
        String productName = productPage.getProductName();
        productPage.addToWishlist();
        mainPage.goToAccount();
        myAccountPage.goToWishlist();
        wishlistPage.expandWishlist();
        assertTrue(wishlistPage.isProductInWishlist(productName),"Product not correctly added to wishlist");
        wishlistPage.deleteFromWishlist();
    }

    //ORDER HISTORY AND DESTAILS TEST

    //PERSONAL

}
