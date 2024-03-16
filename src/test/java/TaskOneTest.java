import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;

import java.time.Duration;


//Добавить тест для страницы Context Menu
//Правый клик по элементу
//Валидация текста на алерте
//Закрытие алерта

public class TaskOneTest extends BaseTest {

    @Test
    public void validationTextInAlert() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.id("hot-spot"))).perform();

        waitsService.showAlert();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals(alertText, "You selected a context menu");
        driver.switchTo().alert().accept();
    }
}
