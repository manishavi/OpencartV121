package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	
	/*Data is valid - login success - test pass - logout
	Data is valid -- login failed - test fail
	Data is invalid - login success - test fail - logout
	Data is invalid -- login failed - test pass
	*/
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="Datadriven")
	public void verify_loginDDT(String email, String pwd, String exp)  {
		
		logger.info("************** Starting TC_003LoginDDT ******************");
		
		try {
		
			//HomPage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount Link");
			hp.clickLogin();
			logger.info("Clicked on Login Link");
			
			//LoginPage
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			logger.info("Entered email");
			lp.setPassword(pwd);
			logger.info("Entered password");
			lp.clickLogin();
			
			//MyAccountPage
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExists();
			
			if(exp.equalsIgnoreCase("Valid")) {
				if(targetPage == true) { //Data is valid - login success - test pass - logout
					macc.clickLogout();
					Assert.assertTrue(true);
				}
				else { //Data is valid -- login failed - test fail
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid")) {
				if(targetPage == true) { //Data is invalid - login success - test fail - logout
					macc.clickLogout();
					Assert.assertTrue(false);
				}
				else { //Data is invalid -- login failed - test pass
					Assert.assertTrue(true);
				}
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
			
		logger.info("************** Finished TC_003LoginDDT ******************");
	}
}
