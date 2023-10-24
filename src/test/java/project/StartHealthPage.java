package project;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import org.testng.Assert;

public class StartHealthPage {

	WebDriver driver;
	
	@BeforeClass
	public void openBrowser()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.starhealth.in/");
		

		
	}
	
	@Test(priority='1')
	public void Validate_title()
	{
		String ExpectedTitle = "Star Health Insurance: Medical, Accident and Travel insurance policies";
		String ActualTitle =driver.getTitle();
		
        Assert.assertEquals(ActualTitle, ExpectedTitle , "The title is not valid");
	}
	
	
	@Parameters({"UserName","mobile","pincode" })
    @Test(priority='2')

	public void Test_Header_plan( String UserName,String mobile, String pincode) throws InterruptedException
	
	{
		//System.out.println("Selenium code to hover over health Plan menu");

		WebElement e1 = driver.findElement(By.xpath("//div[@class='flex cursor-pointer pr-30 cursor-pointer nav-link flex']"));
		//hover over the account page
		
		Actions action = new Actions(driver);
		
		action.moveToElement(e1).perform();
		
		
		
		
		//System.out.println("Selenium code to click on familty option");
		
		driver.findElement(By.xpath("(//a[@class='font-500 text-capitalize text-14'])[2]")).click();
		//Thread.sleep(1500);
		
		System.out.println("Selenium code to check if checkbox is selected or not");
		// boolean selection = driver.findElement(By.("locatorvalue)).isSelected();
		//Assert.assertTrue(true); // check if the Authorize checkbox is slected or not
		
		System.out.println("Selenium code for sendkeys via parameters" + UserName);
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(UserName);
		

		System.out.println("Selenium code for sendkeys via parameters" + mobile);
		driver.findElement(By.xpath("//input[@id='phoneNumber']")).sendKeys(mobile);

		System.out.println("Selenium code for sendkeys via parameters" + pincode);
		driver.findElement(By.xpath("//input[@id='pinCode']")).sendKeys(pincode);

		
	}
	
	@Test(priority='3',dataProvider = "testdata" )
	public void validatedatafromExcel(String input1, String input2, String input3, String input4 )
	{
		// String youtube = driver.findElement(By.locator)).getAttribute(href);
	String	ActaulDetails1 = driver.findElement(By.xpath("(//a[@class='mr-4 mr-10-xs'])[2]")).getAttribute("href");
		System.out.println("write code to fetch the social media details for twitter");
		String Expecteddetail1 = input1;
		
		Assert.assertEquals(ActaulDetails1,Expecteddetail1);
		//if(ActaulDetails1.contains(Expecteddetail1))
		System.out.println("write code to fetch the social media details for twitter");
	}
	
	
	@DataProvider(name="testdata")
	public Object[][] datasupplier() throws EncryptedDocumentException, IOException
	{
		
		Object[][] inputdata = XLS_DataProvider.getTestData("Sheet2");
		
		return inputdata;
	}
	
	
	
	@Test(priority='4')
	public void Clickontwitter()
	{
		System.out.println("Inspect twitter link and click on it");
		
		System.out.println("Validate title of the page");
	}
	
	
	
	@AfterClass
	public void teardown()
	{
		driver.close();
	}
	
	
	
	
	
	
	
	
	
}