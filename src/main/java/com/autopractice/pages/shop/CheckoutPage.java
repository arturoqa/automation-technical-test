package com.autopractice.pages.shop;

import com.microsoft.playwright.Page;

public class CheckoutPage {

    private Page page;

    public CheckoutPage(Page page){
        this.page = page;
    }

    public void proceedToSignIn(){
        page.waitForSelector(".step_current.first");
        page.click(".standard-checkout");
    }

    public void proceedToShipping(){
        page.waitForSelector(".step_current.third");
        page.locator("[name=processAddress]").click();
    }

    public String proceedToPayment(){
        page.waitForSelector(".step_current.four");
        String deliveryPrice = page.locator(".delivery_option_price").first().textContent();
        page.check("#cgv");
        page.locator("[name=processCarrier]").click();
        return deliveryPrice;
    }

    public void payByBank(){
        page.waitForSelector(".step_current.last");
        page.click(".bankwire");
    }

    public void payByCheck(){
        page.waitForSelector(".step_current.last");
        page.click(".cheque");
    }

    public void confirmOrder(){
        page.click("#cart_navigation button");
    }

    public Boolean isOrderCompleted(){
        page.waitForSelector("text=Your order on My Store is complete.");
        return page.isVisible("text=Your order on My Store is complete.");
    }

}
