package testcases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LandingPage;
import testcases.ExcelConfig;


public class VerifyLogin extends base {
	WebDriver driver;
	LandingPage lp;
	
	@Test(dataProvider="Details")
	public void verifyLogin(String u,String p) throws IOException
	{
		driver=initialiseDriver();
		log.debug("browser opend");
		lp=new LandingPage(driver);
		lp.doLogin(u,p);
		log.debug("trying to logged in");
		try {
			@SuppressWarnings("deprecation")
			WebDriverWait wait = new WebDriverWait(driver, 2);
	        wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = driver.switchTo().alert();
	        System.out.println(alert.getText());
	        alert.accept();
	    } catch (Exception e) {
	    }
		String expected="Welcome To Manager's Page of Guru99 Bank";
		String actual=lp.getTitle();
		Assert.assertEquals(actual, expected);
	}
	
	@DataProvider(name="Details")
	public Object[][] passData()
	{
		ExcelConfig config=new ExcelConfig("C:\\work\\BankingLogin.xlsx");
		int rowcount=config.getRowCount(0);
		Object data[][]=new Object[rowcount][2];
		for(int i=0;i<rowcount;i++)
		{
			data[i][0]=config.getData(0, i, 0);
			data[i][1]=config.getData(0, i, 1);
		}
		return data;
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
		driver=null;
	}

}
