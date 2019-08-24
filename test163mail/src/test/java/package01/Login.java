package package01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
	WebDriver driver;
	
	@BeforeMethod
	public void openchrome(){
		System.setProperty("webdriver.chrome.driver","D:\\工具插件\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://mail.163.com/");
	}
	
	@Test(priority=1)
	public void loginSuccess(){
		//01 点击切换到密码登录
		driver.findElement(By.id("switchAccountLogin")).click();
		//失败：减号还是空格原因导致null所以失败driver.findElement(By.className("u-login-entry u-163-login-entry")).click();
		//成功：driver.findElement(By.linkText("密码登录")).click();
		//成功：driver.findElement(By.xpath(".//*[@id='commonOperation']/a[1]")).click();
		//成功：去掉前面点号也可以driver.findElement(By.xpath("//*[@id='commonOperation']/a[1]")).click();
		//成功：driver.findElement(By.xpath(".//*[@id='switchAccountLogin']")).click();
		//成功：driver.findElement(By.cssSelector("#switchAccountLogin")).click();
		
		//driver.switchTo().frame(0);	
		driver.switchTo().frame(0);	

		
		//02  输入账号,注意后面要加方法且要对
		driver.findElement(By.name("email")).sendKeys("dapin13148");
		
		//下面成功：可以含有减号，account-box下的div有三个，但是下面div下有input的只有一个，第二个，但是这里不用指明第二个，如何指定第二个呢？XPATH指定第二个是[2]
		//成功：driver.findElement(By.cssSelector("#account-box>div>input")).sendKeys("dapin13148");
		//成功：这个明确指定了第二个，意外地比xpath复杂driver.findElement(By.cssSelector("#account-box>div:nth-child(2)>input")).sendKeys("dapin13148");
		//div p{样式}其实在这里的解释是，选择<div>内所有<p>元素，不会是局限在<div>的下一级，而是不过<p>元素在第几级都会找到。
		//div>p表示div下的子元素中所有p元素，中间可以有空格；div>p:nth-child(2)表示div的子元素所有p元素的第二个
		//虽然这两个选择器都表示兄弟选择器，但是+选择器则表示某元素后相邻的兄弟元素，也就是紧挨着的，是单个的。
		//而~选择器则表示某元素后所有同级的指定元素，强调所有的。
		
		//成功：driver.findElement(By.xpath("//*[@data-loginname='loginEmail']")).sendKeys("dapin13148");
		//成功：driver.findElement(By.cssSelector("[data-loginname='loginEmail']")).sendKeys("dapin13148");		
		//失败：id可变driver.findElement(By.xpath("//*[@id='auto-id-1566308540639']"));
		
		//03 输入密码
		driver.findElement(By.name("password")).sendKeys("abc123789");
		//成功：driver.findElement(By.cssSelector("[name='password']")).sendKeys("abc123789");
		
		//04 点击登录按钮
		driver.findElement(By.id("dologin")).click();
		//成功：driver.findElement(By.cssSelector("#dologin")).click();
		//成功：driver.findElement(By.xpath("//*[@data-action='dologin']")).click();
		//成功：driver.findElement(By.linkText("登  录")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));
		
		String text=driver.findElement(By.linkText("退出")).getText();
		Assert.assertEquals(text, "退出");
		
		//05点击退出
		driver.findElement(By.linkText("退出")).click();
		
	}
	

	@Test(priority=2)
	public void loginFalse(){
		driver.findElement(By.id("switchAccountLogin")).click();
		driver.switchTo().frame(0);	
		driver.findElement(By.cssSelector("#account-box>div>input")).sendKeys("dapin13148");
		driver.findElement(By.cssSelector("[name='password']")).sendKeys("111abc123789");
		driver.findElement(By.cssSelector("#dologin")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ferrorhead")));
		
		String text=driver.findElement(By.className("ferrorhead")).getText();
		System.out.println("text结果是:"+text);
		Boolean xx=text.equals("请先进行验证");
		System.out.println("xx:"+xx);
		Boolean yy=text.equals("帐号或密码错误");
		System.out.println("yy:"+yy);
		
		Boolean result=(text.equals("请先进行验证") | text.equals("帐号或密码错误"));
		System.out.println("result结果是:"+result);
		//Boolean x="ab"=="ab";
		//Assert.assertEquals(text, "帐号或密码错误");
		//Assert.assertEquals(text, "请先进行验证");
		//Assert.assertEquals(text,"帐号或密码错误", "请先进行验证");这个理解错误
		//Assert.assertEquals("text","帐号或密码错误", "哈哈，提示信息又换了。。。。。。。。。。。。。");
		Assert.assertTrue(result);
	}
	
	
	@AfterMethod
	private void CloseChrome() {
		//默认打开的data:,没有关闭，所以浏览器也没有关闭，只关闭了该选项卡。？？？？？
		//driver.close();
		driver.quit();
	}
}
