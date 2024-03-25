package pages;

import baseEntities.BasePage;
import configuration.ReadProperties;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private final static String pagePath = "";

    // Описываю элементы на странице логина
    private final By usernameInputLocator = By.id("user-name");  //поле ввода юзернейма
    private final By passwordInputLocator = By.name("password"); //поле ввода пароля
    private final By loginButtonLocator = By.id("login-button");  //кнопка логина


    // Блок иницализации
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return usernameInputLocator;
    }

    @Override
    protected String getPagePath() {
        return pagePath;
    }

    // Методы
    public WebElement getUserNameInput() {
        return waitsService.waitForVisibilityLocatedBy(usernameInputLocator);
    }

    public WebElement getPasswordInput() {
        return waitsService.waitForVisibilityLocatedBy(passwordInputLocator);
    }

    public WebElement getLoginButton() {
        return waitsService.waitForVisibilityLocatedBy(loginButtonLocator);
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }

    public void login(String username, String password) {
        getUserNameInput().sendKeys(username);
        getPasswordInput().sendKeys(password);
        clickLoginButton();
    }
}