package Icicibillingportal.qa.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	public static WebDriver driver;
	private boolean acceptNextAlert = true;
	public static Map<String,String> dataList= new HashMap<String,String>();
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	 
		
	public static void setup(String browser) throws Exception{
		if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\garima\\Downloads\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\garima\\workspace\\Practice1\\ICICIBillingPortal\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else{
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void LaunchApplication(String browser) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\garima\\workspace\\Practice1\\ICICIBillingPortal\\resources\\chromedriver.exe");
		driver= new ChromeDriver();
		//setup(browser);
		driver.get("https://tsdsandbox.payu.in/icici_card_payment/icici-card-payment");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);			
	}
	public static void extentReport() {
		
		htmlReporter=new ExtentHtmlReporter("C:\\Users\\garima\\workspace\\Practice1\\ICICIBillingPortal\\test-output\\report.html");	
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Report");
        // Create object of ExtentReports class- This is main class which will create report
		ExtentReports extent = new ExtentReports();
    
        // attach the reporter which we created in Step 1
		extent.attachReporter(htmlReporter);
	}
	public static void MouseHover(WebElement element)
	{
		Actions builder = new Actions(driver);
        Action mouseOverHome = builder.moveToElement(element).build();
        mouseOverHome.perform();
	}
	
	public static void EnterText(WebElement element, String text)
	{
		element.sendKeys(text);
	}
	public static void Click(WebElement element) throws Exception{
		try {
			if(element.isDisplayed())
				{ element.click();
					}
				
		}
		catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static boolean Verify_If_Element_Exist(WebElement element) {
		
		if(element.isDisplayed())
  		 {return true;}
		else 
			{return false;}
	}
	
	public static void SelectTextfromdropdown(WebElement element,String Text)
	{
		try{
		Select drpdown= new Select(element);
		drpdown.selectByVisibleText(Text);
		}catch(NoSuchElementException e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void SelectValuefromdropdown(WebElement element,String Value)
	{
		try{
		Select drpdown= new Select(element);
		drpdown.selectByValue(Value);
		}catch(NoSuchElementException e){
			System.out.println(e.getMessage());
		}
		
	}
	public static void SelectIndexfromdropdown(WebElement element,int index)
	{ 
		try{
		Select drpdown= new Select(element);
		drpdown.selectByIndex(index);
		}catch(NoSuchElementException e){
			System.out.println(e.getMessage());
		}
		
	}
	/*public static void Verify_Text_selectedFromDrodpwn(WebElement element)
	{
		try{
			Select drpdown= new Select(element);
			List<WebElement> selected_values = drpdown.getAllSelectedOptions();
			System.out.println("Selected Dropdown Values" + selected_values.size());
			for(WebElement e : selected_values)
			{
				System.out.println(e.getText());
			}
			}catch(NoSuchElementException e){
				System.out.println(e.getMessage());
			}
	}*/
	public static void Wait(int seconds)
	{
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	public static void Verify_If_Text_Present_At_Element(WebElement element,String expected)
	{
		Verify_If_Element_Exist(element);
		String actualText=element.getText();
		Assert.assertEquals(actualText, expected);		
	}
	private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }
	 private boolean isElementPresent(By by) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		  }
	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	
	  public static void SetData()
	  {
		 dataList.put("CardNo","5123456789012346");
		 dataList.put("Email","gnarang31@gmail.com");
		 dataList.put("PhoneNo","8860875072");
		 dataList.put("CvvNo","123");
		 dataList.put("OneTimePassword","123456");
	  }
	  public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		  String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		  TakesScreenshot ts = (TakesScreenshot) driver;
		  File source = ts.getScreenshotAs(OutputType.FILE);
		  
		  // after execution, you could see a folder "FailedTestsScreenshots" under src folder
		  String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		  File finalDestination = new File(destination);
		 // FileUtils.copyFile(source, finalDestination);
		  return destination;
		 }
	  
	  
	   public void endReport() throws IOException
	   {
		   
		   extent.flush();
		     
	   }
	   
	   public void Close()
	   {
		   driver.quit();
	   }
}
