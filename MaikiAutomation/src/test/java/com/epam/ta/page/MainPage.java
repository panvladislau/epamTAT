package com.epam.ta.page;

import com.epam.ta.model.User;
import com.epam.ta.waits.CustomWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage
{
	private final String BASE_URL = "https://www.vsemayki.ru/";

	@FindBy(xpath = "//div[@class='_1RVGwfwy']")
	private WebElement favoritesButton;

	@FindBy(xpath = "//div[@class='_2EEzLzSp']")
	private WebElement basketButton;

	@FindBy(xpath = "//*[text()='Каталог' and @class='_33BvM8H-']")
	private WebElement catalogLink;

	@FindBy(xpath = "//div[@class='_2zWBij79']/child::div[@class='H23xa383']")
	private WebElement registrationButton;

	@FindBy(xpath = "//div[@class='_2swQcbqG']")
	private WebElement searchButton;

	@FindBy(xpath = "//input[@placeholder='Поиск по 110 000 дизайнов']")
	private WebElement searchFrame;

	@FindBy(xpath = "//input[@name='login']")
	private WebElement usernameField;

	@FindBy(xpath = "//input[@name='pass']")
	private WebElement passwordField;

	@FindBy(xpath = "//div[@class='rc-anchor rc-anchor-normal rc-anchor-light']")
	private WebElement checkBox;

	@FindBy(xpath = "//*[text()='Войти' and @class='btn btn-primary']")
	private WebElement enterRegistrationButton;

	private final By linkLoggedInUserLocator = By.xpath("//a[@class='link--Wps-U link--primary--1aGLk']");

	public MainPage(WebDriver driver)
	{
		super(driver);
	}

	@Override
	public MainPage openPage()
	{
		driver.navigate().to(BASE_URL);
		return this;
	}

	public String getLoggedInUserName()
	{
		WebElement linkLoggedInUser = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.presenceOfElementLocated(linkLoggedInUserLocator));
		return linkLoggedInUser.getAttribute("title");
	}

	public CatalogPage search(String searchLine) throws InterruptedException {
		searchButton.click();
		searchFrame.sendKeys(searchLine, Keys.ENTER);
		CustomWaits.waitForPageLoaded(driver);
		CustomWaits.waitForElementLocated(driver,"//h1");
		return new CatalogPage(driver);
	}

	public MainPage registration(User user) throws InterruptedException {
		registrationButton.click();
		this.sendLogin(user);
		this.sendPassword(user);
		enterRegistrationButton.click();
		return new MainPage(driver);
	}

	public MainPage sendLogin(User user){
		usernameField.sendKeys(user.getUsername());
		logger.info("login send");
		CustomWaits.waitForPageLoaded(driver);
		CustomWaits.waitForElementClickable(driver,passwordField);
		return this;
	}

	public MainPage sendPassword(User user){
		passwordField.sendKeys(user.getPassword());
		logger.info("password send");
		CustomWaits.waitForPageLoaded(driver);
		return new MainPage(driver);
	}
}
