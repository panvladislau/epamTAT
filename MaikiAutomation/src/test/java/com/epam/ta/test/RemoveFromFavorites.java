package com.epam.ta.test;

import com.epam.ta.page.CatalogPage;
import com.epam.ta.page.FavoritesPage;
import com.epam.ta.page.GoodPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveFromFavorites extends CommonConditions{
    @Test
    public void fromFavoritesToBasketTest() throws InterruptedException {
        int expectedNumOfEl = 0;
        GoodPage goodPage = new CatalogPage(driver)
                .openPage()
                .addAnyGood()
                .addGoodInLike();

        FavoritesPage favoritesPage = new FavoritesPage(driver)
                .openPage().removeGood();
        Assert.assertEquals(favoritesPage.numOfEl(), expectedNumOfEl);
    }
}
