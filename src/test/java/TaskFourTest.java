import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskFourTest extends BaseTest {
//    Добавить тест для страницы File Download
//    Скачать файл
//    Проверить наличие файла на файловой системе

    @Test
    public void FileDownloadTest() {
        driver.get("https://the-internet.herokuapp.com/download");
        waitsService.waitForElementClickable(By.xpath("//a[contains(@href, 'logo.jpg')]"));
        driver.findElement(By.xpath("//a[contains(@href, 'logo.jpg')]")).click();
        assertFileExist("logo.jpg");
    }

    private void assertFileExist(String path) {
        try {
            waitsService.waitExist(path);
        } catch (TimeoutException e) {
            Assert.fail("assert message ");
        }
    }
}