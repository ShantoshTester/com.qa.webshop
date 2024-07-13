package com.webshop.utils;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import com.webshop.base.DriverScript;

public class HelperUtil extends DriverScript {
	
	
	public static String captureScreen(WebDriver driver) {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenPath = System.getProperty("user.dir")+""
				+ "./reports/screenshots/screen_"+System.currentTimeMillis()+".png";
		try 
		{
			FileHandler.copy(src, new File(screenPath));
		} 
		catch (IOException e) {
			System.out.println("unable to capture the screen");
			e.printStackTrace();
		}
		return screenPath;
		
	}

}
