package com.autopractice.tests.account;

import com.autopractice.tests.BaseTest;
import org.testng.annotations.Test;

import java.util.Date;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class SignInTest extends BaseTest {

    @Test
    public void signInTest(){
        mainPage.goToSignIn();
        loginPage.createAccount("testemail"+(new Date().getTime())+"@gmail.com");
        registerPage.fillMandatoryInformation("new","tester","password",
                "address","city","1","52663",
                "21","555123456");
        registerPage.clickRegister();
        assertTrue(myAccountPage.isUserLogged(),"User registration not completed correctly");
    }

    @Test
    public void signInInvalidEmailFormatTest(){
        mainPage.goToSignIn();
        loginPage.createAccount("wrongFormatEmail");
        assertTrue(loginPage.isWrongEmailFormatDisplayed(),"Wrong format for the email error not displayed");
    }

    @Test
    public void missingMandatoryFieldsTest(){
        mainPage.goToSignIn();
        loginPage.createAccount("testemail"+(new Date().getTime())+"@gmail.com");
        registerPage.clickRegister();
        assertTrue(registerPage.isParametersMissingErrorDisplayed(),"Missing parameter errors are not displayed correctly");
    }


}
