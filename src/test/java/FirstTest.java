import Core.AdvancedDriver;
import Core.BrowserService;
import Core.SimpleDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FirstTest {
    @Test
    public void simpleDriverTest() {
        SimpleDriver simpleDriver = new SimpleDriver();
        WebDriver driver = simpleDriver.getDriver();

        driver.get("http://google.com");

        driver.quit();
    }

    @Test
    public void advancedDriverTest()  {
        AdvancedDriver advancedDriver = new AdvancedDriver();
        WebDriver driver = advancedDriver.getDriver();

        driver.get("http://google.com");

        driver.quit();
    }

    @Test
    public void browserServiceTest()  {
        BrowserService browserServices = new BrowserService();
        WebDriver driver = browserServices.getDriver();

        driver.get("http://google.com");

        driver.quit();
    }
}
