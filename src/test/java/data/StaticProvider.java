package data;

import org.testng.annotations.DataProvider;

public class StaticProvider {

    @DataProvider(name = "dataForSum", parallel = true)
    public static Object[][] dataForSumTest() {
        return new Object[][]{
                {-2, -3, -5},
                {0, 0, 0},
                {2, 3, 5}
        };
    }
    @DataProvider(name = "dataForDivInt", parallel = true)
    public static Object[][] dataForDivOneTest() {
        return new Object[][]{
                {6, 2, 3},
                {2, 0, 2},
                {4, 4, 1}
        };
    }

    @DataProvider(name = "dataForDivDouble", parallel = true)
    public static Object[][] dataForDivTwoTest() {
        return new Object[][]{
                {8.8, 0, 8.8},
                {6.4, 3.2, 2},
                {4.4, 4.4, 1}
        };
    }
}
