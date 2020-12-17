package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class LikePage extends AbstractPage{
    private static final String LINK = "https://www.vsemayki.ru/favorites";

    @FindBy(xpath = "//div[@class='_2x6VlO-c row']")
    private List<WebElement> elements;

    public LikePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LikePage openPage(String url) {
        driver.get(url);
        return this;
    }

    public LikePage openPage() {
        driver.get(LINK);
        return this;
    }

    public int numOfEl(){
        return elements.size();
    }
}
