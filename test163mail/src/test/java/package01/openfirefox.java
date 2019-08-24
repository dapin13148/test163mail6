package package01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.InterruptedIOException;

/**
 * Created by lenovo on 2016/10/11.
 */
public class openfirefox {
    WebDriver driver;
 /*   @Test
    public void openfire(){
        driver=new FirefoxDriver();
    }*/
   @Test
    public void openfires(){
	   //System.setProperty("webdriver.gecko.driver", ".\\Tools\\geckodriver.exe");
       System.setProperty("webdriver.gecko.driver","D:\\工具插件\\geckodriver.exe");
       System.setProperty("webdriver.firefox.bin","D:\\工具插件\\firefox-47.0.win64.sdk\\bin\\firefox.exe");
       driver=new FirefoxDriver();
       driver.get("http://www.sina.com.cn/");
       String title=driver.getTitle();
       System.out.println(title);
       Assert.assertEquals(title,"新浪首页");
    }
/*    @AfterTest
    public void closedfire()throws InterruptedException{
        Thread.sleep(5000);
        driver.quit();
    }*/

   
}



