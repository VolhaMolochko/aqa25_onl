import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest {
    //    Задание 1: Добавить тест для страницы Frames
    //    Открыть iFrame
    //    Проверить, что текст внутри параграфа равен “Your content goes here.”
    @Test
    public void FrameYTest() {
        driver.get("https://the-internet.herokuapp.com/frames");

        WebElement button = driver.findElement(By.xpath("//a[.='iFrame']"));
        button.click();

        WebDriver frame = driver.switchTo().frame(0);

        Assert.assertEquals(frame.findElement(By.id("tinymce")).getText(), "Your content goes here.");
    }
}
