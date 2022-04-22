import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {
    private Browser browser;
    protected MainPage mainPage;

    @BeforeClass
    public void setUp(){
        browser = Playwright.create().chromium()
                .launch();

        Page page = browser.newPage();
        page.navigate("http://automationpractice.com/index.php");
        mainPage = new MainPage(page);
    }

    @AfterClass
    public void tearDown(){
        browser.close();
    }
}