import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TaskTwo {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new Core.BrowserService().getDriver();
    }

    @Test(testName = "Laminat calc test")
    public void laminatCalcTest() throws InterruptedException {
        driver.get("https://calc.by/building-calculators/laminate.html");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement roomLength = driver.findElement(By.id("ln_room_id"));

        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", roomLength);
        roomLength.clear();
        roomLength.sendKeys("500");

        WebElement roomWidth = driver.findElement(By.id("wd_room_id"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", roomWidth);
        roomWidth.clear();
        roomWidth.sendKeys("400");

        WebElement lengthLaminatePanel = driver.findElement(By.id("ln_lam_id"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", lengthLaminatePanel);
        lengthLaminatePanel.clear();
        lengthLaminatePanel.sendKeys("2000");

        WebElement widthLaminatePanel = driver.findElement(By.id("wd_lam_id"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", widthLaminatePanel);
        widthLaminatePanel.clear();
        widthLaminatePanel.sendKeys("200");

        WebElement selectWebElementLayingMethod = driver.findElement(By.id("laying_method_laminate"));    //выпадающий список
        Select selectLayingMethod = new Select(selectWebElementLayingMethod);

        selectLayingMethod.selectByValue("0");
        Thread.sleep(1000);


        WebElement radio = driver.findElement(By.id("direction-laminate-id1"));     //радиоботом
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", radio);
        radio.click();
        Thread.sleep(1000);

        WebElement button = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div[3]/article/section/div[2]/div[2]/div[2]"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", button);
        button.click();

        Thread.sleep(3000);

        WebElement numberOfBoards = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div[3]/article/section/div[2]/div[3]/div[2]/div[1]/span"));
        Assert.assertEquals(numberOfBoards.getText(), "51");

        WebElement numberOfPackages = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div[3]/article/section/div[2]/div[3]/div[2]/div[2]/span"));
        Assert.assertEquals(numberOfPackages.getText(), "7");

        Thread.sleep(2000);

    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}
