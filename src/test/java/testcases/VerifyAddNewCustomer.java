package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LandingPage;
import pages.NewCustomerPage;

public class VerifyAddNewCustomer extends base {
	WebDriver driver;
	HomePage hp;
	LandingPage lp;
	NewCustomerPage nc;
	
	@Test
	public void verifyAddCustomer() throws IOException
	{
		driver=initialiseDriver();
		lp=new LandingPage(driver);
		lp.doLogin("mngr234086", "YzYqumE");
		hp=new HomePage(driver);
		hp.clickNewCustomer();
		nc=new NewCustomerPage(driver);
		nc.inputDetails("Richa Bist", "30101990", "7 Virtues Avenue", "Brampton", "Ontario", "248001", "8755666010", "trinah.mi@rediffmail.com", "1234");
		nc.clickSubmitBtn();
		try
		{
			
			String msg=nc.handleAlert();
			System.out.println("Customer already exits "+msg);
		}
		catch(Exception e)
		{
			System.out.println("no alert present");
		String expected="Customer Registered Successfully!!!";
		String actual=nc.getMsg();
		Assert.assertEquals(actual, expected);
		}
	}
	@AfterTest
	public void teardown()
	{
		driver.quit();
		driver=null;
	}
}
