package Core;
import Core.BrowserService;
import configuration.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserService {
    private WebDriver driver = null;

    public BrowserService() {
        switch (ReadProperties.browserName().toLowerCase()) {
            case "chrome":
                DriverManagerType driverManagerType = DriverManagerType.CHROME;
                WebDriverManager.getInstance(driverManagerType).clearDriverCache().setup();
                driver = new ChromeDriver(getChromeOptions());
                break;

            case "firefox":
                driverManagerType=DriverManagerType.FIREFOX;
                WebDriverManager.getInstance(driverManagerType).clearDriverCache().setup();
                driver =new FirefoxDriver(getFireFoxOptions());
                break;

            case "edge":
                break;

            default:
                System.out.println("Browser " + ReadProperties.browserName() + "in not supported");
                break;

        }

    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--silent");
        chromeOptions.addArguments("--start-maximized");
        //chromeOptions.addArguments("--incognito");
        //chromeOptions.addArguments("--headless"); //визуально спрятанный брайзер н оесть в памяти и там работает
        return chromeOptions;
    }

    private FirefoxOptions getFireFoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments();
        return firefoxOptions;
    }

    public WebDriver getDriver() {
        driver.manage().window().maximize(); //разворачивает браузер
        driver.manage().deleteAllCookies();  //удаляет куки

        return driver;
    }
}