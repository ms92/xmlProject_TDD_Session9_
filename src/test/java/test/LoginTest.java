package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;


public class LoginTest {
	WebDriver driver;
	
	//ReadExcel exlread = new ReadExcel("src\\main\\java\\data\\TestData.xlsx");
	/*
	 * String userName ;
	 *  String passWord ;
	 */
	
	@Test
	@Parameters({"userName", "passWord"})
	
	public void validUserShouldBeAbleToLogin(String username, String password) {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		loginPage.clickSigninButton();
		
		DashboardPage dashboarPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboarPage.varifyDashboarPage();
		
		BrowserFactory.tearDown();
	
	}
	
}
