package utils;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.github.dockerjava.transport.DockerHttpClient.Request.Method;

import base.baseTest;
//When a test fails, a screenshot is taken and saved in the "screenshots" folder with the test method's name as the filename
public class SuitListener implements ITestListener,IAnnotationTransformer {
	
	public void onTestFailure (ITestResult result) {
		String filename = System.getProperty("user.dir")+File.separator+"screenshots"+File.separator+ result.getMethod().getMethodName();
		
		File f1 = ((TakesScreenshot)baseTest.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(f1, new File (filename + ".png"));
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
 public void transform (ITestAnnotation annotation , Class testClass, Constructor testConstructor, Method testMethod) {
	 annotation.setRetryAnalyzer(RetryAnalyzer.class);
 }
}
//IAnnotationTransformer, you can modify the test annotations at runtime before TestNG executes the test methods