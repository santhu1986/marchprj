package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RoleCreation 
{

	//Element Properties
	
     @FindBy(id="txtRname")
     WebElement RoleName;
     

     @FindBy(id="lstRtypeN")
     WebElement RoleType;
     

     @FindBy(xpath=".//*[@id='btninsert']")
     WebElement Submit;
     
     public void Rcreation(String Rn,String Rt) throws InterruptedException 
     {
            RoleName.sendKeys(Rn);
            Select RT=new Select(RoleType);
    		RT.selectByVisibleText(Rt);
    		Thread.sleep(3000);
            Submit.click();
     }
     
     
     
     
}
