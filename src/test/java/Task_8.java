import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class Task_8 {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new BrowsersService().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void login() {
        driver.get(ReadProperties.getUrl());
        driver.findElement(By.id("user-name")).sendKeys(ReadProperties.username());
        driver.findElement(By.name("password")).sendKeys(ReadProperties.password());
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.xpath("//a/parent::div")).isDisplayed();
        driver.findElement(By.xpath("//*[@id='item_5_title_link']/div")).click();

        driver.findElement(By.xpath("//button[contains(@name,'labs-fleece')]")).click();
        driver.findElement(By.className("shopping_cart_link")).click();

        WebElement choosenJacket = driver.findElement(By.xpath("//*[@id='item_5_title_link']/div"));
        WebElement cost = driver.findElement(By.cssSelector(".inventory_item_price"));
        Assert.assertEquals(choosenJacket.getText(), "Sauce Labs Fleece Jacket");
        Assert.assertEquals(cost.getText(), "$49.99");

        driver.findElement(By.cssSelector("#checkout")).click();

        WebElement fillFirstName = driver.findElement(By.cssSelector("[name|=firstName]"));
        fillFirstName.click();
        fillFirstName.sendKeys("Malazhauskaya");

        WebElement fillLastName = driver.findElement(By.cssSelector("[id^=la]"));
        fillLastName.click();
        fillLastName.sendKeys("Volha");

        WebElement fillZipCode = driver.findElement(By.xpath("//input[contains(@placeholder, 'Zip')]"));
        fillZipCode.click();
        fillZipCode.sendKeys("246006");

        Assert.assertTrue( driver.findElement(By.tagName("footer")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("ul.social")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(".footer_copy")).isDisplayed());
        Assert.assertTrue( driver.findElement(By.xpath("//*[@data-test='cancel' and @name='cancel']")).isDisplayed());
        driver.findElement(By.xpath("//*[@data-test='continue' or @name='continue']")).click();

        Assert.assertTrue(driver.findElement(By.linkText("Sauce Labs Fleece Jacket")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.partialLinkText("Fleece Jacket")).isDisplayed());
        driver.findElement(By.xpath("//li[@class='social_facebook']/preceding::li")).isDisplayed();    //twitter

        WebElement finalTotal = driver.findElement(By.xpath("//div/descendant::div[@class='summary_info_label summary_total_label']"));
        Assert.assertEquals(finalTotal.getText(), "Total: $53.99");

        WebElement tax = driver.findElement(By.cssSelector("[class='summary_tax_label']"));
        Assert.assertEquals(tax.getText(), "Tax: $4.00");

        Assert.assertTrue(driver.findElement(By.xpath("//li/ancestor::footer")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='social_facebook']/preceding::li")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("[class~='social_linkedin']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("[class$='facebook']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("[class*='cart_footer']")).isDisplayed());
        driver.findElement(By.id("finish")).click();
    }
}
