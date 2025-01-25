package Utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class BasicActivity{
	public WebDriverWait wait;
	public AndroidDriver driver;
	
	public BasicActivity(AndroidDriver driver) {
		this.driver= driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	// Wait for an element to be visible
    public WebElement waitForElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Wait for an element to be clickable
    public WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Wait for an element to be present in the DOM
    public WebElement waitForElementToBePresent(WebElement element) {
        return wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
    }


}
