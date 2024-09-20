package Luma_Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import Luma_Page_Objects.Luma_Login_Page;
import Luma_Utilities.XLUtils;

public class TC_02_Luma_Login extends Luma_Base_Class{
	
	  @Test(dataProvider="TestData")
		public void loginTest(String Email, String Password) throws InterruptedException {
		Luma_Login_Page ll=new Luma_Login_Page(driver);
		
		       ll.setEmail(Email);
		       log.info("Login Email Address Entered");
		       Thread.sleep(3000);
		       ll.setPassword(Password);
		       log.info("Login Password Entered");
		       Thread.sleep(3000);
		       ll.clickSigninbutton();
		       log.info("Login Sign button Clicked");
		   
		       ll.clearEmail();
		       log.info("Login Email is Cleared");
		      
		       ll.clearPassword();
		       log.info("Loin Password is Cleared");
		    
		     /*  String Act_tittle= driver.getTitle();
		       String Exp_tittle="My Account";
		       
		       if(Act_tittle.equals(Exp_tittle)) {
		    	   Assert.assertTrue(true);
		    	   System.out.println("Testcase is Pass");
		       }
		       else {
		    	   driver.navigate().refresh();
		    	   System.out.println("Testcase is Fail");
		    	   Assert.assertTrue(false);
		      } */
		  
		}
	    
	    @DataProvider(name="TestData")
	    String [][] getData() throws IOException{
			
	    	String path="C:\\Users\\DELL\\eclipse-workspace\\Hybrid_Framework_Luma\\src\\test\\java\\Luma_Testdata\\TestData.xlsx";
	    	
	    	//identify the row count
	    	int rownum=XLUtils.getRowCount(path, "Sheet1");
	    	
	    	//identify the col count
	    	
	    	int colcount=XLUtils.getCellcount(path, "Sheet1", 1);
	    	
	    	String logindata[][]=new String[rownum][colcount];
	    	
	    	for(int i=1; i<=rownum; i++) { // it will represents rows
	    		
	    		for(int j=0; j<colcount; j++) { // it will respresnts columns
	    			
	    			logindata[i-1][j]=XLUtils.getcelldata(path, "Sheet1", i, j);	
	    			
	    		}
	    		
	    	}
	    	
			return logindata;
	    }

}     

