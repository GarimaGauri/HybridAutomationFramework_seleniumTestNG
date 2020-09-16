package Icicibillingportal.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Icicibillingportal.qa.base.Utils;

public class EnterOTP extends Utils{
	
	private String pageHeading = "AXIS SIMULATOR";
	private String Lable = "Please enter the Otp";

	@FindBy(xpath="//input[@id='password']")
	WebElement Password;
	
	@FindBy(xpath="//h1")
	WebElement Heading;
	
	@FindBy(xpath="//h3")
	WebElement LableEnterOtp;
		
	@FindBy(xpath="//input[@id='submitBtn']")
	WebElement Pay_Button;
	
	@FindBy(xpath="//input[@id='cancelButton']")
	WebElement CancelButton;
	
	public EnterOTP() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterotp() throws Exception
	{
		Verify_If_Text_Present_At_Element(Heading, pageHeading);
		Verify_If_Text_Present_At_Element(LableEnterOtp, Lable);
		EnterText(Password, "123456");
		Click(Pay_Button);
	}
	
}
