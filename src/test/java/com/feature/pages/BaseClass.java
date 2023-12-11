package com.feature.pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.feature.utility.BrowserFactory;
import com.feature.utility.ConfigDataProvider;
import com.feature.utility.Helper;

public class BaseClass {
	public WebDriver driver;
	public ConfigDataProvider conf;
	public practicePage pp;
	ExtentReports reports;
	ExtentSparkReporter spReports;
	ExtentTest test;
	
	@BeforeSuite
	public void beforeSetup() {
		
		conf = new ConfigDataProvider();
		driver = BrowserFactory.loadBrowser(driver, conf.getBrowser(), conf.loadUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		reports = new ExtentReports();
		spReports = new ExtentSparkReporter("D:\\Work\\Work\\EK12Docs\\EC\\com.selenium-fw.2023\\Reports\\" 
				+ Helper.setDateTime() + ".html");
		
	}
	
	@BeforeClass
	public void setup() {
	
		reports.attachReporter(spReports);
		pp = PageFactory.initElements(driver, practicePage.class);
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		
		if(result.getStatus()==ITestResult.FAILURE) {
		
			test = reports.createTest("Test Failure and take screenshot");
			test.fail("Test failed --> Captured SS", MediaEntityBuilder
					.createScreenCaptureFromPath(Helper.takeaScreenshot(driver)).build());
		
		}
	}
	
	@AfterSuite
	public void afterTeardown() {
	
		reports.flush();
		BrowserFactory.quitBrowser(driver);
	}
	
}
