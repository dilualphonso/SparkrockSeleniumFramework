package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

//Since you have set retryCount to 1, the test will be retried only once if it fails. If you want more retries, 
//you can adjust this value
public class RetryAnalyzer implements IRetryAnalyzer{
	int count =0;
	int retryCount = 1;

	@Override
	public boolean retry(ITestResult result) {
		
		// TODO Auto-generated method stub
		while (count <retryCount) {
			count++;
			return true;
		}
		return false;
		
	}

}

//IRetryAnalyzer is an interface in TestNG that allows you to define a custom retry logic for failed test cases