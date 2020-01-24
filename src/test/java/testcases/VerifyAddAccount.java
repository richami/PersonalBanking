package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pages.EditCustomerPage;
import pages.HomePage;
import pages.LandingPage;
import pages.NewAccountPage;


public class VerifyAddAccount extends base {
	WebDriver driver;
	LandingPage lp;
	HomePage hp;
	NewAccountPage na;
	@Test
	public void validateAddAccount() throws IOException
	{
		driver=initialiseDriver();
		log.debug("browser opened");
		lp=new LandingPage(driver);
		lp.doLogin("mngr234086", "YzYqumE");
		log.debug("successfully logged in");
		hp=new HomePage(driver);
		hp.clickNewAccount();
		na=new NewAccountPage(driver);
		na.inputDetails("64536", "500");
		na.clickSubmitBtn();
		
		try
		{
			String text=na.handleAlert();
			System.out.println("Alert msg "+text);
		}
		catch(Exception e)
		{
			System.out.println("no alert present");
			log.debug("Account Generated Successfully!!!");
			String expected="Account Generated Successfully!!!";
			String actual=na.getMsg();
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
