package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pages.EditCustomerPage;
import pages.HomePage;
import pages.LandingPage;


public class VerifyEditCustomer extends base {
	WebDriver driver;
	LandingPage lp;
	HomePage hp;
	EditCustomerPage e;
	@Test
	public void validateEditCustomer() throws IOException
	{
		driver=initialiseDriver();
		log.info("browser opened");
		lp=new LandingPage(driver);
		lp.doLogin("mngr234086", "YzYqumE");
		log.debug("logged in");
		hp=new HomePage(driver);
		hp.clickEditCustomer();
		e=new EditCustomerPage(driver);
		e.enterCustId("64536");
		e.editState("US");
		String actual=e.getTitle();
		String expected="Customer details updated Successfully!!!";
		Assert.assertEquals(actual, expected);
	}
	@AfterTest
	public void teardown()
	{
		driver.quit();
		driver=null;
	}
}
