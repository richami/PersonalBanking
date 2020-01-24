package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='uid']")
	WebElement userid;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement loginBtn;
	
	@FindBy(xpath="//table[@align='center']/tbody/tr[2]")
	WebElement title;
	
	public void doLogin(String u,String pwd)
	{
		userid.sendKeys(u);
		password.sendKeys(pwd);
		loginBtn.click();
	}
	public String getTitle()
	{
		return title.getText();
	}

}
