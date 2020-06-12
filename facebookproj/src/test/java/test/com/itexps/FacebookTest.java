/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.com.itexps;

import com.itexps.facebookproj.FileUtil;
import com.itexps.facebookproj.LoginVO;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author virad
 */
public class FacebookTest {
      private WebDriver driver;
       private static LoginVO login = null;
    public FacebookTest() {
      
    }
    
    @BeforeClass
    public static void setUpClass() {
        
 login = FileUtil.getLoginData();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         System.setProperty("webdriver.chrome.driver", "C:\\QA\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
      @Test
  public void testFacebook() throws Exception {
     
   driver.get("https://www.facebook.com/");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
      driver.findElement(By.id("email")).sendKeys(login.getUsername());
    driver.findElement(By.id("pass")).clear();
    driver.findElement(By.id("pass")).sendKeys(login.getPassword());
  
    //driver.findElement(By.id("u_0_2")).click();
  driver.findElement(By.xpath("//input[@type='submit']")).click();
     
  }
}
