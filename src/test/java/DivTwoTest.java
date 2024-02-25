import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class DivTwoTest extends BaseTest{
    @BeforeMethod
    public void beforeDivTwoMethod() {
        System.out.println("DivTwoTest started...");
    }

    @Test(description = "divide numbers", testName = "Divide two")
    public void testDivTwo() throws NumberException {
        Assert.assertEquals(calculator.div2(6.6, 3.3), 2, "something wrong");
    }



    @Test(dataProvider = "dataForDivTwo", dataProviderClass = StaticProvider.class, threadPoolSize = 3, alwaysRun = false)
    public void testDivDataProviderTwo(double y, double z, double expectedResult) throws InterruptedException, NumberException {
        Thread.sleep(new Random().nextInt(500));
        Assert.assertEquals(calculator.div2(y, z), expectedResult, "incorrect result");
    }



    @Test(description = "check divide zero for double", testName = "Check divide dy zero for double 1", enabled = false)
    public void testDivideOneByZeroTwo1() {
        Assert.assertThrows(NumberException.class, () -> {
            calculator.div2(5,1);
        });
    }

    @Test (expectedExceptions = NumberException.class, testName = "Check divide dy zero for double 2", priority = 1)
    public void testDivideOneByZeroTwo() throws NumberException {
        calculator.div2(6,0);
    }

    @Test(dataProvider = "dataForDivTwo", dataProviderClass = StaticProvider.class, threadPoolSize = 3,
            expectedExceptions = NumberException.class, testName = "Check divide dy zero for double 3", priority = 2)
    public void testDivideOneByZeroTwoWithDataProvider(double y, double z, double expectedResult) throws NumberException {
        calculator.div2(y,z);
    }

}
