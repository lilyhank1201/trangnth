package Alert_days16;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.Close;

import automation.common.CommonBase;

public class AlertSendKeys extends CommonBase {
	@BeforeTest
	public void openPage(){
		driver = initDriverTest("https://demo.automationtesting.in/Alerts.html"); 
	}
	@Test
	public void TestAlert02() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'click the button to demonstrate the prompt box')]")).click();
		//Nhấp sendkeys vào ô text
		driver.switchTo().alert().sendKeys("CodeStart Automation test with HoanTran");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
	}
	@AfterTest
	public void classPage() {
		quitDriver(driver);
	}
	  
}
