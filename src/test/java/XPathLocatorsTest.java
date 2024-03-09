import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class XPathLocatorsTest {
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
    public void xpathLocatorsTest_1() {
        driver.get("file: C:/Users/volha/IdeaProjects/aqa25_onl/src/main/resources/index.html");

        driver.findElement(By.xpath("//*"));

        //tagName
        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.tagName("//h1")).isDisplayed());

        //Аналог родительского div и на один уровень ниже р1
        Assert.assertTrue(driver.findElement(By.xpath("//form/h4")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("form>h4")).isDisplayed());

        //input на любом уровне
        // Assert.assertTrue(driver.findElement(By.xpath("//p[starts-with(@title, 'Hell')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("from input")).isDisplayed());

        //поиск элемента с тегом div или любым тегом, у которого есть Id
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id]")).isDisplayed());

        //Поиск элемента у которого есть элемент Id со значением top-logo
        Assert.assertTrue(driver.findElement(By.id("cc2")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("#cc2")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id =cc2]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class = 'noSel']")).isDisplayed());

        //есть метод со значением и атрибут таргет со значением
        Assert.assertTrue(driver.findElement(By.xpath("//*[@mehtod=''post' and @target='_blank']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@mehtod=''post' or @target='_blank']")).isDisplayed());

        //поиск элемента у которого текстовое значение содержит равно
        Assert.assertTrue(driver.findElement(By.xpath("//h4[text() = 'Subscribe to my newsletter:']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//h4[. = 'Subscribe to my newsletter:']")).isDisplayed());


        //поиск элемента у которого значение атрибута начинается с
        Assert.assertTrue(driver.findElement(By.xpath("//p[starts-with(@title, 'Hell')]")).isDisplayed());
        //поиск элемента у которого значение атрибута содержить подстроку
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(@title, 'beaut')]")).isDisplayed());
        //Поиск элемента по индексу
        Assert.assertTrue(driver.findElement(By.xpath("//ul/li[3]")).isDisplayed());

    }

    @Test
    public void axesXPathLocatorsTest_1() {

        //поиск родителя с тегом h1
        Assert.assertTrue(driver.findElement(By.A("//h1")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.tagName("//h1")).isDisplayed());
    }

}