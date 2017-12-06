package Setup;

import org.testng.annotations.Test;

import com.google.common.base.Predicate;

import java.util.Timer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

public class NewTest {
  @Test
  public void f() {
  System.out.println("testing");
  System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.get("http://www.toolsqa.com");
	
	loadPageBeforeNaviating(driver);

	driver.findElement(By.xpath("//*[@id='primary-menu']/li[2]/a/span[1]/span/span")).click();;

	
	
  
  }
  
  public static void loadPageBeforeNaviating(WebDriver wb) {
      WebDriverWait _wait = new WebDriverWait(wb, 20);
	_wait.until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver wdriver) {
	            return ((JavascriptExecutor) wb).executeScript(
	                "return document.readyState"
	            ).equals("complete");
	        }
	    }); 
      
  }
  
}
