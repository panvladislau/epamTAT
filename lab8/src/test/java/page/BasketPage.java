package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BasketPage extends AbstractPage {
    private static final String LINK = "https://www.vsemayki.ru/cart";

    @FindBy(xpath = "//div[@class='_3bv_rPFg row']")
    private List<WebElement> elements;

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasketPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public BasketPage openPage() {
        driver.get(LINK);
        return this;
    }

    public int numOfEl(){
        return elements.size();
    }
}
