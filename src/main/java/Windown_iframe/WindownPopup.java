package Windown_iframe;
 
import static org.testng.AssertJUnit.assertEquals;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import jxl.common.Assert;

public class WindownPopup extends CommonBase {
	@BeforeMethod

	public void openBrowser() {
		driver = initChromeDriver("https://demo.guru99.com/popup.php");
	}

	// <a href="../articles_popup.php" target="_blank" style="font-size:16px;"
	// xpath="1">Click Here</a>
	@Test
	public void TestPopupWindown() {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		// driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		click(By.xpath("//a[contains(text(),'Click Here')]"));
		// Lưu lại lớp windown đầu tiên
		String mainWindown = driver.getWindowHandle();
		// lấy ra tất cả các tab windown đnag open bằng hàm getWindownHandles;
		// Set là một collection để lưu các phần tử giá trị KO trùng lặp
		Set<String> windowns = driver.getWindowHandles();
		// các duyệt từng phần tử không trùng lặp trong collection (set) ta dùng ForEach
		for (String windown : windowns) {
			System.out.println(windown);
			if (!mainWindown.equals(windown)) {
				// so sánh nếu windown nào khác windown chính (Đầu tiên) thì chuyển qua để thao
				// tác
				driver.switchTo().window(windown);
				pause(2000);
				System.out.println("Đã chuyển đến lớp Windown con");
				// Một số hàm hỗ trợ
				System.out.println("Title:" + driver.switchTo().window(windown).getTitle());
				System.out.println("CurrentUrl:" + driver.switchTo().window(windown).getCurrentUrl());
				// driver.findElement(By.name("emailid")).sendKeys("Te@mailinator.com");
				// có thể dùng type
				type(By.name("emailid"), "Te@mailinator.com");
				// driver.findElement(By.name("btnLogin")).click();
				// có thể dùng click luôn
				click(By.name("btnLogin"));
				// Get text trang sau khi submit
				// System.out.println(driver.findElement(By.xpath("//table//td//h2")).getText());
				// có thể dùng string text như sau
				String Text = driver.findElement(By.xpath("//table//td//h2")).getText();
				System.out.println(Text);
				Assert.assertEquals(Text, "Access detail to demo site");
				// Closeing the child windown
				driver.close();

			}
		}
		// Switching to parent wintdown( mainWindown)
		driver.switchTo().window(mainWindown);
		driver.close();
	}

}
