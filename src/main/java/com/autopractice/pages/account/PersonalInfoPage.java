package com.autopractice.pages.account;

import com.microsoft.playwright.Page;

public class PersonalInfoPage {

    private Page page;

    public PersonalInfoPage(Page page){
        this.page = page;
    }

    public Boolean isPersonalInfoDisplayed(String fName, String lName, String email){
        Boolean correctFName = page.getAttribute("#firstname","value").equals(fName);
        Boolean correctLName = page.getAttribute("#lastname","value").equals(lName);
        Boolean correctEmail = page.getAttribute("#email","value").equals(email);
        return correctFName && correctLName && correctEmail;
    }

}
