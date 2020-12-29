package com.epam.ta.page;

import com.epam.ta.service.FindContains;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page404 extends AbstractPage{
    private String page404 = "Ошибка 404";

    @FindBy(xpath = "//h4")
    private WebElement page404Massage;

    public Page404(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    public boolean isItPage404(){
        return FindContains.findContains(page404Massage.getText(), page404);
    }

}
