package com.autopractice.pages.shop;

import com.microsoft.playwright.Page;

public class ProductPage {

    private Page page;

    public ProductPage(Page page){
        this.page = page;
    }

    public void addToWishlist(){
        page.click("#wishlist_button");
    }

    public String getProductName(){
        return page.textContent("[itemprop=name]");
    }

}
