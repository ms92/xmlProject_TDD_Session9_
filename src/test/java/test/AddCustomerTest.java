package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;


public class AddCustomerTest {
	
	WebDriver driver;
	
	//ReadExcel exlread = new ReadExcel("src\\main\\java\\data\\TestData.xlsx");
	
	@Test
	@Parameters({"userName", "passWord", "FullName", "CompanyName", "Email", "Phone", "Address", "City", "Country", "State", "Zip"})
	public void validUserShouldBeAbleToAddCustomer(String username, String password, String fullname, String companyname, String email, String phone, String address, String city, String country, String state, String zip) {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		loginPage.clickSigninButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.varifyDashboarPage();
		dashboardPage.clickCustomerButton();
		dashboardPage.clickAddCustomerButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.enterFullName(fullname);
		addCustomerPage.enterCompanyName(companyname);
		addCustomerPage.enterEmail(email);
		addCustomerPage.enterPhone(phone);
		addCustomerPage.enterAddress(address);
		addCustomerPage.enterCity(city);
		addCustomerPage.enterState(state);
		addCustomerPage.enterZip(zip);
		addCustomerPage.enterCountry(country);
		addCustomerPage.clickSaveButtonOnAddCustomerPage();
		
		dashboardPage.clickListCustomersButton();
		
		addCustomerPage.enterSearchBarOnListCustomer();
		addCustomerPage.verifySearchBar();
		
		//addCustomerPage.clickAddCustomerOnListCustomer();
		
		
		BrowserFactory.tearDown();
	
}
}
