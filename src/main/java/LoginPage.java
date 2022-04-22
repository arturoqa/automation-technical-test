import com.microsoft.playwright.Locator;
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
        Locator errorMessage = page.locator("#create_account_error");
        errorMessage.waitFor();
        return errorMessage.textContent().equals("Invalid email address.");
    }

}
