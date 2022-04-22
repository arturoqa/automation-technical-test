import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    public LoginPage(Page page){
        this.page = page;
    }

    public void createAccount(String email){
        page.fill("#email_create",email);
        page.click("#SubmitCreate");
    }
    public boolean isWrongEmailFormatDisplayed(){
        page.waitForSelector("#create_account_error");
        return page.isVisible("#create_account_error");
    }

}
