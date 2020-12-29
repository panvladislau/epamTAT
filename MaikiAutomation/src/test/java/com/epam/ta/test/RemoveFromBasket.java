package com.epam.ta.test;

import com.epam.ta.page.BasketPage;
import com.epam.ta.page.CatalogPage;
import com.epam.ta.page.GoodPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveFromBasket extends CommonConditions {
    @Test
    public void fromFavoritesToBasketTest() throws InterruptedException {
        int expectedNumOfEl = 0;
        GoodPage goodPage = new CatalogPage(driver)
                .openPage()
                .addAnyGood()
                .addGoodInBasket();
        BasketPage basketPage = new BasketPage(driver)
                .openPage().removeGood();
        Assert.assertEquals(basketPage.numOfEl(), expectedNumOfEl);
    }
}
