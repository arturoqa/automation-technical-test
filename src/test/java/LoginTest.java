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

}
