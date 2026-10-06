package com.plug.ecommerce.listenerutility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.plug.ecommerce.genericutility.BaseClass;

public class ListImpClass implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {

		System.out.println("Suite started: " + suite.getName());
	}

	@Override
	public void onFinish(ISuite suite) {

		System.out.println("Suite finished: " + suite.getName());
	}

	@Override
	public void onTestStart(ITestResult result) {

		System.out.println(
				result.getMethod().getMethodName()
				+ " START");
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println(
				result.getMethod().getMethodName()
				+ " PASSED");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		String testName =
				result.getMethod().getMethodName();

		System.out.println(
				testName + " FAILED");

		try {

			// Get the current test class object
			BaseClass baseClass =
					(BaseClass) result.getInstance();

			// Get WebDriver from BaseClass
			WebDriver driver =
					baseClass.driver;

			// Take screenshot
			File srcFile =
					((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);

			// Create timestamp
			String timeStamp =
					new SimpleDateFormat("yyyyMMdd_HHmmss")
					.format(new Date());

			// Create screenshot folder
			File screenshotFolder =
					new File("./screenshot");

			if (!screenshotFolder.exists()) {
				screenshotFolder.mkdirs();
			}

			// Create unique screenshot name
			File destination =
					new File(
							screenshotFolder,
							testName + "_" + timeStamp + ".png");

			// Save screenshot
			FileUtils.copyFile(
					srcFile,
					destination);

			System.out.println(
					"Screenshot saved at: "
					+ destination.getAbsolutePath());

		} catch (Exception e) {

			System.out.println(
					"Unable to take screenshot");

			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		System.out.println(
				result.getMethod().getMethodName()
				+ " SKIPPED");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(
			ITestResult result) {

		System.out.println(
				result.getMethod().getMethodName()
				+ " FAILED WITHIN SUCCESS PERCENTAGE");
	}
}
