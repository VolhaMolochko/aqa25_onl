import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class DivOneTest extends BaseTest {
    @BeforeMethod
    public void beforeDivOneMethod() {
        System.out.println("DivOneTest started...");
    }

    @Test(description = "divide numbers", testName = "Divide one")
    public void testDiv() throws NumberException {
        Assert.assertEquals(calculator.div1(6, 3), 2, "something wrong");
    }

    ;

    @Test(dataProvider = "dataForDivOne", dataProviderClass = StaticProvider.class, threadPoolSize = 3)
    public void testDivDataProvider(int c, int d, int expectedResult) throws InterruptedException, NumberException {
        Thread.sleep(new Random().nextInt(500));
        Assert.assertEquals(calculator.div1(c, d), expectedResult, "incorrect result");
    }

    ;

    @Test(description = "check divide zero", testName = "Check divide dy zero", enabled = false)
    public void testDivideOneByZero() throws NumberException {
        Assert.assertThrows(NumberException.class, () -> {
            calculator.div1(5,1);
        });
    };

    @Test (expectedExceptions = NumberException.class, testName = "Check divide dy zero", priority = 1)
    public void testDivideOneByZeroOne() throws NumberException {
        calculator.div1(6,0);
    }

}

