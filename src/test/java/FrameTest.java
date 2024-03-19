import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {

    @Test
    public void frameTest() {
        driver.get("http://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame(0); // переключение во Frame A внутри основного документа
        driver.switchTo().frame(0); // переключение во Frame B внутри Frame A

        Assert.assertTrue(driver.findElement(By.id("tinymce")).isDisplayed());

        driver.switchTo().parentFrame(); // вернемся в Frame A
        driver.switchTo().parentFrame(); // вернемся в основной документ

        driver.switchTo().defaultContent(); // вернемся в основной документ

        Assert.assertTrue(driver.findElement(By.className("tox-editor-container")).isDisplayed(), "Элемент не появился!!!");
    }
}