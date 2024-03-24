import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskThreeTest extends BaseTest {
//    Добавить тест для страницы File Upload
//    Загрузить файл
//    Проверить, что имя файла на странице совпадает с именем загруженного файла

    @Test
    public void FileUploadTest() {
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement fileUploadElement = waitsService.waitForExists(By.xpath("//*[@name ='file']"));
        String pathToFile = TaskThreeTest.class.getClassLoader().getResource("Pearl.txt").getPath().substring(1);
        System.out.println(pathToFile);

        fileUploadElement.sendKeys(pathToFile);
        waitsService.waitForExists(By.id("file-submit")).submit();

        WebElement checkNameFile = waitsService.waitForExists(By.id("uploaded-files"));
        Assert.assertEquals(checkNameFile.getText(), "Pearl.txt");
    }
}


