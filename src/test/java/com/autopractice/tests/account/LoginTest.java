package com.autopractice.tests.account;

import com.autopractice.tests.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void loginCorrectlyTest(){
        mainPage.goToSignIn();
        loginPage.fillLogin(loginUser,loginPass);
        loginPage.clickLogin();
        assertTrue(myAccountPage.isUserLogged(),"Login not done correctly");
    }

    @Test
    public void incorrectCredentialsTest(){
        mainPage.goToSignIn();
        loginPage.fillLogin("incorrect@login.com","incorrectPass");
        loginPage.clickLogin();
        assertTrue(loginPage.isWrongCredentialsErrorDisplayed(),"Wrong credentials error not triggered correctly");
    }

    @Test
    public void incorrectLoginEmailFormatTest(){
        mainPage.goToSignIn();
        loginPage.fillLogin("incorrectFormat","incorrectPass");
        assertTrue(loginPage.isWrongEmailFormatInLoginDisplayed(),"Wrong login email format error not displayed");
    }

    @Test
    public void doForgotPasswordFlowTest(){
        mainPage.goToSignIn();
        loginPage.goToForgotPassword();
        forgotPasswordPage.fillEmail(loginUser);
        forgotPasswordPage.clickRetrievePassword();
        assertTrue(forgotPasswordPage.isSentEmailDisplayed(),"Email has not been sent");
    }

    //The following test is for a feature that should not exist as confirming that an account with and specific email does not
    // exist is a security issue
    @Test
    public void doForgotPasswordWithNotExistingAccountTest(){
        mainPage.goToSignIn();
        loginPage.goToForgotPassword();
        forgotPasswordPage.fillEmail("notexistingaccount@notexisting.com");
        forgotPasswordPage.clickRetrievePassword();
        assertTrue(forgotPasswordPage.isNotExistingAccountDisplayed(),"Not existing account message not displayed");
    }

}
