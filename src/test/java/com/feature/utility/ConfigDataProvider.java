package com.feature.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	public Properties prop;
	public ConfigDataProvider(){
		try {
			FileInputStream fis = new FileInputStream("D:\\Work\\Work\\EK12Docs\\EC\\com.selenium-fw.2023\\Config\\config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String loadUrl() {
		return prop.getProperty("BaseUrl");
	}
	
	public String getBrowser() {
		return prop.getProperty("Browser");
	}
	
	

}
