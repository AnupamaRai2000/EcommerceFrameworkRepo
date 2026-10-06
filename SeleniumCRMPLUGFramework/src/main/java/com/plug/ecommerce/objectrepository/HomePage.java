package com.plug.ecommerce.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {



	@FindBy(xpath = "(//summary[@aria-label='Search' and @role='button'])[2]")
	private WebElement searchIcon;

	@FindBy(id = "Search-In-Modal")
	private WebElement searchTextField;

	@FindBy(xpath = "//*[name()='svg'][.//*[name()='path' and contains(@d,'M4.49547 10.7487')]]/ancestor::a[1]")
	private WebElement heartIcon;

	@FindBy(xpath = "HeaderMenu-sale")
	private WebElement saleLink;

	@FindBy(xpath = "//span[text()='Sell']")
	private WebElement sellLink;

	@FindBy(xpath = "//*[name()='svg' and contains(@class,'icon-cart-empty')]/ancestor::a[1]")
	private WebElement cartIcon;

	@FindBy(xpath = "//account-icon/span[@class='svg-wrapper']")
	private WebElement accountIcon;

	@FindBy(id = "HeaderMenu-iphone")
	private WebElement iPhoneLink;

	@FindBy(xpath = "//span[normalize-space()='Android']")
	private WebElement androidLink;

	@FindBy(id = "HeaderMenu-ipad")
	private WebElement iPadLink;

	@FindBy(xpath = "//span[@class='header__active-menu-item' and normalize-space()='MacBook']")
	private WebElement macBookLink;

	@FindBy(id = "HeaderMenu-watches")
	private WebElement watchesLink;

	@FindBy(id = "HeaderMenu-audio")
	private WebElement audioLink;

	@FindBy(xpath = "//summary[@id='HeaderMenu-accessories']/span[normalize-space()='Accessories']")
	private WebElement accessoriesLink;

	

	public HomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	

	/**
	 * Search for a product.
	 */
	public void searchProduct(String productName) {

		searchIcon.click();

		searchTextField.sendKeys(productName);

		searchTextField.submit();
	}

	/**
	 * Click Search icon.
	 */
	public void clickSearch() {

		searchIcon.click();
	}

	/**
	 * Click Heart icon.
	 */
	public void clickHeart() {

		heartIcon.click();
	}

	/**
	 * Navigate to Sale section.
	 */
	public void clickSale() {

		saleLink.click();
	}

	/**
	 * Navigate to Sell section.
	 */
	public void clickSell() {

		sellLink.click();
	}

	/**
	 * Navigate to Cart.
	 */
	public void clickCart() {

		cartIcon.click();
	}

	/**
	 * Navigate to Account/Login.
	 */
	public void clickAccount() {

		accountIcon.click();
	}

	/**
	 * Navigate to iPhone category.
	 */
	public void clickiPhone() {

		iPhoneLink.click();
	}

	/**
	 * Navigate to Android category.
	 */
	public void clickAndroid() {

		androidLink.click();
	}

	/**
	 * Navigate to iPad category.
	 */
	public void clickiPad() {

		iPadLink.click();
	}

	/**
	 * Navigate to MacBook category.
	 */
	public void clickMacBook() {

		macBookLink.click();
	}

	/**
	 * Navigate to Watches category.
	 */
	public void clickWatches() {

		watchesLink.click();
	}

	/**
	 * Navigate to Audio category.
	 */
	public void clickAudio() {

		audioLink.click();
	}

	/**
	 * Navigate to Accessories category.
	 */
	public void clickAccessories() {

		accessoriesLink.click();
	}

	/**
	 * Verify Home Page is displayed.
	 */
	public boolean isHomePageDisplayed() {

		return searchIcon.isDisplayed();
	}
}
