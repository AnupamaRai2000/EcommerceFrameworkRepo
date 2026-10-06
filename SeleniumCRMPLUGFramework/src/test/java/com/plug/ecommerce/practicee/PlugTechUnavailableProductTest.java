package com.plug.ecommerce.practicee;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class PlugTechUnavailableProductTest extends BaseClass {

	@Test
	public void verifyUnavailableProductCannotBeAddedToCart() {

		/* STEP 1: CREATE HOMEPAGE OBJECT
		 */

		HomePage hp = new HomePage(driver);

		/* STEP 2: SEARCH FOR UNAVAILABLE PRODUCT
		 */

		hp.searchProduct(
				"iPhone SE 2022 Midnight 64GB"
		);

		/* STEP 3: OPEN THE REQUIRED PRODUCT
		 */

		driver.findElement(
				By.xpath(
						"//a[contains(.,'iPhone SE 2022 Midnight 64GB')]"
				)
		).click();

		System.out.println(
				"Unavailable product page opened"
		);

		/* STEP 4: VERIFY OUT OF STOCK MESSAGE
		 */

		String pageSource =
				driver.getPageSource();

		String pageText =
				pageSource.toLowerCase();

		boolean outOfStockMessage =
				pageText.contains(
						"currently out of stock"
				)
				|| pageText.contains(
						"out of stock"
				);

		Assert.assertTrue(
				outOfStockMessage,
				"Expected Out of Stock message is not displayed"
		);

		System.out.println(
				"Currently out of stock message is displayed"
		);

		/* STEP 5: VERIFY EMAIL ME WHEN IT'S BACK BUTTON
		 */

		boolean emailMeButton =
				pageText.contains(
						"email me when it's back"
				)
				|| pageText.contains(
						"email me when its back"
				);

		Assert.assertTrue(
				emailMeButton,
				"'Email me when it's back' option is not displayed"
		);

		System.out.println(
				"Email me when it's back option is displayed"
		);

		/* STEP 6: VERIFY NOTIFY MESSAGE
		 */

		boolean notifyMessage =
				pageText.contains(
						"we'll email you if this exact option comes back"
				)
				|| pageText.contains(
						"we'll email you"
				)
				|| pageText.contains(
						"we'll email"
				);

		Assert.assertTrue(
				notifyMessage,
				"Expected availability notification message is not displayed"
		);

		System.out.println(
				"Availability notification message is displayed"
		);

		/* STEP 7: VERIFY ADD TO CART IS NOT AVAILABLE
		 */

		boolean addToCartAvailable =
				driver.findElements(
						By.xpath(
								"//button[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'add to cart')]"
						)
				).size() > 0;

		if (addToCartAvailable) {

			WebElement addToCartButton =
					driver.findElement(
							By.xpath(
									"//button[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'add to cart')]"
							)
					);

			Assert.assertFalse(
					addToCartButton.isEnabled(),
					"Add to Cart button is enabled for unavailable product"
			);

			System.out.println(
					"Add to Cart button is disabled"
			);

		} else {

			System.out.println(
					"Add to Cart button is not displayed, as expected"
			);
		}

		/* STEP 8: VERIFY PRODUCT IS NOT IN CART
		 */

		hp.clickCart();

		String cartPageSource =
				driver.getPageSource().toLowerCase();

		Assert.assertFalse(
				cartPageSource.contains(
						"iphone se 2022 midnight 64gb"
				),
				"Unavailable product was incorrectly added to Cart"
		);

		System.out.println(
				"Unavailable product was not added to the Cart"
		);

		System.out.println(
				"Unavailable product test passed successfully"
		);
	}
}
