package com.stepdef;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.utils.reports.Java_logger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    public static WebDriver driver;
   
    @Before
    public  void setUp() {
    	WebDriverManager.chromedriver().setup();
    	driver=new ChromeDriver();
      	Java_logger.getLog("Browser is opening");
    	driver.get("https://healthfirst.org/");
      	Java_logger.getLog("HealthFirst is opening");
    	driver.manage().window().maximize();
    	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    	
    @After
    public void tearUp() {
    	driver.quit();
    }
    
 

}


