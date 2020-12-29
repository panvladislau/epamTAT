package com.epam.ta.page;

import com.epam.ta.service.FindContains;
import com.epam.ta.waits.CustomWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CatalogPage extends AbstractPage{
    private static final String LINK = "https://www.vsemayki.ru/popular";

    @FindBy(xpath = "//div[@class='_3Aqv13MO col-6 col-lg-4 col-xl-3']")
    private WebElement anyGood;

    @FindBy(xpath = "//div[@class='_1VRUYwRP']")
    private List<WebElement> someGoods;

    @FindBy(xpath = "//div[@class='_1RVGwfwy']")
    private WebElement likeButton;

    @FindBy(xpath = "//h1")
    private WebElement searchTitle;

    @FindBy(xpath = "//div[@class='_36O8-8MY']/a/div[@class='_1IsIhWbp']")
    private WebElement goodTitle;

    public CatalogPage(WebDriver driver) throws InterruptedException {
        super(driver);
        CustomWaits.waitForPageLoaded(driver);
    }

    @Override
    public CatalogPage openPage() {
        driver.get(LINK);
        return this;
    }

    public boolean compereTitle(String title){
        CustomWaits.waitForPageLoaded(driver);
        return FindContains.findContains(searchTitle.getText(), title);
    }

    public boolean compereGoodWithSearchText(String title){
        CustomWaits.waitForPageLoaded(driver);
        return FindContains.findContains(searchTitle.getText(), title);
    }

    public GoodPage addAnyGood(){
        CustomWaits.waitForPageLoaded(driver);
        anyGood.click();
        return new GoodPage(driver);
    }

    public CatalogPage addSomeGoodsInBasket() throws InterruptedException {
        CustomWaits.waitForPageLoaded(driver);
        for (int i = 0; i < someGoods.size(); i++) {
            someGoods.get(i).click();
            GoodPage goodPage = new GoodPage(driver);
            goodPage.addGoodInBasket();
            CatalogPage catalogPage = new CatalogPage(driver);
        }
        return this;
    }
}
