import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class TaskFourTest extends BaseTest {
//    Добавить тест для страницы File Download
//    Скачать файл
//    Проверить наличие файла на файловой системе

    @Test
    public void FileDownloadTest() {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[contains(@href, 'puppy.png')]")).click();
        Assert.assertTrue(isFileExist("C:/Users/volha/Downloads/puppy.png"));
    }

    private boolean isFileExist(String path) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(s -> new File(path).exists());
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}