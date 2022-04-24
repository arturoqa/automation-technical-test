package com.autopractice.pages.account;

import com.microsoft.playwright.Page;

public class OrderHistoryPage {

    private Page page;

    public OrderHistoryPage(Page page){
        this.page = page;
    }

    public Boolean isOrderHistoryDisplayed(){
        page.waitForSelector("text='ZPOENZAOW'");
        return page.isVisible("text='ZPOENZAOW'");
    }
}
