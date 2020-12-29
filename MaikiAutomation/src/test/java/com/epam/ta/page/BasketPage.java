package com.epam.ta.page;

import com.epam.ta.service.FindContains;
import com.epam.ta.waits.CustomWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BasketPage extends AbstractPage {
    private static final String LINK = "https://www.vsemayki.ru/cart";

    @FindBy(xpath = "//div[@class='_3bv_rPFg row']")
    private List<WebElement> elements;

    @FindBy(xpath = "//a[@class='_1Y__Rvje']")
    private List<WebElement> goodNamesInBasket;

    @FindBy(xpath = "//div[@class='_27skRmL- col-12 col-sm-3 col-md-3 col-lg-4']/div/div/span/div[@class='price--1I8Le price--discount--1PZ2Z']/span")
    private List<WebElement> pricesList;

    @FindBy(xpath = "//div[@class='_1b7dicJp']/div/div[@class='_3asVMfqj']/div/span")
    private WebElement sitePrice;

    @FindBy(xpath = "//span[@title='Удалить товар']")
    private WebElement removeGoodFromBasket;

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasketPage openPage() {
        driver.get(LINK);
        return this;
    }

    public long getCurrentPrice(){
        long price = 0;
        for (int i = 0; i < pricesList.size(); i++) {
            price += Long.parseLong(pricesList.get(i).getText());
        }
        return price;
    }

    public boolean isInBasketList(String goodName){
        for (int i = 0; i < goodNamesInBasket.size(); i++) {
            if(FindContains.findMatches(goodNamesInBasket.get(i).getText() ,goodName.substring(1,goodName.length()-1))){
                return true;
            }
        }
        return false;
    }

    public BasketPage removeGood(){
        CustomWaits.waitForPageLoaded(driver);
        removeGoodFromBasket.click();
        CustomWaits.waitForPageLoaded(driver);
        return new BasketPage(driver);
    }

    public boolean isPriceCorrect(long currentPrice){
        return currentPrice == Long.getLong(sitePrice.getText()) ? true : false;
    }

    public int numOfEl(){
        return elements.size();
    }
}
