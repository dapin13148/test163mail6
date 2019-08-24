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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SendMail {
	WebDriver driver=null;
	
	@BeforeClass
	public void openChrome(){
		System.setProperty("webdriver.chrome.driver", "D:\\工具插件\\chromedriver.exe");
		driver=new ChromeDriver();
		
        //System.setProperty("webdriver.gecko.driver", "D:\\工具插件\\geckodriver.exe");	
        //driver = new FirefoxDriver(); 
		
        //System.setProperty("webdriver.ie.driver", "D:\\工具插件\\IEDriverServer.exe");
        //driver = new InternetExplorerDriver(); 
		
        //System.setProperty("webdriver.edge.driver", "D:\\工具插件\\MicrosoftWebDriver.exe");
        //driver = new EdgeDriver(); 
        
		driver.get("https://mail.163.com");


	}
	

	@Test
	public void sendMail(){
		Login2 login2=new Login2();
		login2.login(driver,"dapin13148","abc123789");
		
		
/*		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".oz0")));
		
		//driver.findElement(By.className("oz0")).click();类名重复了
		driver.findElement(By.cssSelector(".oz0")).click();;
		driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("dapin13148@163.com");*/
		
		
/*		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='收 信']")));
		
		//driver.findElement(By.className("oz0")).click();类名重复了
		driver.findElement(By.xpath(".//*[text()='收 信']"));
		driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("dapin13148@163.com");*/
		
		
/*		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#dvNavTop>ul>li+li>span+span")));
		driver.findElement(By.cssSelector("#dvNavTop>ul>li+li>span+span"));
		上面这句是定位到“写信”两个字，但其实点击的是外层的按钮，下面的语句正确*/
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#dvNavTop>ul>li+li")));
		driver.findElement(By.cssSelector("#dvNavTop>ul>li+li")).click();

		
		driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("dapin13148@qq.com");
		//错误driver.findElement(By.className(".nui-editableAddr-ipt")).sendKeys("dapin13148@qq.com");;
		//大框不对driver.findElement(By.cssSelector("[aria-label='邮件主题输入框，请输入邮件主题']")).sendKeys("主题信息哦！！");;
		//不对哦driver.findElement(By.className("nui-ipt-input")).sendKeys("主题信息哦");
		
		driver.findElement(By.cssSelector("[aria-label='邮件主题输入框，请输入邮件主题']>input")).sendKeys("标题哦");;

		driver.findElement(By.cssSelector("[title='一次可发送2000张照片，600首MP3，一部高清电影']>input")).sendKeys("D:\\360安全浏览器下载\\百度云链接.txt");;
		
		//不行driver.findElement(By.className("js-component-component iy1")).sendKeys("xxxxxxxxx");
		//不行driver.findElement(By.xpath(".//*[text()='尝试下写信输入@，@联系人后系统自动把此人加到收件人']")).sendKeys("222222");
		
		//错误driver.switchTo().frame("APP-editor-iframe");
		WebElement frame=driver.findElement(By.cssSelector(".APP-editor-iframe"));
		//错误driver.switchTo().frame("frame");
		
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("/html/body")).sendKeys("内容哦！");
		//不行driver.findElement(By.className("nui-scroll")).sendKeys("内容哦！");
		//driver.findElement(By.xpath("html/body")).sendKeys("内容哦！");
		//driver.findElement(By.cssSelector(".nui-scroll")).sendKeys("neirongo");
/*		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".tx0>ul>li+li>span+span")));
		很奇怪，为什么无法查找到元素呢
		//driver.findElement(By.className("oz0")).click();类名重复了
		driver.findElement(By.cssSelector(".tx0>ul>li+li>span+span"))
		driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("dapin13148@163.com");
		
		//发送
		
		
		
/*		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("nui-tree-item-text")));

		driver.findElement(By.className("nui-tree-item-text")).click();*/
		
	}
}
