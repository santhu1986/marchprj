package com.ebanking.master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleNG 
{

	WebDriver driver;
	
	@BeforeMethod
	public void xyz()
	{
	driver=new FirefoxDriver();
	driver.manage().window().maximize();
	}
	@Test
	public void abc() throws InterruptedException
	{
		Thread.sleep(3000);
     driver.get("http://www.gmail.com");		
	}
	@Test
	public void bcd() throws InterruptedException
	{
		Thread.sleep(3000);
     driver.get("http://www.google.com");		
	}
	@AfterMethod
	public void pqr() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	}
	
	}
