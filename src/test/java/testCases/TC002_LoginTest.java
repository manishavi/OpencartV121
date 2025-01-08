package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups={"Sanity", "Master"})
	public void verify_login() {
		logger.info("************ Starting TC002_LoginTest ***********");
		
		try {
			//HomPage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount Link");
			hp.clickLogin();
			logger.info("Clicked on Login Link");
			
			//LoginPage
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			logger.info("Entered email");
			lp.setPassword(p.getProperty("password"));
			logger.info("Entered password");
			lp.clickLogin();
			
			//MyAccountPage
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExists();
			
			if(targetPage) {
				System.out.println("Succesfully logged in to MyAccount page!");
			} else {
				System.out.println("Not logged in to MyAccount page!");
			}
			
	//		Assert.assertEquals(targetPage, true, "Login failed!");
			
			Assert.assertTrue(targetPage);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
		
		logger.info("************ Finished TC002_LoginTest ***********");
	}

}
