package appiumautomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.productPagePageObject;
import Utils.BaseTest;


public class productPage extends BaseTest{

	productPagePageObject productpage;

	@Test(priority = 1)
	public void applyFilterNameAtoZ() throws InterruptedException {
		
		appLogin();
		productpage = new productPagePageObject(driver);
		productpage.clickOnFilter();
		productpage.clickOnAtoZFilter();
		Assert.assertEquals(productpage.selectProduct(), prop.getProperty("AtoZFirstProduct"));
	}

	@Test(priority = 2)
	public void applyFilterNameZtoA() throws InterruptedException {

		productpage = new productPagePageObject(driver);
		productpage.clickOnFilter();
		productpage.clickOnZtoAFilter();
		Assert.assertEquals(productpage.selectProduct(), prop.getProperty("ZtoAFirstProduct"));

	}

	@Test(priority = 3)
	public void applyFilterPriceLowToHigh() throws InterruptedException {

		productpage = new productPagePageObject(driver);
		productpage.clickOnFilter();
		productpage.clickOnLowtoHighFilter();
		Assert.assertEquals(productpage.selectPrices(), prop.getProperty("lowPrice"));

	}

	@Test(priority = 4)
	public void applyFilterPriceHighToLow() throws InterruptedException {

		productpage = new productPagePageObject(driver);
		productpage.clickOnFilter();
		productpage.clickOnHightoLowFilter();
		Assert.assertEquals(productpage.selectPrices(), prop.getProperty("HighPrice"));
	}

	@Test(priority = 5)
	public void addAndRemoveItem() throws InterruptedException {
		
		//appLogin();
		productpage = new productPagePageObject(driver);
		productpage.clickOnAddToCart();
		productpage.clickOnAddToCart();
		
		String cartItem = productpage.countOfCartItem();
		Assert.assertEquals(cartItem, "2");
		productpage.clickOnRemove();
		String cartItem1 = productpage.countOfCartItem();
		Assert.assertEquals(cartItem1, "1");
		productpage.clickOnRemove();
		String cartEmpty = productpage.emptyCart();
		Assert.assertEquals(cartEmpty, "");


	}

}
