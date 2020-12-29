package com.epam.ta.page;

import com.epam.ta.waits.CustomWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoodPage extends AbstractPage {
    @FindBy(xpath = "//div[@class='_1RVGwfwy']")
    private WebElement likeButton;

    @FindBy(xpath = "//div[@class='_1UtpZ1Ow']/div[@class='_3pSlocOO']")
    private WebElement like;

    @FindBy(xpath = "//button[@class='_3q1PZ3XG']")
    private WebElement basket;

    @FindBy(xpath = "//span[@class='product__info-name']")
    private WebElement goodName;

    @FindBy(xpath = "//div[@class='_497wrMS8']/li")
    private WebElement sizeButton;

    public GoodPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractPage openPage() {
        return null;
    }

    public GoodPage addGoodInLike(){
        WebElement searchLink = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(like));
        like.click();
        return this;
    }

    public String getGoodName(){
        return goodName.getText();
    }

    public GoodPage addGoodInBasket(){
        WebElement searchLink = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(basket));
        sizeButton.click();
        basket.click();
        CustomWaits.waitForPageLoaded(driver);
        return this;
    }
}
