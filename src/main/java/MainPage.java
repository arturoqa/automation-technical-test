import com.microsoft.playwright.Page;

public class MainPage {

    private Page page;

    private final String signInButtonLocator = "#SubmitCreate";

    public MainPage(Page page){
        this.page = page;
    }

    public void goToSignIn() {
        page.click(".login");
        page.waitForSelector(signInButtonLocator);
    }

    public Boolean isSignInDisplayed(){
        return page.isVisible(signInButtonLocator);
    }
}
