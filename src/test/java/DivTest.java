import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class DivTest extends BaseTest {
    @BeforeMethod
    public void beforeDivOneMethod() {
        System.out.println("DivOneTest started...");
    }

    @Test(description = "divide numbers", testName = "Divide int...")
    public void testIntDiv() {
        Assert.assertEquals(calculator.div(6, 3), 2, "something wrong");
    }

    @Test(description = "divide numbers", testName = "Divide double...")
    public void testDoubleDiv() {
        Assert.assertEquals(calculator.div(8.4, 8.4), 1, "something wrong");
    }

    @Test(testName = "Div int by 0 ...")
    public void testIntByZero() {
        Assert.assertEquals(Double.POSITIVE_INFINITY, calculator.div(5, 0), 0);
    }

    @Test(testName = "Div double by 0 ...")
    public void testDoubleByZero() {
        Assert.assertEquals(Double.POSITIVE_INFINITY, calculator.div(8.7, 0), 0.0001);
    }

    @Test
    public void testDivInfinity() {
        Assert.assertEquals(Double.POSITIVE_INFINITY, calculator.div(Double.POSITIVE_INFINITY, 9.0), 0.0001);
    }

    @Test
    public void testDivNaN() {
        Assert.assertEquals(Double.NaN, calculator.div(Double.NaN, 4.0), 0.0001);
    }

        @Test(dataProvider = "dataForDivInt", dataProviderClass = StaticProvider.class, threadPoolSize = 3)
    public void testDivDataProviderNumber(int c, int d, int expectedResult) throws InterruptedException {
        Thread.sleep(new Random().nextInt(500));
        Assert.assertEquals(calculator.div(c, d), expectedResult, "incorrect result");
    }

    @Test(dataProvider = "dataForDivInt", dataProviderClass = StaticProvider.class, threadPoolSize = 3)
    public void testDivDataProviderInt(int c, int d, int expectedResult) throws InterruptedException {
        Thread.sleep(new Random().nextInt(500));
        Assert.assertEquals(Double.POSITIVE_INFINITY, calculator.div(c,d), expectedResult, "incorrect result");
    }

    @Test(dataProvider = "dataForDivDouble", dataProviderClass = StaticProvider.class, threadPoolSize = 3)
    public void testDivDataProviderDouble(double c, double d, double expectedResult) throws InterruptedException {
        Thread.sleep(new Random().nextInt(500));
        Assert.assertEquals(Double.POSITIVE_INFINITY, calculator.div(c,d), expectedResult, "incorrect result");
    }

}
