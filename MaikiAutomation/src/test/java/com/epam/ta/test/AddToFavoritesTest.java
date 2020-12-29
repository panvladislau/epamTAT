package com.epam.ta.test;

import com.epam.ta.page.CatalogPage;
import com.epam.ta.page.FavoritesPage;
import com.epam.ta.page.GoodPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddToFavoritesTest extends CommonConditions{
    @Test
    public void addToFavorites() throws InterruptedException {
        CatalogPage catalogPage = new CatalogPage(driver)
                .openPage();

        String goodName = catalogPage.addAnyGood()
                                        .addGoodInLike().getGoodName();

        boolean existenceOfGoodInFavorites = new FavoritesPage(driver)
                .openPage().isInFavoriteList(goodName);

        Assert.assertEquals(existenceOfGoodInFavorites, true);
    }
}
