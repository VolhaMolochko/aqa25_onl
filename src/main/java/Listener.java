import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.event.ItemEvent;


public class Listener implements ITestListener {

    public void onTestFailure(ITestResult result) {
        System.out.println("Make a screenshort...");

    }
}
