package com.autopractice.pages.shop;

import com.microsoft.playwright.Page;

public class SearchPage {

    private Page page;

    public SearchPage(Page page){
        this.page = page;
    }

    public Boolean isSearchDoneCorrectly(String product, String numOfProducts){
        Boolean productFound=isProductFound(product);
        Boolean isNumOfProducts= isNumOfProductFoundCorrect(numOfProducts);
        return productFound && isNumOfProducts;
    }

    public Boolean isProductFound(String product){
        page.waitForSelector(".product-listing");
        return page.isVisible("[title=Blouse]");
    }

    public Boolean isNumOfProductFoundCorrect(String numOfProducts){
        page.waitForSelector(".product-listing");
        return page.isVisible("text="+numOfProducts+" result has been found.");
    }

    public Boolean isCorrectCategoryDisplayed(String category){
        return page.textContent(".category-name").contains(category);
    }

    public void clickCasualFilter(String filter){
        page.check("#layered_id_feature_11");
    }

    public Boolean isFilteringDoneCorrectly(){
        page.waitForSelector("text=There is 1 product.");
        return page.isVisible("text=There is 1 product.");
    }

}
