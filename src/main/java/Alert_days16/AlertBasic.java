package Alert_days16;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class AlertBasic extends CommonBase {
	@BeforeTest
	public void openPage() {
		driver = initDriverTest("https://demo.guru99.com/test/delete_customer.php");
	}

	@Test
	public void TestAlert01() throws InterruptedException {
		driver.findElement(By.name("cusid")).sendKeys("123456");
		driver.findElement(By.name("submit")).submit();
		/// Khai báo chuyển hướng đến Alert với đối tượng
		Alert alert = driver.switchTo().alert();
		// get msg trên alert
		String alertMessage = driver.switchTo().alert().getText();
		// Hiện ra trên console nội dung của alert msg
		System.out.print(alertMessage);
		Thread.sleep(2000);
		// accept()= nhấn ok button
		// driver.switchTo().alert() //là cách 1
		alert.accept(); // là cách 2
		// nhấn cancel button
		// alert.dismiss();
		Thread.sleep(2000);
	}
}
