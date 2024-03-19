import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTest {

//    Задание 2: Добавить тест для страницы Alerts
//    Открыть Prompt Alert
//    Ввести текст и нажать Accept кнопку
//    Проверить, что введенный ранее текст отображается на странице в секции Result

    @Test
    public void PromtAlertTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[. = 'Click for JS Prompt']")).click();

        waitsService.showAlert();

        Alert alert = driver.switchTo().alert();

        alert.sendKeys("Plov");
        alert.accept();

        WebElement checkText = waitsService.waitForExists(By.id("result"));
        Assert.assertEquals(checkText.getText(), "You entered: Plov");
    }
}