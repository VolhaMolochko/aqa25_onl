import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class TaskThreeTest  extends BaseTest {
//    Добавить тест для страницы File Upload
//    Загрузить файл
//    Проверить, что имя файла на странице совпадает с именем загруженного файла

    @Test
    public void FileUploadTest(){
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement fileUploadElement = waitsService.waitForExists(By.xpath("//*[@name ='file']"));
        String wayToFile = TaskThreeTest.class.getClassLoader().getResource( "Pearl.txt").getPath();

        fileUploadElement.sendKeys(wayToFile);
        waitsService.waitForExists(By.id("file-submit")).submit();

        WebElement checkNameFile = waitsService.waitForExists(By.id("uploaded-files"));
        Assert.assertEquals(checkNameFile.getText(),"Pearl.txt" );
    }
}
