import core.BrowsersService;
import core.WaitsService;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
@Listeners(Listener.class)

public class BaseTest {
    protected WebDriver driver;
    protected WaitsService waitsService;

    @BeforeMethod
    public void setup() {
        driver = new BrowsersService().getDriver();
        waitsService = new WaitsService(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}