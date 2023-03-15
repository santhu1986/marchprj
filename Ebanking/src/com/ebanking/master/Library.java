package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Library 
{

	public static WebDriver driver;	
	public static String Expval,Actval;
	public static FileInputStream FIS;
	public static Properties PR;
    
	public String OpenApp(String URL) throws IOException
	{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\LENOVO\\OneDrive\\Desktop\\geckodriver.exe");
	
		FIS=new FileInputStream("D:\\EvngPrjFeb\\Ebanking\\src\\com\\ebanking\\properties\\Repository.properties");
        PR=new Properties();
        PR.load(FIS);
		
		
		Expval="Ranford Bank";
		
		driver=new FirefoxDriver();
		
		//Maximise
		
		driver.manage().window().maximize();
		
		//URL
		
		driver.get(URL);
		
	  Actval=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span")).getText();
		
		//Comparision
		
		if (Expval.equalsIgnoreCase(Actval))
		{
		System.out.println("Application Launch Succ");	
		}
		else
		{
			System.out.println("Application Failed to Launch");
		}
		
		return "pass";
		
	
	}
	
	public String AdminLgn(String Un,String Pwd) throws InterruptedException
	{
	     Expval="Welcome to Admin";
		
		driver.findElement(By.id(PR.getProperty("Uname"))).sendKeys(Un);
		driver.findElement(By.id(PR.getProperty("Pswd"))).sendKeys(Pwd);
		Thread.sleep(3000);
		driver.findElement(By.xpath(PR.getProperty("Lgn"))).click();
		
		Actval=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
		
		//Comparision
		
				if (Expval.equalsIgnoreCase(Actval))
				{
				System.out.println("Admin Login Succ");	
				}
				else
				{
					System.out.println("Admin Login failed");
				}
				
	 return "Admin Login Succesfully";
	}
	
	public String BranchCre() throws InterruptedException
	{
		Expval="Sucessfully";
		
		driver.findElement(By.xpath(PR.getProperty("Bbutton"))).click();
		driver.findElement(By.id("BtnNewBR")).click();
		
		driver.findElement(By.id("txtbName")).sendKeys("hdfcfeb22023");
		driver.findElement(By.id("txtAdd1")).sendKeys("SrNagar");
		driver.findElement(By.id("txtZip")).sendKeys("12345");
		
		//DropDown
		
		Select Ctry=new Select(driver.findElement(By.id("lst_counrtyU")));
		Ctry.selectByVisibleText("INDIA");
		
		new Select(driver.findElement(By.id("lst_stateI"))).selectByVisibleText("Delhi");
		new Select(driver.findElement(By.id("lst_cityI"))).selectByVisibleText("Delhi");
		Thread.sleep(3000);
		driver.findElement(By.id("btn_insert")).click();
		Thread.sleep(3000);
		
		//Alert
		
		Actval=driver.switchTo().alert().getText();
		
		driver.switchTo().alert().accept();
		
		//Comparision
		
		if (Actval.contains(Expval)) 
		{
			System.out.println("Branch Created");
		}
		else
		{
			System.out.println("Branch Already Exist");
		}
		
		//Home
		
		driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")).click();
		return Actval;
	}
	
	//Role
	
		public String Role(String RN,String RT) throws InterruptedException
		{
			Expval="Sucessfully";
			
			driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(".//*[@id='btnRoles']")).click();
			driver.findElement(By.id("txtRname")).sendKeys(RN);
			driver.findElement(By.id("lstRtypeN")).click();
			driver.findElement(By.id("lstRtypeN")).sendKeys(RT);
			
			Thread.sleep(3000);
			driver.findElement(By.xpath(".//*[@id='btninsert']")).click();
			
			String Actval=driver.switchTo().alert().getText();
			
			System.out.println(Actval);
			
			Thread.sleep(3000);
		      driver.switchTo().alert().accept();
		      Thread.sleep(3000);
		      driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr/td[1]/a/img")).click();  
		      if (Actval.contains(Expval)) 
		      {
		    	  System.out.println("Role Created");
		    	 
				
			}
		      else{
		    	  System.out.println("role not created");
		       }
		 return Actval;     
		}

		
		//LogOut
		
		public void Alogout() throws InterruptedException 
		{
			Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[4]/table/tbody/tr/td[3]/a/img")).click();
		}
		
		
		//Close

		public void Aclose() throws InterruptedException 
		{
			Thread.sleep(3000);
		driver.close();	
		}


	
}
