package package01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import log4j.LoggerControler;
import log4j.LoggerTest;

public class SendMail4xpath {
	WebDriver driver=null;
	final static LoggerControler log= LoggerControler.getLogger(LoggerTest.class);
	@BeforeClass
	public void openChrome(){
		System.setProperty("webdriver.chrome.driver", "D:\\工具插件\\chromedriver.exe");
		driver=new ChromeDriver();
   
		driver.get("https://mail.163.com");
		log.info("自动测试网页打开了");
	}
	

	@Test
	public void sendMail(){
		Login2 login2=new Login2();
		login2.login(driver,"dapin13148","abc123789");
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		//登录
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#dvNavTop>ul>li+li")));
		driver.findElement(By.cssSelector("#dvNavTop>ul>li+li")).click();

		
		driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("dapin13148@qq.com");	
		driver.findElement(By.cssSelector("[aria-label='邮件主题输入框，请输入邮件主题']>input")).sendKeys("标题哦");;
		//driver.findElement(By.cssSelector("[title='一次可发送2000张照片，600首MP3，一部高清电影']>input")).sendKeys("D:\\360安全浏览器下载\\百度云链接.txt");;
		//driver.findElement(By.className("O0")).click();
		driver.findElement(By.className("O0")).sendKeys("D:\\学习总结\\我的.txt");
		
		WebElement frame=driver.findElement(By.cssSelector(".APP-editor-iframe"));	
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("/html/body")).sendKeys("内容哦！");

		//driver.findElement(By.cssSelector(".nui-btn-text"));
		//driver.findElement(By.className("nui-btn-text"));
		driver.switchTo().defaultContent();	
		driver.findElement(By.xpath("//*[text()='发送']")).click();
		
		//WebDriverWait wait2=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='发送成功']")));
		//String info=driver.findElement(By.className("tK1")).getText();
		//Assert.assertEquals(info,"发送成功");
		//Assert.assertEquals(info,"发送成功手机收发邮件更方便");
		//String info=driver.findElement(By.xpath("//*[text()='发送成功']")).getText();
		//String info=driver.findElement(By.xpath(".//*[text()='发送成功']")).getText();
		//Assert.assertEquals(info,"发送成功");
		Boolean info=driver.findElement(By.xpath(".//*[text()='发送成功']")).isDisplayed();
		Assert.assertTrue(info);
		log.warning("发送邮件成功。");
	}
}
