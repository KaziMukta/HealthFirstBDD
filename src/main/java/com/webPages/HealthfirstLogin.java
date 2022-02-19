package com.webPages;

import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.commonMethods.CommonMethod;
import com.stepdef.BaseClass;

public class HealthfirstLogin {
	
	public HealthfirstLogin(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="(//span[text()='Login'])[1]") public WebElement logInElement;
	@FindBy(linkText="Provider Portal") public WebElement providerPortal;
	@FindBy(xpath = "//input[@id='username']") public WebElement userName;
	@FindBy(xpath = "//input[@id='password']") public WebElement passWord;
	@FindBy(xpath = "//button[@id='loginButton']") public WebElement signIn;
	@FindBy(xpath = "//p[text()='Login Failed.']") public WebElement error;
	
	public void logInButton(CommonMethod cMethod, WebDriver driver) {
		cMethod.hoverOver(driver, logInElement);
	}
	public boolean isPortalProvider(CommonMethod cm) {
	boolean portal=cm.isElementDisplayed(providerPortal);
	return portal;
	}
	public void providerPortalButton(CommonMethod cMethod) {
		cMethod.clickMethod(providerPortal);
		Set<String> allwindows=BaseClass.driver.getWindowHandles();
		String parent=(String) allwindows.toArray()[0];
		String child=(String) allwindows.toArray()[1];
		BaseClass.driver.switchTo().window(child);
	}
	
	public void usernameField(CommonMethod cMethod) {
		cMethod.enterText(userName, "Mukta");
	}
	
	public void passwordField(CommonMethod cMethod) {
		cMethod.enterText(passWord, "Muk123");
	}
	
	public void signinButton(CommonMethod cMethod) {
		JavascriptExecutor js=(JavascriptExecutor) BaseClass.driver;
		js.executeScript("arguments[0].scrollIntoView(true)", signIn);
		cMethod.clickMethod(signIn);
	}
	public boolean isErrorDisplayed(CommonMethod cm) {
	boolean errorMsg=cm.isElementDisplayed(error);
	return errorMsg;
	}
	

}
