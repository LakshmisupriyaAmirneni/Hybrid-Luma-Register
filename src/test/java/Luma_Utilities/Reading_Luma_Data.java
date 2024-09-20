package Luma_Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Reading_Luma_Data {
	
	Properties pro;
	
	public Reading_Luma_Data() {
		
		File file=new File("./Configuration\\Data.Properties"); //./Configuration\\Data.Properties
		try
		{
		FileInputStream fis=new FileInputStream(file);
		
		pro=new Properties();
		
		pro.load(fis);// loading the properties file
		}
		
	catch(Exception e) {
		
		e.printStackTrace();
	}
		
	}
	
	//Registration
	
	public String getFirstName() {
		
		String FName=pro.getProperty("FirstName");
		return FName;
		
	}
	
	public String getLastName() {
		
		String LName=pro.getProperty("LastName");
		
		return LName;
	}
	
	public String getEmailAddress() {
		
		String EmailAdd=pro.getProperty("Email");
		return EmailAdd;
	}
	
	public String getPassword() {
		
		String Password=pro.getProperty("Password");
		
		return Password;
	}

	public String  getConfirmPassword() {
		
		String CPassword=pro.getProperty("ConfirmPassword");
		
		return CPassword;
	}
}