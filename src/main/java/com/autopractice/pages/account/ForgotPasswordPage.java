package com.autopractice.pages.account;

import com.microsoft.playwright.Page;

public class ForgotPasswordPage {

    private Page page;

    public ForgotPasswordPage(Page page){
        this.page = page;
    }

    public void fillEmail(String email){
        page.fill("#email",email);
    }

    public void clickRetrievePassword(){
        page.click("text=Retrieve Password");
    }

    public Boolean isSentEmailDisplayed(){
        page.waitForSelector(".alert-success");
        return page.isVisible(".alert-success");
    }

    public Boolean isNotExistingAccountDisplayed(){
        return page.textContent(".alert-danger").contains("There is no account registered for this email address.");
    }

}
