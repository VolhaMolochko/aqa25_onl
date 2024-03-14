import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsTest extends BaseTest {
    @Test
    public void hoverTest() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions actions = new Actions(driver);

        List<WebElement> targetElements = waitsService.waitForAllVisibleElementsLocatedBy(By.className("figure"));
        actions
                .moveToElement(targetElements.get(0),
                        targetElements.get(0).getSize().getWidth() / 2,
                        targetElements.get(0).getSize().getHeight() / 2)
                // .click(waitsService.waitForVisibilityLocatedBy(By.cssSelector("[href='/users/1']")))
                .click(waitsService.waitForExists(By.cssSelector("[href='/users/1']")))
                .build()
                .perform();
        Assert.assertTrue(waitsService.waitForVisibilityLocatedBy(By.xpath("//h1[text()='Not Found']")).isDisplayed());
    }

    @Test
    public void dragAndDropTest() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        Actions actions = new Actions(driver);

        WebElement source = waitsService.waitForVisibilityLocatedBy(By.id("column-a"));
        WebElement target = waitsService.waitForVisibilityLocatedBy(By.id("column-b"));

        actions
                .dragAndDrop(source, target)
                .build()
                .perform();
        Assert.assertTrue(waitsService.waitForVisibilityLocatedBy(By.xpath("//h1[text()='Not Found']")).isDisplayed());
    }
}
