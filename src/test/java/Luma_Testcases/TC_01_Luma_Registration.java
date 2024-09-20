package Luma_Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Luma_Page_Objects.Luma_Registration;


public class TC_01_Luma_Registration extends Luma_Base_Class{
	//public Luma_Registration lr;

	@Test
	public void LumaRegistration(){
		
		Luma_Registration lr=new Luma_Registration(driver);
 
		
	/*	lr.clickCreateAnAccountLink();
		lr.setFirstName(null);
		lr.setLastName(null);
		lr.setEmailAddress(null);
		lr.setPassword(null);
		lr.setConfirmPassword(null);
		lr.clickCreateAnAccountbtn(); */
		
		lr.clickCreateAnAccountLink();
		log.info("Create an account clicking activity is completed");
		lr.setFirstName(FName);
		log.info("FirstName entered successfully");
		lr.setLastName(LName);
		log.info("LastName Entered successfully");	
		lr.setEmailAddress(EmailAdd);
		log.info("Email address entered successfully");
		lr.setPassword(Password);
		log.info("Password entered successfully");		
		lr.setConfirmPassword(CPassword);
		log.info("Confirm Password entered successfully");
		lr.clickCreateAnAccountbtn();
		log.info("Create an account button clicked successfully");
		
		//Hard assertion
				String Act_title= driver.getTitle();
				String Exp_tittle="My Account";
				
				if(Act_title.equals(Exp_tittle)) {
					
					Assert.assertTrue(true);
					System.out.println("Test case is pass");
				}
				else {
				     
					System.out.println("Test case failed");
					Assert.assertTrue(false);
					
				}
				

	}
}
