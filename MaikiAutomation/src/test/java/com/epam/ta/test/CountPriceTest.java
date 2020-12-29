package com.epam.ta.test;

import com.epam.ta.page.BasketPage;
import com.epam.ta.page.CatalogPage;
import com.epam.ta.page.GoodPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CountPriceTest extends CommonConditions{
    @Test
    public void countPrice() throws InterruptedException {
        CatalogPage catalogPage = new CatalogPage(driver).openPage()
                .addSomeGoodsInBasket();

        long currentPrice = new BasketPage(driver).openPage()
                .getCurrentPrice();

        BasketPage basketPage = new BasketPage(driver);

        boolean result = basketPage.isPriceCorrect(currentPrice);
        Assert.assertEquals(result,true);
    }
}
