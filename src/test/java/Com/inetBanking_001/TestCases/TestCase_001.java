package Com.inetBanking_001.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.inetBanking_001.ObjectPages.BaseClass;
import Com.inetBanking_001.ObjectPages.LoginPage;

public class TestCase_001 extends BaseClass{

	@Test
	public void LoginTest() throws IOException
	{
		driver.get(baseUrl);
		logger.info("url open");
		LoginPage lgn = new LoginPage(driver);
		lgn.UserId(User_ID);
		lgn.Password(Password);
		lgn.BottonClick();
		logger.info("login suceess");
		 System.out.println(driver.getTitle());
		 
		if(driver.getTitle().equalsIgnoreCase("GTPL Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Title correct");
		}
		else
			captureScreen(driver,"LoginTest");
		Assert.assertTrue(false);
		logger.info("Login test failed");
			
	}

	
	
}
