import com.microsoft.playwright.Page;

public class MyAccountPage {

    private Page page;

    public MyAccountPage(Page page){
        this.page = page;
    }

    public Boolean isUserLogged(){
        page.waitForSelector(".logout");
        return page.isVisible(".logout");
    }

}
