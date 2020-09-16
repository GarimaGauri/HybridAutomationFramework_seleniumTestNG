import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Icicibillingportal.qa.base.Utils;
import Icicibillingportal.qa.pages.AddpaymentMethod;
import Icicibillingportal.qa.pages.EnterOTP;
import Icicibillingportal.qa.pages.FillMandatoryDetails;
import Icicibillingportal.qa.pages.Response;
import net.bytebuddy.description.enumeration.EnumerationDescription;

public class TestCases extends Utils{
	
	FillMandatoryDetails fillform;
	AddpaymentMethod addpaymentdetails;
	EnterOTP enterOTP;
	Response response;
	
	@BeforeTest
	@Parameters("browser")
	public void LaunchComptonApplication(String browsername) throws Exception
	{
		extentReport();
		LaunchApplication(browsername);
	}
	
	@Test(priority =1)
	public void VerifyErrorsIfMandatoryFieldsNotEntered() throws Exception
	{
		test=extent.createTest("VerifyErrorsIfMandatoryFieldsNotEntered");
		fillform = new FillMandatoryDetails();
		fillform.VerifyErrorsForAllMandatoryFields();
		fillform.VerifyEmailValidationError();
		fillform.VerifyPhoneNumberValidationError();
		fillform.CardNumberMismatchError();
		fillform.VerifyDataClearAfterBrowserRefresh();
	}
	
	@Test(priority =2)
	public void SubmitForm() throws Exception
	{
		test=extent.createTest("SubmitForm");
		fillform = new FillMandatoryDetails();
		fillform.Submit();
	}

	@Test(priority =3)
	public void EnterCardDetailsAndPay() throws Exception
	{
		test=extent.createTest("EnterCardDetailsAndPay");
		addpaymentdetails = new AddpaymentMethod();
		addpaymentdetails.VerifyHeading();
		addpaymentdetails.Set_TransactionId();
		addpaymentdetails.ValidAmountDisplays("789");
		addpaymentdetails.VerifyErrorForAllMandatoryFields();
		addpaymentdetails.VerifyErrorForWrongCreitCard();
		addpaymentdetails.VerifyErrorIfCVVNotEntered();
		addpaymentdetails.VerifyIfcardnotEntered();
		addpaymentdetails.VerifyIfMonthNotSelected();
		addpaymentdetails.VerifyIfYearNotSelected();	
		addpaymentdetails.EnterCardDetails();
	}
	
	@Test(priority =4)
	public void EnterOtpandProceed() throws Exception
	{
		test=extent.createTest("EnterOtpandProceed");
		enterOTP = new EnterOTP();
		enterOTP.enterotp();
	}
	
	@Test(priority=5)
	public void VerifyResponse()
	{
		test=extent.createTest("VerifyResponse");
		response=new Response();
		response.VerifyPageHeading();
		response.VerifyThankYouText();
		response.VerifyTransactionInfoText();
		response.VerifyFullResponse();
	}
	
	@AfterTest
	public void tearDown(ITestResult result) throws IOException{
		
		 if(result.getStatus()==ITestResult.FAILURE)
			{
				test.log(Status.FAIL, "Test Case failed is : "+ result.getName());
				test.log(Status.FAIL, "Test Case failed is : "+ result.getThrowable());
				
				  String screenshotPath = getScreenshot(driver, result.getName());
				   test.addScreenCaptureFromPath(screenshotPath);
			}
		   else if(result.getStatus()==ITestResult.SKIP)
		   {
			   test.log(Status.SKIP, "Test Case skipped is : "+ result.getName());
		   }
		   else if(result.getStatus()==ITestResult.SUCCESS)
		   {
			   test.log(Status.PASS, "Test Case passed is : "+ result.getName());
		   }
		Close();
		endReport();
	}
}
