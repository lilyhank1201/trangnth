package Windown_iframe;

import java.util.concurrent.TimeUnit;

import org.apache.xalan.xsltc.compiler.sym;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class iFrame_ExpliciWait extends CommonBase {

	@BeforeMethod
	public void openPage() {
		Object driver = initChromeDriver("https://codestar.vn/");

	}

	@Test
	public void handleIFrame() {
		System.out.println("iframe total:" + driver.findElement(By.tagName("iframe")).size());
		scrollToElement(By.xpath("//h2[contains(text(),'Đội ngũ giảng viên')]"));
		driver.switchTo().frame(1);
		type(By.id("account_phone"), "09898548546");
		click(By.xpath("//button[text()='Gửi ngay']"));
	}

@Test
public void findIFrame() {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	int size = driver.findElement(By.tagName("iframe")).size();
	System.out.println("số lượng frame" + size);
	for (int i=0 ; i<size; i++) {
		driver.switchTo().frame(i);
		int numberOfIFrame = driver.findElement(By.xpath("//button[text()='Gửi ngay']").size();
		System.out.println("elementCanTim ở vị trí:" + numberOfIFrame);
		///sau khi in ra element cần tìm phải trở về frame cha để tìm tiếp đến hết 
		driver.switchTo().defaultContent();
		
		
	}
}
}
