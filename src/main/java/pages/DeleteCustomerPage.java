package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {
	public WebDriver driver;
	public DeleteCustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="cusid")
	WebElement custid;
	@FindBy(name="AccSubmit")
	WebElement subBtn;
	
	
	public void enterCustId(String id)
	{
		custid.sendKeys(id);
		subBtn.click();
	}
	public void handleAlert()
	{
		Alert a=driver.switchTo().alert();
		System.out.println(a.getText());
		a.accept();
		Alert a1=driver.switchTo().alert();
		System.out.println(a1.getText());
		a1.accept();
	}
	

}
