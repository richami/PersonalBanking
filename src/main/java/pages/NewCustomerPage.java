package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {
	WebDriver driver;
	public NewCustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="name")
	WebElement name;

	@FindBy(xpath="//input[@value='f']")
	WebElement gender;


	@FindBy(name="dob")
	WebElement dob;

	@FindBy(name="addr")
	WebElement address;

	@FindBy(name="city")
	WebElement city;

	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="pinno")
	WebElement pinno;
	
	@FindBy(name="telephoneno")
	WebElement mobileno;
	
	@FindBy(name="emailid")
	WebElement emailid;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="sub")
	WebElement subBtn;
	
	@FindBy(name="res")
	WebElement resetBtn;
	
	@FindBy(xpath="//p[@class='heading3']")
	WebElement msg;
	
	public void clickSubmitBtn()
	{
		subBtn.click();
	}
	public void clickResetBtn()
	{
		resetBtn.click();
	}
	public void inputDetails(String n,String d,String a, String c, String s,String pin,String mobile,String email,String pwd)
	{
		gender.click();
		name.sendKeys(n);
		dob.sendKeys(d);
		address.sendKeys(a);
		city.sendKeys(c);
		state.sendKeys(s);
		pinno.sendKeys(pin);
		mobileno.sendKeys(mobile);
		emailid.sendKeys(email);
		password.sendKeys(pwd);
		
	}
	public String getMsg()
	{
		return msg.getText();
	}
	public String handleAlert() {
		// TODO Auto-generated method stub
		Alert a=driver.switchTo().alert();
		String text=a.getText();
		a.accept();
		return text;
		
	}
	
	

}
