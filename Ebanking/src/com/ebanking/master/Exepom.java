package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exepom 
{
	
	WebDriver driver;
	
     @BeforeTest
	public void Login() throws InterruptedException
	{
	    driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://103.211.39.246/ranford2");
		
		//Login
		
		RanfordHP RHP=PageFactory.initElements(driver,RanfordHP.class);
		RHP.Login();
		
	}
	
     @Test
     public void Rolecreation() throws InterruptedException, IOException
     {
    	 

 		FileInputStream FIS=new FileInputStream("D:\\EvngPrjFeb\\Ebanking\\src\\com\\ebanking\\testdata\\Role.xlsx");
 	
 		//WorkBook
 		
 		XSSFWorkbook WB = new XSSFWorkbook(FIS);
 		
 		//Sheets
 		
 		XSSFSheet WS = WB.getSheet("Rdata");
 		
 		//Row Count
 		
 		int Rcount=WS.getLastRowNum();
 	     System.out.println(Rcount);
 	
 	    //Multiple Iterations --------------- Loop
 	     
 	     for (int i=1;i<=Rcount;i++) 
 	     {
 		   //Row
 	    	 
 	    	 XSSFRow WR=WS.getRow(i);
 	    	 
 	    	 //Cell
 	    	 
 	    	 XSSFCell WC=WR.getCell(0);
 	    	 XSSFCell WC1=WR.getCell(1); 
 	    	 
 	    	 XSSFCell WC2=WR.createCell(2);
 	    	 
 	    	 
 	    	 //cell Values
 	    	 
 	    	String Rname=WC.getStringCellValue();
 	    	String Rty=WC1.getStringCellValue();
 	
		//Role
		
		AdminHP AHP=PageFactory.initElements(driver,AdminHP.class);
		AHP.Rol();
		
		//New Role
		
		RoleDetails RD=PageFactory.initElements(driver,RoleDetails.class);
		RD.Nrole();
		Thread.sleep(3000);
		//Role Creation
		
		RoleCreation Rc=PageFactory.initElements(driver,RoleCreation.class);
		Rc.Rcreation(Rname,Rty);
		Thread.sleep(3000);
		//Alert
		
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		//Home
		
		RD.Rhome();
		Thread.sleep(3000);
		
	}
     }
}
     
     