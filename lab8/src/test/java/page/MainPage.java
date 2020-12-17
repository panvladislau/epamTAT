package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

    protected MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='_1RVGwfwy']")
    private WebElement likeButton;

    @FindBy(xpath = "//div[@class='_2EEzLzSp']")
    private WebElement basketButton;

    @FindBy(xpath = "//*[text()='Каталог' and @class='_33BvM8H-']")
    private WebElement kataogLink;

    @Override
    public MainPage openPage(String url) {
        driver.get(url);
        return this;
    }
}
