import org.testng.annotations.*;

public class BaseTest {

    public static int counter = 0;
    protected Calculator calculator;

    @BeforeSuite
    public void beforeSuite() {
        calculator = new Calculator();
        counter++;
        System.out.println("BeforeSuite:..." + counter);
    }

    @BeforeTest
    public void beforeTest() {
        calculator = new Calculator();
        counter++;
        System.out.println("BeforeTest:..." + counter);
    }

    @BeforeClass
    public void beforeClass() {
        calculator = new Calculator();
        counter++;
        System.out.println("BeforeClass:..." + counter);
    }

    @BeforeMethod
    public void beforeMethod() {
        calculator = new Calculator();
        counter++;
        System.out.println("BeforeMethod:..." + counter);
    }

    @BeforeGroups
    public void beforeGroups() {
        calculator = new Calculator();
        counter++;
        System.out.println("BeforeGroups:..." + counter);
    }

    @AfterSuite
    public void afterSuite() {
        counter++;
        System.out.println("AfterSuite:..." + counter);
    }

    @AfterTest
    public void afterTest() {
        counter++;
        System.out.println("AfterTest:..." + counter);
    }

    @AfterClass
    public void afterClass() {
        counter++;
        System.out.println("AfterClass:..." + counter);
    }

    @AfterMethod
    public void afterMethod() {
        counter++;
        System.out.println("AfterMethod:..." + counter);
    }

    @AfterGroups
    public void afterGroups() {
        counter++;
        System.out.println("AfterGroups:..." + counter);
    }
}
