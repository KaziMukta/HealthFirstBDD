package com.stepdef;

import java.io.IOException;

import com.commonMethods.CommonMethod;
import com.utils.reports.Java_logger;
import com.webPages.HealthfirstLogin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef {
	
	HealthfirstLogin healthfirstLogin=new HealthfirstLogin(BaseClass.driver);
	CommonMethod cMethod=new CommonMethod();
	
	@Given("user should be on the Healthfirst home page")
	public void user_should_be_on_the_healthfirst_home_page() {
	String title=BaseClass.driver.getTitle();
  	Java_logger.getLog("Homepage title is: "+title);
	}

	@When("user should put the cursor on log in button")
	public void user_should_put_the_cursor_on_log_in_button() throws IOException {
		healthfirstLogin.logInButton(cMethod, BaseClass.driver); 
	}

	@Then("the system should display Provider Portal button")
	public void the_system_should_display_provider_portal_button() throws IOException {
	  boolean healfirst=healthfirstLogin.isPortalProvider(cMethod);
	  cMethod.sceenShot(BaseClass.driver,"Provider Portal.png");
	  Java_logger.getLog("Is Portal Provider: "+healfirst);
	}

	@Then("user should click on provider portal button")
	public void user_should_click_on_provider_portal_button() throws IOException {
	    healthfirstLogin.providerPortalButton(cMethod);
	    cMethod.sceenShot(BaseClass.driver,"After Provider Portal.png");
	}

	@Then("user should enter invalid Username")
	public void user_should_enter_invalid_username() throws IOException {
		healthfirstLogin.usernameField(cMethod); 
		cMethod.sceenShot(BaseClass.driver,"After User Name.png");
	}

	@Then("user should enter invalid Password")
	public void user_should_enter_invalid_password() throws IOException {
		healthfirstLogin.passwordField(cMethod); 
		cMethod.sceenShot(BaseClass.driver,"After Password.png");
	}

	@Then("user should click on Sign In button")
	public void user_should_click_on_sign_in_button() {
		healthfirstLogin.signinButton(cMethod);
	}

	@Then("the system should displays error")
	public void the_system_should_displays_error() throws IOException {
	 boolean errorMsg=healthfirstLogin.isErrorDisplayed(cMethod);
	 cMethod.sceenShot(BaseClass.driver,"Error.png");
	 Java_logger.getLog("Is error displayed: "+errorMsg);
	}
	

}
