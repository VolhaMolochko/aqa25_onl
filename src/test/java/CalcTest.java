import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class CalcTest extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("CalcTest started...");
    }

    @Test
    public void testSum() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "incorrect summ");
        counter++;
    }

    @Test(enabled = false)
    public void testSum1() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "incorrect summ");
        counter++;
    }

    @Test(description = "Test with description")
    public void testDescription() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "incorrect summ");
        counter++;
    }

    @Test(testName = "Rename test")
    public void testName() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "incorrect summ");
        counter++;
    }

//    @Test(timeOut = 1000)
//    public void testTimeOut() throws InterruptedException {
//        Thread.sleep(1000);
//    }
    @Test(invocationCount = 3, threadPoolSize = 3)
    //сколько раз выполнится тест, threadPoolSize это количество параллельных потоков

    public void invocationCountTest() {
        System.out.println(counter++);
    }

    @Test(dataProvider = "dataForSum", dataProviderClass = StaticProvider.class, threadPoolSize = 3)
    //последовательно либо параллельно при помощи threadPoolSize
    public void testDataProvider(int a, int b, int expectedResult) throws InterruptedException {
        Thread.sleep(new Random().nextInt(500));
        Assert.assertEquals(calculator.sum(a, b), expectedResult, "incorrect summ");
        counter++;
    }

//    @Test(description = "Test with description foe div1")
//    public void testDescriptionForDiv1() {
//        Assert.assertEquals(calculator.div1(6, 3), 5, "incorrect summ");
//        counter++;
//    }
}
