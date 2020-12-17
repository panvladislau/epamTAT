package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoodPage extends AbstractPage {
    @FindBy(xpath = "//div[@class='_1RVGwfwy']")
    private WebElement likeButton;

    @FindBy(xpath = "//div[@class='_1UtpZ1Ow']/div[@class='_3pSlocOO']")
    private WebElement like;

    @FindBy(xpath = "//button[@class='_3q1PZ3XG']")
    private WebElement basket;

    public GoodPage(WebDriver driver) {
        super(driver);
    }

    public AbstractPage openPage(String url) {
        return null;
    }

    public GoodPage addGoodInLike(){
        WebElement searchLink = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(like));
        like.click();
        return this;
    }

    public GoodPage addGoodInBasket(){
        WebElement searchLink = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(basket));
        basket.click();
        return this;
    }
}
