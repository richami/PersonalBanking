package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pages.DeleteCustomerPage;
import pages.EditCustomerPage;
import pages.HomePage;
import pages.LandingPage;


public class VerifyDeleteCustomer extends base {
	WebDriver driver;
	LandingPage lp;
	HomePage hp;
	EditCustomerPage e;
	DeleteCustomerPage dc;
	@Test
	public void validateDeleteCustomer() throws IOException
	{
		driver=initialiseDriver();
		log.debug("browser opened");
		lp=new LandingPage(driver);
		lp.doLogin("mngr234086", "YzYqumE");
		log.debug("successfully logged in");

		hp=new HomePage(driver);
		hp.deleteCustomer();
		dc=new DeleteCustomerPage(driver);
		dc.enterCustId("64962");
		try
		{
			dc.handleAlert();
		}
		catch(Exception e)
		{
		System.out.println("no alert present");
		}
	}
	@AfterTest
	public void teardown()
	{
		driver.quit();
		driver=null;
	}
}
