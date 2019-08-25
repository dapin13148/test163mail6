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

public class TestSendMail3 {
	WebDriver driver=null;
	final static LoggerControler log= LoggerControler.getLogger(LoggerTest.class);
	@BeforeClass
	public void openChrome(){
		System.setProperty("webdriver.chrome.driver", "D:\\���߲��\\chromedriver.exe");
		driver=new ChromeDriver();
   
		driver.get("https://mail.163.com");
		log.info("�Զ�������ҳ����");
	}
	

	@Test
	public void sendMail(){
		Login2 login2=new Login2();
		login2.login(driver,"dapin13148","abc123789");
		
		//������Ű�ť��ע�ⲻ�������������ڵ�span�����ȵ����������
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#dvNavTop>ul>li+li")));
		//��Ȼ������ѡ��������ʾ�ֵ�ѡ����������+ѡ�������ʾĳԪ�غ����ڵ��ֵ�Ԫ�أ�Ҳ���ǽ����ŵģ��ǵ����ġ�
		//��~ѡ�������ʾĳԪ�غ�����ͬ����ָ��Ԫ�أ�ǿ�����еġ�
		driver.findElement(By.cssSelector("#dvNavTop>ul>li+li")).click();	
		//�ɹ���driver.findElement(By.cssSelector("#dvNavTop>ul>li:nth-child(2)")).click();
		//�ɹ���driver.findElement(By.cssSelector(".qd0+ul>li+li")).click();
		//�ɹ���driver.findElement(By.cssSelector(".qd0+ul>li:nth-child(2)")).click();

		//�ռ��ˣ��ѵ㡣���������������һ�����Ƕ��������ע��С�Ķ�������������һ�������С����input�Ǹ�
		driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("dapin13148@qq.com");
		//�ɹ���driver.findElement(By.xpath("//*[@aria-label='�ռ��˵�ַ������������ʼ���ַ������ʱ��ַ���ԷֺŸ���']")).sendKeys("dapin13148@qq.com");

		//���⣬�����и�class�������ظ�������
		driver.findElement(By.cssSelector("[aria-label='�ʼ�����������������ʼ�����']>input")).sendKeys("����Ŷ");;
		
		//���ӣ��ѵ㡣������������������ť�����м���div���������ҵ������϶�����Ҳ�ǰ��ŵģ�input�����Դ������ƶ��͵���������ҵ�
		driver.findElement(By.className("O0")).sendKeys("D:\\ѧϰ�ܽ�\\�ҵ�.txt");
		
		//����Ȩ������iframe
		WebElement frame=driver.findElement(By.cssSelector(".APP-editor-iframe"));	
		driver.switchTo().frame(frame);
		//�Ҽ��������顱�������������ݵ���Ҽ�����顱����һ��������
		//iframe�ڸ��Ƶ�xpath����iframe���Ƿ��ظ����У�ճ���������������ҳ����ȫ����û��ϵ������
		//��ʵfirepath�������ģ�chromeF12�����ԣ��ر���ifarme����ctrl+f�������������ʾ·��
		//driver.findElement(By.xpath("/html/body")).sendKeys("����Ŷ��");
		//ʧ�ܣ�����ظ���driver.findElement(By.cssSelector("[title='һ�οɷ���2000����Ƭ��600��MP3��һ�������Ӱ']")).sendKeys("����Ŷ");


		driver.switchTo().defaultContent();
		//���ͣ�����a��ǩ����span��ǩ������linkText��css���ı����������أ�
		driver.findElement(By.xpath("//*[text()='����']")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='���ͳɹ�']")));

		//a�ı���h�ı�
		Boolean info=driver.findElement(By.xpath(".//*[text()='���ͳɹ�']")).isDisplayed();
		Assert.assertTrue(info);
		log.warning("�����ʼ��ɹ���");
	}
}
