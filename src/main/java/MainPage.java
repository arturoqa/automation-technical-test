import com.microsoft.playwright.Page;

public class MainPage {

    private Page page;

    public MainPage(Page page){
        this.page = page;
    }

    public void goToSignIn() {
        page.click(".login");
        page.waitForSelector("#SubmitCreate");
    }

}
