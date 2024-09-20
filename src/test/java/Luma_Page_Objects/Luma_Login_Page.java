package Luma_Page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Luma_Login_Page {
	// divided into 3 parts

		//1.Constructor
		public WebDriver driver;
		public Luma_Login_Page(WebDriver driver) {

			this.driver=driver; //

			PageFactory.initElements(driver, this);

		}

		//2.identify the webelements

		@FindBy(id="email")
		WebElement txtEmail;

		@FindBy(id="pass")
		WebElement txtPassword;

		@FindBy(id="send2")
		WebElement btnSignin;


		//3.Create actions

		public void setEmail(String email) {

			txtEmail.sendKeys(email);
		}

		public void setPassword(String password) {
			txtPassword.sendKeys(password);
		}

		public void clickSigninbutton() {
			btnSignin.click();
		}	

		public void clearEmail() {

			txtEmail.clear();
		}

		public void clearPassword() {
			txtPassword.clear();	
		}


}
