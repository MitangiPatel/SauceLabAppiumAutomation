package appiumautomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.loginPagePageObject;
import Utils.BaseTest;

public class loginPage extends BaseTest {

	loginPagePageObject loginpage;

	@Test(priority = 1)
	public void loginWithoutUsername() throws InterruptedException {
		loginpage = new loginPagePageObject(driver);
			loginpage.enterPassword(prop.getProperty("Password"));
			loginpage.clickLoginButton();
			log.info("Required username error message is displayed");
			String errorMessage = loginpage.usernameErrorMessage();
			Assert.assertEquals(errorMessage, prop.getProperty("requiredUsername"));
			log.info("Displayed message is correct");
	}

	@Test(priority = 2)
	public void loginWithoutPassword() throws InterruptedException {
		loginpage = new loginPagePageObject(driver);
			loginpage.clearPassword();
			loginpage.enterUsername(prop.getProperty("Username"));
			loginpage.clickLoginButton();
			log.info("Required password error message is displayed");
			String errorMessage = loginpage.passwordErrorMessage();
			Assert.assertEquals(errorMessage, prop.getProperty("requiredPassword"));
			log.info("Displayed message is correct");
	}

	@Test(priority = 3)
	public void loginWithIncorrectUsernameAndPassword() throws InterruptedException {
		loginpage = new loginPagePageObject(driver);
		loginpage.enterUsername(prop.getProperty("wrongUsername"));
		loginpage.enterPassword(prop.getProperty("wrongPassword"));
		loginpage.clickLoginButton();
		String errorMessage = loginpage.usernamePasswordErrorMessage();
		Assert.assertEquals(errorMessage, prop.getProperty("wrongUsernamePassword"));

	}

	@Test(priority = 4)
	public void loginWithCorrectUsernameAndPassword() throws InterruptedException {
		loginpage = new loginPagePageObject(driver);
		loginpage.enterUsername(prop.getProperty("Username"));
		loginpage.enterPassword(prop.getProperty("Password"));
		loginpage.clickLoginButton();
		String productText = loginpage.productPageText();
		Assert.assertEquals(productText, prop.getProperty("productPageTitle"));

	}

}
