package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.BasketPage;
import page.GoodPage;
import page.KatalogPage;
import page.LikePage;

public class PageObjectTest {
    public class MaikiWebDriverTest {
        private WebDriver driver;

        @BeforeMethod(alwaysRun = true)
        public void start(){
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        @Test
        public void testFavorites() throws InterruptedException {
            int expected = 1;
            KatalogPage katalogPage = new KatalogPage(driver)
                    .openPage();
            driver = katalogPage.addAnyGood();
            GoodPage goodPage = new GoodPage(driver)
                    .addGoodInLike();
            Thread.sleep(5000);
            LikePage likePage = new LikePage(driver)
                    .openPage();
            Assert.assertEquals(expected, likePage.numOfEl());
        }

        @Test
        public void testBasket() throws InterruptedException {
            int expected = 1;
            KatalogPage katalogPage = new KatalogPage(driver)
                    .openPage();
            driver = katalogPage.addAnyGood();
            GoodPage goodPage = new GoodPage(driver)
                    .addGoodInBasket();
            Thread.sleep(5000);
            //driver.get("https://www.vsemayki.ru/cart");
            BasketPage basketPage = new BasketPage(driver)
                    .openPage();
            Assert.assertEquals(expected, basketPage.numOfEl());

        }

        @AfterMethod(alwaysRun = true)
        public void end(){
            driver.quit();
            driver = null;
        }
    }
}
