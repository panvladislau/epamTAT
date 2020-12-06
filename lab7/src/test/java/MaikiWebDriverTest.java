import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MaikiWebDriverTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void start(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testChangeCityFromList() throws InterruptedException {
        driver.get("https://www.vsemayki.ru/");
        WebElement searchLink = getWebElementUntilClickable(By.xpath("//*[text()='Каталог' and @class='_33BvM8H-']"));
        searchLink.click();
        searchLink = getWebElementUntilClickable(By.linkText("Головные уборы"));
        searchLink.click();
        searchLink = getWebElementUntilClickable(By.linkText("Шапки"));
        searchLink.click();
        searchLink = getWebElementUntilClickable(By.linkText("Шапка 3D"));
        searchLink.click();
        searchLink = getWebElementUntilClickable(By.xpath("//*[@class='_36O8-8MY']"));
        searchLink.click();
        searchLink = getWebElementUntilClickable(By.xpath("//*[@class='_16SQsX8u']"));
        Assert.assertEquals("Шапка 3D", searchLink.getText().substring(0,8));
    }

    @AfterMethod(alwaysRun = true)
    public void end(){
        driver.quit();
        driver = null;
    }

    private WebElement getWebElementUntilClickable(By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(by));
    }
}
