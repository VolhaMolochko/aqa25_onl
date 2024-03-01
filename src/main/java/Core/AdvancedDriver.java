package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AdvancedDriver {
    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        return new ChromeDriver(getChromeOptions());
    }
    public ChromeOptions getChromeOptions(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--silent");
        chromeOptions.addArguments("--start-maximized");
        //chromeOptions.addArguments("--headless"); //визуально спрятанный брайзер н оесть в памяти и там работает
        return chromeOptions;
    }
}
