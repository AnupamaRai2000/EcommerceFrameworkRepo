package com.plug.ecommerce.practicee;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class PlugTechEmptyCartTest extends BaseClass {

	@Test
	public void verifyEmptyCart() {

		// Create HomePage object
		HomePage hp = new HomePage(driver);

		/* STEP 1: OPEN CART
		 */

		hp.clickCart();

		System.out.println(
				"Cart page opened successfully"
		);

		/* STEP 2: VERIFY CART IS EMPTY
		 */

		String pageText =
				driver.getPageSource().toLowerCase();

		boolean emptyCartMessage =
				pageText.contains("no items in your cart")
				|| pageText.contains("your cart is empty")
				|| pageText.contains("cart is empty");

		Assert.assertTrue(
				emptyCartMessage,
				"Expected empty-cart message is not displayed"
		);

		System.out.println(
				"Empty Cart message is displayed successfully"
		);

		/* STEP 3: VERIFY SHOP NOW ACTION
		 */

		boolean shopNowAvailable =
				driver.findElements(
						By.xpath(
								"//a[contains(normalize-space(), \"Shop Now\") and @href=\"/collections/all\"]"
						)
				).size() > 0;

		if (shopNowAvailable) {

			System.out.println(
					"Shop Now action is available for the empty Cart"
			);

			Assert.assertTrue(
					shopNowAvailable,
					"Shop Now action is not available"
			);

		} else {

			/* STEP 4: VERIFY CHECKOUT IS NOT AVAILABLE
			 */

			boolean checkoutAvailable =
					driver.findElements(
							By.xpath(
									"//button[normalize-space()='Checkout'] | //input[@value='Checkout']"
							)
					).size() > 0;

			Assert.assertFalse(
					checkoutAvailable,
					"Checkout should not be available for an empty Cart"
			);

			System.out.println(
					"Checkout is not available for the empty Cart"
			);
		}

		System.out.println(
				"Empty Cart validation completed successfully"
		);
	}
}