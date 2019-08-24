package package01;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class TestBrowser {
    public WebDriver driver; 
    //@Parameters("browser")
  
  @Test
  public void  liulanqi() {
    	String Browser="firefox";
        //分别启动火狐、IE、Edge和Chrome浏览器
        if(Browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "D:\\工具插件\\geckodriver.exe");
            driver = new FirefoxDriver(); 
        }else if(Browser.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver", "D:\\工具插件\\IEDriverServer.exe");
            driver = new InternetExplorerDriver(); 
        }else if(Browser.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", "D:\\工具插件\\MicrosoftWebDriver.exe");
            driver = new EdgeDriver(); 
        }else{
            System.setProperty("webdriver.chrome.driver", "D:\\工具插件\\chromedriver.exe");
            driver = new ChromeDriver(); 
        }
        driver.manage().window().maximize();   //     
  }
  
    
  @Test
  public void mallcooTest() {
      //打开测试库标准版后台
      driver.get("http://mp-t.mallcoo.cn/");
      WebElement usernameInputBox=driver.findElement(By.id("username"));
      Assert.assertTrue(usernameInputBox.isDisplayed());
      usernameInputBox.sendKeys("xxx");
      WebElement passwordInputBox=driver.findElement(By.id("password"));
      Assert.assertTrue(passwordInputBox.isDisplayed());
      passwordInputBox.sendKeys("xxx");
  }

  @AfterTest
  public void afterTest() {
      driver.quit();//关闭打开的浏览器
  }

}