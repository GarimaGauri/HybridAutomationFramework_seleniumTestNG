package Icicibillingportal.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Icicibillingportal.qa.base.Utils;

public class FillMandatoryDetails extends Utils{

	@FindBy(xpath="//input[@id='card-number1']")
	WebElement EnterCardNumber;
	
	@FindBy(xpath="//input[@id='re-card-number1']")
	WebElement ReEnterCreditCard;

	@FindBy(xpath="//h2")
	WebElement PageHeading;
	
	@FindBy(xpath="//input[@name='emailId']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='mobile-number']")
	WebElement PhoneNumber;
	
	@FindBy(xpath="//*[@name='bank_id']")
	WebElement SelectBank;
	
	@FindBy(xpath="//input[@id='payment-amount']")
	WebElement Amount;
		
	@FindBy(xpath="//label[@id='card-number-error']")
	WebElement CardNumberNotEnteredError;
	
	@FindBy(xpath="//label[@id='re-card-number-error']")
	WebElement ReenterCardNumberError;
	
	@FindBy(xpath="//label[@id='mobile-number-error']")
	WebElement MobileNumberNotEnteredError;
	
	@FindBy(xpath="//label[@id='payment-amount-error']")
	WebElement PaymentAmountNotEnteredError;
	
	@FindBy(xpath="//label[@id='bank_id-error']")
	WebElement BankNotSelectedError;
	
	@FindBy(xpath="//label[@id='email-id-error']")
	WebElement ValidEmailError;
	
	@FindBy(xpath="//input[@type='submit' and @value='Submit']")
	WebElement SubmitButton;
	
	public FillMandatoryDetails() {
		PageFactory.initElements(driver, this);
	}
	
	public void VerifyHeading()
	{
		Verify_If_Text_Present_At_Element(PageHeading, "Step 1 of 3 -"
               + "Enter details of your Card");
	
	}
	public void VerifyErrorsForAllMandatoryFields() throws Exception
	{
		Click(SubmitButton);
		Wait(9000);
		Verify_If_Text_Present_At_Element(ReenterCardNumberError, "Re-Enter ICICI Credit Card No.");
		Verify_If_Text_Present_At_Element(MobileNumberNotEnteredError, "Mobile number field is required.");
		Verify_If_Text_Present_At_Element(PaymentAmountNotEnteredError, "Amount field is required.");
		Verify_If_Text_Present_At_Element(BankNotSelectedError, "Select Bank Account field.");
		Verify_If_Text_Present_At_Element(CardNumberNotEnteredError, "Enter ICICI Credit Card No.");
	}
	public void VerifyEmailValidationError()
	{
		EnterText(Email, "Demo.com" + Keys.ENTER);
		Verify_If_Text_Present_At_Element(ValidEmailError, "Please enter a valid email address.");		
	}
	public void VerifyPhoneNumberValidationError()
	{
		EnterText(PhoneNumber, "7670");
		Verify_If_Text_Present_At_Element(MobileNumberNotEnteredError, "Please specify a valid mobile number");
	}
	
	public void CardNumberMismatchError()
	{
		EnterText(EnterCardNumber, "5123456789012346");
		EnterText(ReEnterCreditCard, "5123056709012346");
		Verify_If_Text_Present_At_Element(ReenterCardNumberError, "Re - Entered ICICI Credit Card mismatch");
	}
	public void VerifyDataClearAfterBrowserRefresh()
	{
		driver.navigate().refresh();
		Verify_If_Text_Present_At_Element(EnterCardNumber, "");
		Verify_If_Text_Present_At_Element(ReEnterCreditCard, "");
		Verify_If_Text_Present_At_Element(PhoneNumber, "");
		Verify_If_Text_Present_At_Element(Amount, "");
	}
	public void Submit() throws Exception
	{
		VerifyHeading();
		EnterText(EnterCardNumber, "5123456789012346");
		EnterText(ReEnterCreditCard, "5123456789012346");
		EnterText(PhoneNumber, "8860875072");
		EnterText(Amount, "789");
		SelectTextfromdropdown(SelectBank, "AXIS Net Banking");
		Click(SubmitButton);		
	}
	
}
