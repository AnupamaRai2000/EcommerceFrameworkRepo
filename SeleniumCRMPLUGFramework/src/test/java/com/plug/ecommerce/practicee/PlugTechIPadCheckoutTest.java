package com.plug.ecommerce.practicee;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class PlugTechIPadCheckoutTest extends BaseClass {

	@Test
	public void verifyIPadCheckoutTillPayment() {

		/* STEP 1: CREATE HOMEPAGE OBJECT
		 */

		HomePage hp = new HomePage(driver);

		/* STEP 2: SEARCH FOR iPAD PRO
		 */

		hp.searchProduct(
				"iPad Pro 12.9"
		);

		System.out.println(
				"iPad Pro 12.9 search completed"
		);

		/* STEP 3: OPEN THE REQUIRED PRODUCT
		 */

		driver.findElement(
				By.xpath(
						"(//*[contains(normalize-space(.),'iPad Pro 12.9')]/ancestor::a[1])[1]"
				)
		).click();

		System.out.println(
				"iPad Pro product page opened successfully"
		);

		/* STEP 4: ADD PRODUCT TO CART
		 */

		driver.findElement(
				By.xpath(
						"//form[@method=\"post\" and @action=\"/cart/add\"]/div[@class=\"product-form__buttons\"]/button[@id=\"ProductSubmitButton-template--22868106444953__pf_product_scroll_cwLmf9\"]"
				)
		).click();

		System.out.println(
				"iPad Pro added to Cart successfully"
		);

		/* STEP 5: OPEN CART
		 */

		hp.clickCart();

		System.out.println(
				"Cart page opened successfully"
		);

		/* STEP 6: VERIFY PRODUCT IS RETAINED IN CART
		 */

		String cartPage =
				driver.getPageSource();

		Assert.assertTrue(
				cartPage.contains("iPad Pro")
						|| cartPage.contains("12.9"),
				"iPad Pro product is not displayed in the Cart"
		);

		System.out.println(
				"iPad Pro product is retained in Cart"
		);

		/* STEP 7: CLICK CHECKOUT
		 */

		driver.findElement(
				By.xpath(
						"//button[normalize-space()='Checkout'] | //input[@value='Checkout']"
				)
		).click();

		System.out.println(
				"Checkout page opened successfully"
		);

		/* STEP 8: ENTER CUSTOMER INFORMATION
		 */

		driver.findElement(
				By.id("email")
		).sendKeys(
				"testuser@example.com"
		);

		// First Name
		driver.findElement(
				By.id("TextField0")
		).sendKeys(
				"Barbara"
		);

		// Last Name
		driver.findElement(
				By.id("TextField1")
		).sendKeys(
				"Test"
		);

		/* STEP 9: ENTER SHIPPING ADDRESS
		 */

		// Address
		driver.findElement(
				By.id("TextField2")
		).sendKeys(
				"445 Albee Square West"
		);

		// City
		driver.findElement(
				By.id("TextField3")
		).sendKeys(
				"Brooklyn"
		);

		// ZIP Code
		driver.findElement(
				By.id("TextField4")
		).sendKeys(
				"11201"
		);

		// Phone
		driver.findElement(
				By.id("TextField5")
		).sendKeys(
				"7185550123"
		);

		System.out.println(
				"Valid customer and shipping information entered"
		);

		/* STEP 10: CONTINUE TO SHIPPING
		 */

		driver.findElement(
				By.xpath(
						"//button[contains(normalize-space(.),'Continue to shipping')]"
				)
		).click();

		System.out.println(
				"Shipping step completed"
		);

		/* STEP 11: CONTINUE TO PAYMENT
		 */

		driver.findElement(
				By.xpath(
						"//button[contains(normalize-space(.),'Continue to payment')]"
				)
		).click();

		System.out.println(
				"Payment section opened"
		);

		/* STEP 12: VERIFY PAYMENT SECTION
		 */

		String paymentPage =
				driver.getPageSource().toLowerCase();

		boolean paymentDisplayed =
				paymentPage.contains("payment")
				|| paymentPage.contains("payment method")
				|| paymentPage.contains("billing address");

		Assert.assertTrue(
				paymentDisplayed,
				"Payment section is not displayed"
		);

		System.out.println(
				"Payment section is displayed successfully"
		);
	}
}
