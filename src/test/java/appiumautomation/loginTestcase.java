package appiumautomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.LoginPagePageObject;

import Utils.BaseTest;

public class loginTestcase extends BaseTest {
	LoginPagePageObject loginPagePageObject;

	@Test
	public void loginIntoApp() throws InterruptedException {

		loginPagePageObject = new LoginPagePageObject(driver);

		// Enter Name
		loginPagePageObject.clickOnTextBox();
		loginPagePageObject.enterName(prop.getProperty("DeploymetName"));
		loginPagePageObject.clickOnNextButton();
		// Enter Email
		Thread.sleep(3000);
		loginPagePageObject.clickOnTextBox();
		loginPagePageObject.enterEmail(prop.getProperty("Email"));
		loginPagePageObject.clickOnNextButton();
		Thread.sleep(3000);
		// Enter Password
		loginPagePageObject.clickOnTextBox();
		loginPagePageObject.enterPassword(prop.getProperty("Password"));
		loginPagePageObject.clickOnSignInButton();
		// Verify Text on MainScreen
		Thread.sleep(5000);
		String toolText = loginPagePageObject.verifyText();
		Assert.assertEquals("Tools", toolText);

	}

}
