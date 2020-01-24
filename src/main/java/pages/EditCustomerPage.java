package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
	public WebDriver driver;
	public EditCustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="cusid")
	WebElement custid;
	@FindBy(name="AccSubmit")
	WebElement subBtn;
	@FindBy(name="state")
	WebElement statetext;
	@FindBy(name="sub")
	WebElement editsubBtn;
	@FindBy(xpath="//p[@class='heading3']")
	WebElement title;
	
	public void enterCustId(String id)
	{
		custid.sendKeys(id);
		subBtn.click();
	}
	public void editState(String s)
	{
		statetext.sendKeys(s);
		editsubBtn.click();
	}
	public String getTitle()
	{
		return title.getText();
	}
	
	

}
