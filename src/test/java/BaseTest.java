import com.microsoft.playwright.*;
import org.testng.annotations.*;


public class BaseTest {
    private Browser browser;
    private Page page;
    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected RegisterPage registerPage;
    protected MyAccountPage myAccountPage;

    @BeforeClass
    public void setUp(){
        browser = Playwright.create().chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false));
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