import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskTwoTest extends BaseTest {

//    Задание 2: Добавить тест для страницы Dynamic Controls
//    Нажать на кнопку Remove около чекбокса
//    Дождаться надписи “It’s gone”
//    Проверить, что чекбокса нет
//    Найти инпут
//    Проверить, что он disabled
//    Нажать на кнопку
//    Дождаться надписи “It's enabled!”
//    Проверить, что инпут enabled

    @Test
    public void DynamicControlsTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        Actions actions = new Actions(driver);

        WebElement removeButton = waitsService.waitForElementClickable(By.xpath("//*[@onclick='swapCheckbox()']"));
        WebElement checkBox = waitsService.waitForElementClickable(By.xpath("//*[@label='blah']"));
        removeButton.click();

        WebElement newMessage = waitsService.waitForVisibilityLocatedBy(By.id("message"));
        Assert.assertTrue(newMessage.isDisplayed());

        Assert.assertTrue(waitsService.waitForElementInvisible(checkBox));

        WebElement input = waitsService.waitForVisibilityLocatedBy(By.xpath("//form/input"));
        Assert.assertFalse(input.isEnabled());

        WebElement enableButton = waitsService.waitForElementClickable(By.xpath("//*[@onclick='swapInput()']"));
        enableButton.click();

        WebElement newMessageForEnadled = waitsService.waitForVisibilityLocatedBy(By.id("message"));
        Assert.assertTrue(newMessageForEnadled.isDisplayed());

        Assert.assertTrue(input.isEnabled());
    }
}

