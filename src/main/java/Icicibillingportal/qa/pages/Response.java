package Icicibillingportal.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Icicibillingportal.qa.base.Utils;

public class Response extends Utils{
	
	private String PageHeadingText = "Step 3 of 3 - Transaction Acknowledgement";
	
	@FindBy(xpath="//h2")
	WebElement PageHeading;
	
	@FindBy(xpath="//h1[contains(text(),'Thank you, Your payment has been successfully rece')]")
	WebElement ThankYouText;
	
	@FindBy(xpath="//h1[contains(text(),'Please quote your transaction reference number for')]")
	WebElement TransactionInfo;
	
	@FindBy(xpath="//div[4]//div[1]")
	WebElement TransactionStatusLable;
	
	@FindBy(xpath="//h1[contains(text(),'Success')]")
	WebElement TransactionStatus;
	
	@FindBy(xpath="//h1[contains(text(),'Transaction Reference Number')]")
	WebElement TransactionReferenceLable;
	
	@FindBy(xpath="//div[5]//div[2]/h1")
	WebElement TransactionNumber;
	
	@FindBy(xpath="//h1[contains(text(),'Transaction Date and Time')]")
	WebElement TransactionDateAndTime_lable;
	
	@FindBy(xpath="//div[6]//div[2]//h1[1]")
	WebElement TransactionDateTime;
	
	@FindBy(xpath="//h1[contains(text(),'ICICI Credit Card No.')]")
	WebElement ICICICreditCardNo_lable;
	
	@FindBy(xpath="//div[7]//div[2]//h1[1]")
	WebElement CreditCardNo;
	
	@FindBy(xpath="//h1[contains(text(),'E-mail ID')]")
	WebElement Email_Lable;
	
	@FindBy(xpath="//h1[contains(text(),'E-mail ID')]")
	WebElement EmailId;
	
	@FindBy(xpath="//h1[contains(text(),'Mobile No.')]")
	WebElement MobileNoLable;
	
	@FindBy(xpath="//div[9]//div[2]//h1[1]")
	WebElement MobileNo;
	
	@FindBy(xpath="//h1[contains(text(),'Payment Amount (Rs.)')]")
	WebElement PaymentAmount_Lable;
	
	@FindBy(xpath="//div[10]//div[2]//h1[1]")
	WebElement Amount;
	
	@FindBy(xpath="//h1[contains(text(),'Pay from')]")
	WebElement PayFrom_Lable;
	
	@FindBy(xpath="//div[11]//div[2]//h1[1]")
	WebElement PayFrom;
	
	public Response() {
		PageFactory.initElements(driver, this);
	}
	
	public void VerifyPageHeading()
	{
		Verify_If_Text_Present_At_Element(PageHeading, PageHeadingText);
	}
	
	public void VerifyThankYouText()
	{
		Verify_If_Text_Present_At_Element(ThankYouText, "Thank you, Your payment has been successfully received with the following details.");
	}
	
	public void VerifyTransactionInfoText()
	{
		Verify_If_Text_Present_At_Element(TransactionInfo, "Please quote your transaction reference number for any queries relating to this request.");
	}
	public void VerifyFullResponse()
	{
		Verify_If_Text_Present_At_Element(TransactionStatus, "Success");
		Verify_If_Text_Present_At_Element(TransactionNumber, dataList.get("ActualTransactionID"));
		//Verify_If_Text_Present_At_Element(TransactionDateTime, "Success");
		Verify_If_Text_Present_At_Element(CreditCardNo, "5123456789012346");
		Verify_If_Text_Present_At_Element(EmailId, "gnarang31@gmail.com");
		Verify_If_Text_Present_At_Element(MobileNo, "8860875072");
		Verify_If_Text_Present_At_Element(Amount, "789");
		Verify_If_Text_Present_At_Element(PayFrom, "AXIS NetBanking");
		
		
	}
	
}
