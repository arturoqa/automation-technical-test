package com.autopractice.tests;

import com.autopractice.pages.account.*;
import com.autopractice.pages.shop.CheckoutPage;
import com.autopractice.pages.MainPage;
import com.autopractice.pages.shop.ProductPage;
import com.autopractice.pages.shop.SearchPage;
import com.microsoft.playwright.*;
import org.testng.annotations.*;


public class BaseTest {
    private Browser browser;
    private Page page;
    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected RegisterPage registerPage;
    protected MyAccountPage myAccountPage;
    protected SearchPage searchPage;
    protected CheckoutPage checkoutPage;
    protected ProductPage productPage;
    protected WishlistPage wishlistPage;
    protected ForgotPasswordPage forgotPasswordPage;
    protected OrderHistoryPage orderHistoryPage;
    protected PersonalInfoPage personalInfoPage;

    protected static final String loginUser = "test@login.com";
    protected static final String loginPass = "Password";

    @BeforeClass
    public void setUp(){
        browser = Playwright.create().chromium()
                .launch();
    }

    @BeforeMethod
    public void setBrowser(){
        BrowserContext context = browser.newContext();
        page = context.newPage();
        page.navigate("http://automationpractice.com/index.php");
        mainPage = new MainPage(page);
        loginPage = new LoginPage(page);
        registerPage = new RegisterPage(page);
        myAccountPage = new MyAccountPage(page);
        searchPage = new SearchPage(page);
        checkoutPage = new CheckoutPage(page);
        productPage = new ProductPage(page);
        wishlistPage = new WishlistPage(page);
        forgotPasswordPage = new ForgotPasswordPage(page);
        orderHistoryPage = new OrderHistoryPage(page);
        personalInfoPage = new PersonalInfoPage(page);
    }

    @AfterMethod
    public void cleanBrowser(){
        page.context().close();
    }

    @AfterClass
    public void tearDown(){
        browser.close();
    }
}