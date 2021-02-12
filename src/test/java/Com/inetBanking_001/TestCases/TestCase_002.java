package Com.inetBanking_001.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.inetBanking_001.ObjectPages.BaseClass;
import Com.inetBanking_001.ObjectPages.LoginPage;
import Com.inetBanking_001.Utilities.XLUtils;

public class TestCase_002 extends BaseClass {

	@Test(dataProvider = "loginData")
	public void loginDD(String user, String Pswd) throws InterruptedException {

		LoginPage tc = new LoginPage(driver);
		tc.UserId(user);
		tc.Password(Pswd);
		tc.BottonClick();
		Thread.sleep(3000);

		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failled");
		} else {
			Assert.assertTrue(true);
			Thread.sleep(1000);
			tc.CustomerClick();
			
			tc.LogoutClick();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.warn("login passed");
		}
	}

	public Boolean isAlertPresent() {
		try {
			driver.switchTo().alert();

			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	@DataProvider(name = "loginData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir")
				+ "\\src\\test\\java\\Com\\inetBanking_001\\TestData\\TestData.xlsx";
		//D:\Hybride_Framework\inetBanking_001\src\test\java\Com\inetBanking_001\TestData\TestData.xlsx
		int RowCount = XLUtils.getRowCount(path, "Sheet1");
		int colCount = XLUtils.getCellCount(path, "Sheet1", 1);
		String loginData[][] = new String[RowCount][colCount];
		System.out.println(RowCount+ " "+colCount);
		for(int i=1;i<=RowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				loginData[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
		return loginData;
	}

}


