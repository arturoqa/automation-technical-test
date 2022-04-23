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