package Com.inetBanking_001.ObjectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass{

	WebDriver Ldriver;
	public LoginPage(WebDriver Rdriver)
	{
		Ldriver=Rdriver;
		PageFactory.initElements(Rdriver, this);
	}
	
	@FindBy(name="uid")
	WebElement UserText;
	@FindBy(name="password")
	WebElement pswdText;
	@FindBy(name="btnLogin")
	WebElement btnText;
	@FindBy(xpath="/html/body/div[3]/div/ul/li[10]/a")
	WebElement logout;
	@FindBy(xpath="/html/body/div[3]/div/ul/li[2]/a")
	WebElement NewCoustomer;
	
	 // 
	public void UserId(String UName)
	{
		UserText.sendKeys(UName);
	}
	public void Password(String Pswd)
	{
		pswdText.sendKeys(Pswd);
	}
	public void BottonClick()
	{
		btnText.click();
	}
	
	public void LogoutClick()
	{
		logout.click();
	}
	public void CustomerClick()
	{
		NewCoustomer.click();
	}
}
