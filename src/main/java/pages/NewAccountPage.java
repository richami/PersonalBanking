package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage {
	WebDriver driver;
	public NewAccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="cusid")
	WebElement custid;

	@FindBy(name="selaccount")
	WebElement selectAcc;

	@FindBy(name="inideposit")
	WebElement iniDepositAmt;

	@FindBy(name="button2")
	WebElement subBtn;

	@FindBy(name="reset")
	WebElement resetBtn;
	
	@FindBy(xpath="//p[@class='heading3']")
	WebElement alert;
	
	public void clickSubmitBtn()
	{
		subBtn.click();
	}
	public void clickResetBtn()
	{
		resetBtn.click();
	}
	public void inputDetails(String cusid,String amt)
	{
		custid.sendKeys(cusid);
		Select s=new Select(selectAcc);
		s.selectByIndex(0);
		iniDepositAmt.sendKeys(amt);	
	}
	public String getMsg() {
		// TODO Auto-generated method stub
		return alert.getText();
	}
	
	public String handleAlert() {
		// TODO Auto-generated method stub
		Alert a=driver.switchTo().alert();
		String text=a.getText();
		a.accept();
		return text;
	}
	
	

}
