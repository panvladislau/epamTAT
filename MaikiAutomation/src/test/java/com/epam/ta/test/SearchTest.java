package com.epam.ta.test;

import com.epam.ta.page.CatalogPage;
import com.epam.ta.page.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;



public class SearchTest extends CommonConditions{
    @Test
    public void searchResultTest() throws InterruptedException {
        final String searchText = "Шапка";
        CatalogPage catalogPage = new MainPage(driver)
                .openPage()
                .search(searchText);

        boolean isSearchTitle = catalogPage
                .compereTitle(searchText);
        Assert.assertTrue(isSearchTitle);


        boolean isSearchedGood = catalogPage
                .compereGoodWithSearchText(searchText);
        Assert.assertTrue(isSearchedGood);
    }
}
