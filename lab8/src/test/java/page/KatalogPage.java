package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KatalogPage extends AbstractPage{
    private static final String LINK = "https://www.vsemayki.ru/popular";

    @FindBy(xpath = "//div[@class='_3Aqv13MO col-6 col-lg-4 col-xl-3']")
    private WebElement anyGood;

    @FindBy(xpath = "//div[@class='_1RVGwfwy']")
    private WebElement likeButton;

    public KatalogPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public KatalogPage openPage(String url) {
        driver.get(url);
        return this;
    }


    public KatalogPage openPage() {
        driver.get(LINK);
        return this;
    }

    public WebDriver addAnyGood(){
        WebElement searchLink = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(anyGood));
        anyGood.click();
        return this.driver;
    }
}
