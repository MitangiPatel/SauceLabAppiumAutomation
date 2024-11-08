package appiumautomation;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import PageObject.webViewPageObject;
import Utils.BaseTest;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class webView extends BaseTest {
	
	@Test
	public void webviewTest() throws InterruptedException
	{
		webViewPageObject webview = new webViewPageObject(driver);
		appLogin();
		
		webview.clickOnMenu();
		webview.clickOnWebview();
		webview.enterURL("www.google.com");
		webview.clickOnGoToSite();
		
		Thread.sleep(5000);
		Set<String> contexts = driver.getContextHandles();
		for(String contextName:contexts)
		{
			System.out.println(contextName);
		}
		
		driver.context("WEBVIEW_com.swaglabsmobileapp");
		driver.findElement(By.name("q")).sendKeys("Appium");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		Thread.sleep(5000);
	
	}

}
