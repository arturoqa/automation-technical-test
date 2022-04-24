package com.autopractice.pages.account;

import com.microsoft.playwright.Page;

public class WishlistPage {

    private Page page;

    public WishlistPage(Page page){this.page = page;}

    public void expandWishlist(){
        page.locator("[href='javascript:;']").first().click();
    }

    public Boolean isProductInWishlist(String productName){
        String name = page.textContent("#s_title");
        return name.contains(productName);
    }

    public void deleteFromWishlist(){
        page.click(".icon-remove-sign");
    }
}
