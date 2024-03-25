package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;

public class InventoryPage extends BasePage {
    private final static String pagePath = "inventory.html";

    //локаторы и элементы страницы
    private final By headerOneLocator = By.className("app_logo");
    private final By cartButtonLocator = By.className("shopping_cart_link");
    private final By burgerMenuLocator = By.id("react-burger-menu-btn");
    private final By itemFleeceLocator = By.xpath("//button[contains(@name,'labs-fleece')]");

    @Override
    protected By getPageIdentifier() {
        return itemFleeceLocator;
    }

    @Override
    protected String getPagePath() {
        return pagePath;
    }
}
