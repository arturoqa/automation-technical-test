package com.autopractice.pages;

import com.microsoft.playwright.Page;

public class MainPage {

    private Page page;

    public MainPage(Page page){
        this.page = page;
    }

    public void goToSignIn() {
        page.click(".login");
        page.waitForSelector("#SubmitCreate");
    }

    public void searchProduct(String product){
        page.fill("#search_query_top",product);
        page.click(".button-search");
    }

    public String addMostPopularToCart(){
        String price = page.locator(".product-price").first().textContent();
        page.locator(".product-container").first().hover();
        page.locator("text=Add to cart").first().click();
        return price;
    }

    public void goToMostPopularProductPage(){
        page.locator(".product-container").first().click();
    }

    public void proceedToCheckout(){
        page.waitForSelector("[title='Proceed to checkout']");
        page.locator("[title='Proceed to checkout']").click();
    }

    public void goToAccount(){
        page.click(".account");
    }

    public void goToWomenEveningDresses(){
        page.locator("[title='Women']").first().hover();
        page.locator("[title='Evening Dresses']").first().click();
    }

    public void goToWomenSummerDresses(){
        page.locator("[title='Women']").first().hover();
        page.locator("[title='Summer Dresses']").first().click();
    }

}
