package package01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

/**
 * Created by lenovo on 2016/10/11.
 */
public class openchrome {
    WebDriver driver;
    @Test
    public void openchrome(){

        System.setProperty("webdriver.chrome.driver","D:\\工具插件\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://www.sina.com.cn/");
        String title=driver.getTitle();
        System.out.println(title);
//      Assert.assertEquals(title,"新浪首页");
    }
    
    
    
    
    
    
    
    

    @Test
    public void openEdge(){
        System.setProperty("webdriver.edge.driver","D:\\testing\\webdriver_demo\\drivers\\MicrosoftWebDriver.exe");
        driver=new EdgeDriver();
    }

/*    @AfterTest  //没有建testng.xml时方法执行后也执行了这个
    public void closedchrome()throws InterruptedException{
        Thread.sleep(5000);
        driver.quit();
    }*/
}
