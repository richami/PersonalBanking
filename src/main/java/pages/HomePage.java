package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='New Customer']")
	WebElement newCustLink;
	@FindBy(xpath="")
	WebElement screentext;
	@FindBy(xpath="//a[text()='Edit Customer']")
	WebElement editCustomerlink;
	@FindBy(xpath="//a[text()='New Account']")
	WebElement newAccountlink;
	@FindBy(xpath="//a[text()='Delete Customer']")
	WebElement deleteCustLink;
	
	public void clickNewCustomer()
	{
		newCustLink.click();
	}
	public void clickEditCustomer()
	{
		editCustomerlink.click();
	}
	public void clickNewAccount()
	{
		newAccountlink.click();
	}
	public void deleteCustomer()
	{
		deleteCustLink.click();
	}

}
