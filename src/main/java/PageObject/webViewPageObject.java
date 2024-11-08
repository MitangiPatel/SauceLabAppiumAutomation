package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class webViewPageObject {

	AndroidDriver driver;

	public webViewPageObject(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(accessibility = "test-Menu")
	private WebElement menu;

	@AndroidFindBy(accessibility = "test-WEBVIEW")
	private WebElement webviewMenu;

	@AndroidFindBy(accessibility = "test-enter a https url here...")
	private WebElement enterURLtext;

	@AndroidFindBy(accessibility = "test-GO TO SITE")
	private WebElement goToSiteButton;

	public void clickOnMenu() {
		menu.click();
	}

	public void clickOnWebview() {
		webviewMenu.click();
	}

	public void enterURL(String url) {
		enterURLtext.sendKeys(url);
		;
	}

	public void clickOnGoToSite() {
		goToSiteButton.click();
	}
}
