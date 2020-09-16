package Icicibillingportal.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Icicibillingportal.qa.base.Utils;

public class AddpaymentMethod extends Utils{
	
	@FindBy(xpath="//a[@href='#netbanking']")
	WebElement NetBanking;
	
	@FindBy(xpath="//a[@href='#credit']")
	WebElement Credit;
	
	@FindBy(xpath="//span[@id='totalAmount']")
	WebElement Amount;

	@FindBy(xpath="//span[@id='selectedCurrency']")
	WebElement SelectedCurrency;

	@FindBy(xpath="//p[@id='txndiv']/span")
	WebElement TransactionId;

	@FindBy(xpath="//input[@id='ccard_number']")
	WebElement CreditCardNumber;

	@FindBy(xpath="//input[@name='cname_on_card']")
	WebElement NameOnCard;

	@FindBy(xpath="//input[@name='ccvv_number']")
	WebElement CVVNo;
	
	@FindBy(xpath="//p[@class='dropdowns']//select[@id='cexpiry_date_month']")
	WebElement SelectMonth;

	@FindBy(xpath="//p[@class='dropdowns']//select[@id='cexpiry_date_year']")
	WebElement SelectYear;
	
	@FindBy(xpath="//label[@for='ccard_number' and @class='error']")
	WebElement Error_CardNo_NotEntered;
	
	@FindBy(xpath="//label[@for='ccvv_number' and @class='error']")
	WebElement Error_CVVNo_NotEntered;
	
	@FindBy(xpath="//label[@for='cexpiry_date_month' and @class='error']")
	WebElement Error_Date_NotEntered;
	
	@FindBy(xpath="//input[@class=' credit_pay_button' and @type='submit']")
	WebElement PayNow_Button;
	
	@FindBy(xpath="//div[@class='payment_box_header']/p")
	WebElement ChoosePaymentMethod;
	
	public AddpaymentMethod() {
		PageFactory.initElements(driver, this);
	}
	
	public void VerifyHeading()
	{
		Verify_If_Text_Present_At_Element(ChoosePaymentMethod, "Choose a payment method");
	}
	public void Set_TransactionId()
	{
		dataList.put("ActualTransactionID", TransactionId.getText());
	}
	
	public void ValidAmountDisplays(String Expected)
	{
		Verify_If_Text_Present_At_Element(Amount, Expected);		
	}
	
	public void VerifyErrorForAllMandatoryFields() throws Exception
	{
		Click(PayNow_Button);	
		Verify_If_Text_Present_At_Element(Error_CardNo_NotEntered, "Invalid credit card number.");
		Verify_If_Text_Present_At_Element(Error_CVVNo_NotEntered, "Invalid CVV number.");
		Verify_If_Text_Present_At_Element(Error_Date_NotEntered, "Please select date");
	}
	public void VerifyIfcardnotEntered() throws Exception
	{
		EnterText(NameOnCard, "Garima");
		EnterText(CVVNo, "123");
		SelectTextfromdropdown(SelectMonth, "Jan (1)");
		SelectTextfromdropdown(SelectYear, "2021");
		Click(PayNow_Button);
		Verify_If_Text_Present_At_Element(Error_CardNo_NotEntered, "Invalid credit card number.");
	}
	
	public void VerifyErrorIfCVVNotEntered() throws Exception
	{
		EnterText(CreditCardNumber, "5123456789012346");
		EnterText(NameOnCard, "Garima");
		SelectTextfromdropdown(SelectMonth, "Jan (1)");
		SelectTextfromdropdown(SelectYear, "2021");
		Click(PayNow_Button);
		Verify_If_Text_Present_At_Element(Error_CVVNo_NotEntered, "Invalid CVV number.");
	}
	
	public void VerifyIfYearNotSelected() throws Exception
	{
		EnterText(CreditCardNumber, "5123456789012346");
		EnterText(NameOnCard, "Garima");
		EnterText(CVVNo, "123");
		SelectTextfromdropdown(SelectMonth, "Jan (1)");
		Click(PayNow_Button);
		Verify_If_Text_Present_At_Element(Error_Date_NotEntered, "Please select year.");
		
	}
	public void VerifyIfMonthNotSelected() throws Exception
	{
		EnterText(CreditCardNumber, "5123456789012346");
		EnterText(NameOnCard, "Garima");
		EnterText(CVVNo, "123");
		SelectTextfromdropdown(SelectYear, "2021");
		Click(PayNow_Button);
		Verify_If_Text_Present_At_Element(Error_Date_NotEntered, "Please select month.");		
	}
	
	public void VerifyErrorForWrongCreitCard() throws Exception
	{
		EnterText(CreditCardNumber, "1111111111111111");
		EnterText(NameOnCard, "Garima");
		EnterText(CVVNo, "123");
		SelectTextfromdropdown(SelectMonth, "Jan (1)");
		SelectTextfromdropdown(SelectYear, "2021");
		Click(PayNow_Button);
	}
	
	public void EnterCardDetails() throws Exception
	{
		EnterText(CreditCardNumber, "5123456789012346");
		EnterText(NameOnCard, "Garima");
		EnterText(CVVNo, "123");
		SelectTextfromdropdown(SelectMonth, "Jan (1)");
		SelectTextfromdropdown(SelectYear, "2021");
		Click(PayNow_Button);
	}
	
}
