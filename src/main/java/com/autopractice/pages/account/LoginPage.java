package com.autopractice.pages.account;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    private static final String authErrorLocator = "text=Authentication failed.";

    private static final String loginFormErrorLocator = ".form-error";

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

    public void fillLogin(String user, String password){
        page.fill("#email",user);
        page.fill("#passwd",password);
    }

    public void clickLogin(){
        page.click("#SubmitLogin");
    }

    public void goToMainPage(){
        page.click(".logo");
    }

    public Boolean isWrongCredentialsErrorDisplayed(){
        page.waitForSelector(authErrorLocator);
        return page.isVisible(authErrorLocator);
    }

    public Boolean isWrongEmailFormatInLoginDisplayed(){
        page.waitForSelector(loginFormErrorLocator);
        return page.isVisible(loginFormErrorLocator);
    }
}
