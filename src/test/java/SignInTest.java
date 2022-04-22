import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class SignInTest extends BaseTest {

    @Test
    public void signInTest(){
        mainPage.goToSignIn();
        assertTrue(mainPage.isSignInDisplayed(),"Is sign in button displayed");
        System.out.println("test completed");
    }

    @Test
    void test(){
        assertEquals("Hola","Hola");
    }

}
