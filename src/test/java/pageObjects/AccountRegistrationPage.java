package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	

	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkdPolicy;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstName(String fname){
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname){
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email){
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String pwd){
		txtPassword.sendKeys(pwd);
	}
	
	public void setPrivacyPolicy() {
//		chkdPolicy.click();
		Actions act=new Actions (driver);
		act.moveToElement(chkdPolicy).click().build().perform();
	}
	
	public void clickContinue() {
//		btnContinue.click(); //so11
		//so12
//		btnContinue.submit();
		// sol3
		Actions act=new Actions (driver);
		act.moveToElement(btnContinue).click().build().perform();
		// so14
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].scrollIntoView();", btnContinue);
////		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
//		js. executeScript("arguments[0].click();", btnContinue);
		//Sol 5
		//btnContinue. sendKeys(Keys.RETURN) ;
		//So16
//		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
	}
	
	public String getConfirmationMsg() {
		try {
			return msgConfirmation.getText();
		} catch(Exception e) {
			return e.getMessage();
		}
	}

}
