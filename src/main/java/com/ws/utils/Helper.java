package com.ws.utils;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.ws.base.DriverScript;

public class Helper extends DriverScript {
	
	/*
	 * this method is used to capture the screenshots
	 */
	public static String captureScreen(WebDriver driver)
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		String screenPath = "D:/WORKSPACE/BATCH28/FRAMEWORK/com.qa.webshop/reports/screenshots/screen.png";
		String screenPath = System.getProperty("user.dir")+""
				+ "./reports/screenshots/screen_"+System.currentTimeMillis()+".png";
		try 
		{
			FileHandler.copy(src, new File(screenPath));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return screenPath;
	}

}
