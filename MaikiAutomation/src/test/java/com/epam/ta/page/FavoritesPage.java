package com.epam.ta.page;

import com.epam.ta.service.FindContains;
import com.epam.ta.waits.CustomWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FavoritesPage extends AbstractPage{
    private static final String LINK = "https://www.vsemayki.ru/favorites";

    @FindBy(xpath = "//div[@class='_2x6VlO-c row']")
    private List<WebElement> elements;

    @FindBy(xpath = "//strong")
    private List<WebElement> goodNamesInFavorites;

    @FindBy(xpath = "//button[@class='_1Spv5gRh']")
    private WebElement removeButton;

    @FindBy(xpath = "//div[@class='row']/p/a")
    private WebElement pageLoadingMarker;

    public FavoritesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public FavoritesPage openPage() {
        driver.get(LINK);
        return this;
    }

    public boolean isInFavoriteList(String goodName){
        for (int i = 0; i < goodNamesInFavorites.size(); i++) {
            if(FindContains.findMatches(goodNamesInFavorites.get(i).getText() ,goodName.substring(1,goodName.length()-1))){
                return true;
            }
        }
        return false;
    }

    public FavoritesPage removeGood(){
        CustomWaits.waitForPageLoaded(driver);
        removeButton.click();
        CustomWaits.waitForElementClickable(driver, pageLoadingMarker);
        return new FavoritesPage(driver);
    }

    public int numOfEl(){
        return elements.size();
    }
}
