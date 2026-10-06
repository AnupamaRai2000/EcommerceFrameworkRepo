package com.plug.ecommerce.practices;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class PlugTechCheckoutTest extends BaseClass {

	@Test
	public void verifyGuestCheckoutTillPayment() {

		// Create HomePage object
		HomePage hp = new HomePage(driver);

		/* STEP 1: OPEN CART
		 */

		hp.clickCart();

		// Check whether cart is empty
		boolean cartIsEmpty =
				driver.getPageSource()
						.toLowerCase()
						.contains("no items in your cart");

		/* STEP 2: IF CART IS EMPTY
		 */

		if (cartIsEmpty) {

			System.out.println(
					"Cart is empty. Clicking Shop Now..."
			);

			// Click Shop Now
			driver.findElement(
					By.xpath(
							"//a[normalize-space()='Shop Now']"
					)
			).click();

			// Select any available iPhone product
			driver.findElement(
					By.xpath(
							"(//*[contains(normalize-space(.),'iPhone')]/ancestor::a[1])[1]"
					)
			).click();

			// Click Add to Cart
			driver.findElement(
					By.xpath(
							"//button[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'add to cart')]"
					)
			).click();

			System.out.println(
					"Product added to cart successfully"
			);

			// Open Cart
			driver.findElement(
					By.xpath(
							"//*[name()='svg' and contains(@class,'icon-cart-empty')]/ancestor::a[1]"
					)
			).click();

		} else {

			/* STEP 3: IF CART ALREADY CONTAINS PRODUCT
			 */

			System.out.println(
					"Cart already contains a product. Continuing with existing product..."
			);
		}

		/* STEP 4: CLICK CHECKOUT
		 */

		driver.findElement(
				By.xpath(
						"//button[normalize-space()='Checkout'] | //input[@value='Checkout']"
				)
		).click();

		System.out.println(
				"Checkout page opened successfully"
		);

		/* STEP 5: ENTER CUSTOMER / GUEST DETAILS
		 */

		// Email
		WebElement email =
				driver.findElement(
						By.id("email")
				);

		email.sendKeys(
				"testuser@example.com"
		);

		// First Name
		WebElement firstName =
				driver.findElement(
						By.id("TextField0")
				);

		firstName.sendKeys("Test");

		// Last Name
		WebElement lastName =
				driver.findElement(
						By.id("TextField1")
				);

		lastName.sendKeys("User");

		// Address
		WebElement address =
				driver.findElement(
						By.id("TextField2")
				);

		address.sendKeys(
				"123 Main Street"
		);

		// City
		WebElement city =
				driver.findElement(
						By.id("TextField3")
				);

		city.sendKeys("New York");

		// ZIP / Postal Code
		WebElement postalCode =
				driver.findElement(
						By.id("TextField4")
				);

		postalCode.sendKeys("10001");

		// Phone
		WebElement phone =
				driver.findElement(
						By.id("TextField5")
				);

		phone.sendKeys("2125550123");

		/* STEP 6: CONTINUE TO SHIPPING
		 */

		driver.findElement(
				By.xpath(
						"//button[contains(normalize-space(.),'Continue to shipping')]"
				)
		).click();

		System.out.println(
				"Customer and shipping details submitted"
		);

		/* STEP 7: CONTINUE TO PAYMENT
		 */

		driver.findElement(
				By.xpath(
						"//button[contains(normalize-space(.),'Continue to payment')]"
				)
		).click();

		System.out.println(
				"Payment section displayed successfully"
		);

		/* STEP 8: VERIFY PAYMENT SECTION
		 */

		Assert.assertTrue(
				driver.getPageSource()
						.toLowerCase()
						.contains("payment"),
				"Payment section is not displayed"
		);

		System.out.println(
				"Checkout proceeded successfully and Payment section is displayed"
		);
	}
}
