import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;


public class TaskONE {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new Core.BrowserService().getDriver();
    }

    @Test (testName = "Heating floor test")
    public void calkRehau() throws InterruptedException {
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");
        WebElement width = driver.findElement(By.id("el_f_width"));                            //ввожу размеры
        width.sendKeys("6");

        WebElement length = driver.findElement(By.id("el_f_lenght"));
        length.sendKeys("4");

        WebElement selectWebElementRoom = driver.findElement(By.id("room_type"));            //работаю с выпадающим списком
        Select selectRoom = new Select(selectWebElementRoom);

        selectRoom.selectByValue("2");

        WebElement selectWebElementHeatingType = driver.findElement(By.id("heating_type"));
        Select selectHeatingType = new Select(selectWebElementHeatingType);

        selectHeatingType.selectByValue("3");

        WebElement button = driver.findElement(By.name("button"));                               //нажимаю "Рассчитать"
        button.click();

        Thread.sleep(2000);

        WebElement resultPower = driver.findElement(By.id("floor_cable_power"));                  //отсюда и ниже проверяю значения которые посчитались
        WebElement resultSpecificPower = driver.findElement(By.id("spec_floor_cable_power"));

        Assert.assertEquals(resultPower.getAttribute("value"), "1526");
        Assert.assertEquals(resultSpecificPower.getAttribute("value"), "64");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
