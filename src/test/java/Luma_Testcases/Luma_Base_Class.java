package Luma_Testcases;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import Luma_Utilities.Reading_Luma_Data;

public class Luma_Base_Class {
	
	
	//Implement the common functionalities open application, close application, screenshots
     public Logger log;
	public static WebDriver driver;
	
	Reading_Luma_Data RLD=new Reading_Luma_Data();
	
	//Registration
		public String FName= RLD.getFirstName();
		public String LName=RLD.getLastName();
		public String EmailAdd=RLD.getEmailAddress();
		public String Password=RLD.getPassword();
		public String CPassword=RLD.getConfirmPassword();
	
	
	@BeforeClass
	@Parameters({"browser","url"})
	public void openApplication(String br,String URL) {
		
		if(br.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(br.equals("edge")) {
			driver=new EdgeDriver();
		}
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		
		log = Logger.getLogger("Hybrid_Framework_Luma");
		PropertyConfigurator.configure("Log4j.Properties");
		
	}
	//screenshots
	public String captureScreen(String tname) {
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot screenshot=((TakesScreenshot)driver);
		File source=screenshot.getScreenshotAs(OutputType.FILE);
		
		//project home directory (./)
		String destination=System.getProperty("user.dir")+"\\Screenshots\\"+tname+"_"+timestamp+".png";
		try {
			FileUtils.copyFile(source, new File(destination));
		}catch(Exception e) {
			e.getMessage();
		}
		return destination;	
	}
	@AfterClass
	public void closeApplication() {
		
		driver.close();
	}

}