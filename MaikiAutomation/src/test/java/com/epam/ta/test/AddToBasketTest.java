package com.epam.ta.test;

import com.epam.ta.page.BasketPage;
import com.epam.ta.page.CatalogPage;
import com.epam.ta.page.FavoritesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToBasketTest extends CommonConditions{
    @Test
    public void addToBasket() throws InterruptedException {
        CatalogPage catalogPage = new CatalogPage(driver)
                .openPage();

        String goodName = catalogPage.addAnyGood()
                .addGoodInBasket().getGoodName();

        boolean existenceOfGoodInBasket = new BasketPage(driver)
                .openPage().isInBasketList(goodName);

        Assert.assertEquals(existenceOfGoodInBasket, true);
    }
}
