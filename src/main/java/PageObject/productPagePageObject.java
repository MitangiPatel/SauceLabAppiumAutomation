package PageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class productPagePageObject {

	AndroidDriver driver;

	public productPagePageObject(AndroidDriver driver) {
		// super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "test-Modal Selector Button")
	private WebElement filterButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Name (A to Z)']")
	private WebElement atoZFilter;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Name (Z to A)']")
	private WebElement ztoAFilter;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Price (low to high)']")
	private WebElement lowToHighFilter;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Price (high to low)']")
	private WebElement highTolowFilter;

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title']")
	private List<WebElement> listOfProducts;

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='test-Price']")
	private List<WebElement> listOfPrices;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
	private WebElement addToCartProduct;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.TextView")
	private WebElement numberofCartItem;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-REMOVE']")
	private WebElement removeButton;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']")
	private WebElement emptyCart;

	public void clickOnFilter() {
		filterButton.click();
	}

	public void clickOnAtoZFilter() {
		atoZFilter.click();
	}

	public void clickOnZtoAFilter() {
		ztoAFilter.click();
	}

	public void clickOnLowtoHighFilter() {
		lowToHighFilter.click();
	}

	public void clickOnHightoLowFilter() {
		highTolowFilter.click();
	}

	public String selectProduct() {
		return listOfProducts.get(0).getText();
	}

	public String selectPrices() {
		return listOfPrices.get(0).getText();
	}

	public void clickOnAddToCart() {
		addToCartProduct.click();
	}

	public String countOfCartItem() {
		return numberofCartItem.getText();
	}

	public void clickOnRemove() {
		removeButton.click();
	}

	public String emptyCart() {
		return emptyCart.getText();
	}

}
