import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowsTest extends BaseTest {

//    Задание 3: Добавить тест для страницы Windows
//    Дважды нажать на ссылку “Click here”
//    Проверить, что открыто 3 вкладки в браузере
//    Закрыть последнюю вкладку
//    Переключиться на основную вкладку
//    Проверить что осталось 2 вкладки

    @Test
    public void WindowTest() {
        driver.get("https://the-internet.herokuapp.com/windows");

        String originalWindow = driver.getWindowHandle();

        WebElement button = driver.findElement(By.linkText("Click Here"));
        button.click();
        button.click();

        Set<String> windowHandlesSet = driver.getWindowHandles();
        List<String> windowHandleList = new ArrayList<>(windowHandlesSet);

        Assert.assertTrue(driver.getWindowHandles().size() == 3);

        driver.switchTo().window(windowHandleList.get(2)).close();
        driver.switchTo().window(originalWindow);

        Assert.assertTrue(driver.getWindowHandles().size() == 2);
    }
}
