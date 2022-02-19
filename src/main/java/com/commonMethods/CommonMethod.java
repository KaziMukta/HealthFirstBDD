package com.commonMethods;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stepdef.BaseClass;

public class CommonMethod {


	public void hoverOver(WebDriver driver, WebElement element){
	       Actions action=new Actions(driver);
	       action.moveToElement(element).build().perform();
      }
    public boolean isElementDisplayed(WebElement element){
          boolean tt= element.isDisplayed();
          System.out.println("Element is displayed ="+tt);
          return tt;
   }  
    public void enterText(WebElement element,String value){
           element.sendKeys(value);
     }   
    public void clickMethod(WebElement element){
    	WebDriverWait wait=new WebDriverWait(BaseClass.driver, 20);
    	wait.until(ExpectedConditions.elementToBeClickable(element));
           element.click();
     }    
    public void sceenShot(WebDriver driver, String msg) throws IOException {
    File souceFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileHandler.copy(souceFile, new File("C:\\Users\\Arvin\\eclipse-workspace\\HealthFirstBDD\\SceenShot"+" "+msg));
    }
     
     }
