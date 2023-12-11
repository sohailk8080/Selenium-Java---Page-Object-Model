package com.feature.utility;


import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {  
	
	//screenshot, alert, window, frame, scrolling, synchronization
	
	
	//Screenshot
	public static String takeaScreenshot(WebDriver driver) throws IOException{
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File ss = ts.getScreenshotAs(OutputType.FILE);
		String ssPath = "D:\\Work\\Work\\EK12Docs\\EC\\com.selenium-fw.2023\\Screenshots\\" + setDateTime() + ".png";
		FileUtils.copyFile(ss, new File(ssPath));
		
		return ssPath;
	}

	public static String setDateTime() {
		
		DateFormat customDate = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date date = new Date();
		return customDate.format(date);
	
	}
	
}
