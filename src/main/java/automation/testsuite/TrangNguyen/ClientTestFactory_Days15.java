package automation.testsuite.TrangNguyen;

import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.pageLocatorTrangNTH.PageClient;
import automation.common.CommonBase;
import automation.constant.CT_Account;
import automation.pageLocatorTrangNTH.DashboardPage;
import automation.pageLocatorTrangNTH.LoginPage_days14;

public class ClientTestFactory_Days15 extends CommonBase {
	WebDriver driver;
	@BeforeTest
	public void openSystemUnderTest() {
		driver = initDriverTest(CT_Account.webURL);
	}

	@Test
	public void AddClient_SS() {
		driver = initDriverTest(CT_Account.webURL);
		//thuc hien login
		LoginPage_days14 Login_page = new LoginPage_days14(driver);
		Login_page.LoginFunction("admin@demo.com", "riseDemo");
		//hien thi man hinh dashboard
		DashboardPage dashboard = new DashboardPage(driver);
		assertTrue(dashboard.textDashboard.isDisplayed());
		//vao man hinh client va add client
		PageClient clientpage = new PageClient(driver);
		clientpage.AddClient("demo01@demo.com", "mee");
		quitDriver(driver);
	}
	@Test
	public void AddClient_USS() {
		driver = initDriverTest(CT_Account.webURL);
		//thuc hien login
		LoginPage_days14 Login_page = new LoginPage_days14(driver);
		Login_page.LoginFunction("admin@demo.com", "riseDemo");
		//hien thi man hinh dashboard
		DashboardPage dashboard = new DashboardPage(driver);
		assertTrue(dashboard.textDashboard.isDisplayed());
		//vao man hinh client va add client
		PageClient clientpage = new PageClient(driver);
		clientpage.AddClient("", "mee");
		quitDriver(driver);
	}
//	@AfterTest
//	public void closeChromeBrower() {
//		quitDriver(driver);
//	}
}
