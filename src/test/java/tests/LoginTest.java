package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.InventoryPage;
import pages.LoginPage;


public class LoginTest extends BaseTest {

    @Test
    public void successfulLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ReadProperties.username(), ReadProperties.password());

     //   InventoryPage inventoryPage = new InventoryPage(driver);
     //   inventoryPage.topMenuPage.getTopPanel();

      //  Assert.assertTrue(dashboardPage.isPageOpened());
    }

    @Test
    public void successfulLoginTest1() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ReadProperties.username(), ReadProperties.password());

//        driver.get("https://aqa2504.testrail.io/index.php?/projects/overview/2");
//
//        DashboardPage dashboardPage = new DashboardPage(driver, true);
//        Assert.assertTrue(dashboardPage.isPageOpened());
    }
}
