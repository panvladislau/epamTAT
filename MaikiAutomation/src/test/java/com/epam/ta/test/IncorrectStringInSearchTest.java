package com.epam.ta.test;

import com.epam.ta.page.CatalogPage;
import com.epam.ta.page.MainPage;
import com.epam.ta.page.Page404;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IncorrectStringInSearchTest extends CommonConditions {
    @Test
    public void bigStringInSearchTest() throws InterruptedException {
        String string = "-1-1-1-1--1-1-1-1-1-1-1--1-1-1-1-1-1-";
        CatalogPage catalogPage = new MainPage(driver)
                .openPage()
                .search(string);
        String currentPage = driver.getCurrentUrl();
        Page404 page404 = new Page404(driver);
        Assert.assertEquals(page404.isItPage404(), true);
    }
}
