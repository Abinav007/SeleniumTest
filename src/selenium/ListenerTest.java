package selenium;

import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenerTest implements ITestListener {
	public void onTestFailure(ITestResult result) {
		System.out.println("Test is failed , Release Date is different from IMDB and Wikipedia");
	}
}
