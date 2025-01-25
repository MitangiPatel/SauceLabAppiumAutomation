package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.BasicActivity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPagePageObject {
	AndroidDriver driver;
	BasicActivity activity;

	public LoginPagePageObject(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		activity = new BasicActivity(driver);
	}

	@AndroidFindBy(xpath = "//android.widget.EditText")
	private WebElement editTextbox;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Next']")
	private WebElement nextButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Sign in']")
	private WebElement signInButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Tools']")
	private WebElement toolText;

	public void clickOnTextBox() {
		activity.waitForElementToBeClickable(editTextbox).click();
	}

	public void enterName(String name) {
		activity.waitForElementToBeVisible(editTextbox).sendKeys(name);
	}

	public void clickOnNextButton() {
		activity.waitForElementToBeClickable(nextButton).click();
	}

	public void enterEmail(String email) {
		activity.waitForElementToBeVisible(editTextbox).sendKeys(email);
	}

	public void enterPassword(String password) {
		activity.waitForElementToBeVisible(editTextbox).sendKeys(password);
	}

	public void clickOnSignInButton() {
		activity.waitForElementToBeClickable(signInButton).click();
	}

	public String verifyText() {
		String text = toolText.getText();
		return text;

	}
}
