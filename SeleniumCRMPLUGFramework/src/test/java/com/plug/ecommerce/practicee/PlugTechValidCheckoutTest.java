package com.plug.ecommerce.practicee;



import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class PlugTechValidCheckoutTest extends BaseClass {

	@Test
	public void verifyValidGuestCheckout() {

		/* STEP 1: CREATE HOMEPAGE OBJECT
		 */

		HomePage hp = new HomePage(driver);

		/* STEP 2: SEARCH FOR PRODUCT
		 */

		hp.searchProduct(
				"iPhone 17 Pro Silver 256GB"
		);

		System.out.println(
				"iPhone 17 Pro Silver 256GB search completed"
		);

		/* STEP 3: OPEN PRODUCT
		 */

		driver.findElement(
				By.xpath(
						"(//*[contains(normalize-space(.),'iPhone 17 Pro Silver 256GB')]/ancestor::a[1])[1]"
				)
		).click();

		System.out.println(
				"iPhone 17 Pro product page opened"
		);

		/* STEP 4: ADD PRODUCT TO CART
		 */

		driver.findElement(
				By.xpath(
						"//button[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'add to cart')]"
				)
		).click();

		System.out.println(
				"Product added to Cart successfully"
		);

		/* STEP 5: OPEN CART
		 */

		hp.clickCart();

		System.out.println(
				"Cart page opened successfully"
		);

		/* STEP 6: CLICK CHECKOUT
		 */

		driver.findElement(
				By.xpath(
						"//button[normalize-space()='Checkout'] | //input[@value='Checkout']"
				)
		).click();

		System.out.println(
				"Checkout page opened successfully"
		);

		/* STEP 7: ENTER VALID CUSTOMER DETAILS
		 */

		driver.findElement(
				By.id("email")
		).sendKeys(
				"testuser@example.com"
		);

		driver.findElement(
				By.id("TextField0")
		).sendKeys("April");

		/* STEP 8: ENTER SHIPPING INFORMATION
		 */

		driver.findElement(
				By.id("TextField1")
		).sendKeys("Test");

		driver.findElement(
				By.id("TextField2")
		).sendKeys("User");

		driver.findElement(
				By.id("TextField3")
		).sendKeys("320 W 5th Ave");

		driver.findElement(
				By.id("TextField4")
		).sendKeys("Anchorage");

		driver.findElement(
				By.id("TextField5")
		).sendKeys("99501");

		/* STEP 9: ENTER PHONE NUMBER
		 */

		driver.findElement(
				By.id("TextField6")
		).sendKeys("9075550123");

		System.out.println(
				"Valid customer and shipping information entered"
		);

		/* STEP 10: CONTINUE TO NEXT CHECKOUT STEP
		 */

		driver.findElement(
				By.xpath(
						"//button[contains(normalize-space(.),'Continue to shipping')]"
				)
		).click();

		System.out.println(
				"Checkout proceeded to the next stage"
		);

		/* STEP 11: VERIFY CHECKOUT PROCEEDED
		 */

		String currentUrl =
				driver.getCurrentUrl().toLowerCase();

		String pageSource =
				driver.getPageSource().toLowerCase();

		boolean checkoutProceeded =
				currentUrl.contains("shipping")
				|| currentUrl.contains("checkout")
				|| pageSource.contains("shipping method")
				|| pageSource.contains("delivery method")
				|| pageSource.contains("payment");

		Assert.assertTrue(
				checkoutProceeded,
				"Checkout did not proceed to the next stage"
		);

		System.out.println(
				"Valid guest checkout information was accepted successfully"
		);
	}
}
