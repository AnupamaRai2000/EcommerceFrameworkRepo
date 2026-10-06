package com.plug.ecommerce.practicei;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class PlugTechInvalidCheckoutTest extends BaseClass {

	@Test
	public void verifyInvalidCheckoutValidation() {

		// Create HomePage object
		HomePage hp = new HomePage(driver);

		
		// STEP 1: SEARCH FOR AVAILABLE PRODUCT

		hp.searchProduct("iPhone");

		// Select first available iPhone product
		driver.findElement(
				By.xpath(
						"(//*[contains(normalize-space(.),'iPhone')]/ancestor::a[1])[1]"
				)
		).click();

		System.out.println(
				"iPhone product selected successfully"
		);

		// STEP 2: ADD PRODUCT TO CART

		driver.findElement(
				By.xpath(
						"//button[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'add to cart')]"
				)
		).click();

		System.out.println(
				"Product added to cart successfully"
		);

		// STEP 3: OPEN CART

		driver.findElement(
				By.xpath(
						"//*[name()='svg' and contains(@class,'icon-cart-empty')]/ancestor::a[1]"
				)
		).click();

		System.out.println(
				"Cart page opened successfully"
		);

		// STEP 4: CLICK CHECKOUT

		driver.findElement(
				By.xpath(
						"//button[normalize-space()='Checkout'] | //input[@value='Checkout']"
				)
		).click();

		System.out.println(
				"Checkout page opened successfully"
		);

		/*STEP 5: LEAVE MANDATORY FIELDS BLANK
		 */

		/*Attempt to continue with blank mandatory fields
		 */

		driver.findElement(
				By.xpath(
						"//button[contains(normalize-space(.),'Continue to shipping')]"
				)
		).click();

		/* STEP 6: VERIFY VALIDATION MESSAGE
		 */

		String pageSource =
				driver.getPageSource().toLowerCase();

		boolean validationMessageDisplayed =
				pageSource.contains("required")
				|| pageSource.contains("enter your")
				|| pageSource.contains("can't be blank")
				|| pageSource.contains("cannot be blank")
				|| pageSource.contains("invalid")
				|| pageSource.contains("error");

		Assert.assertTrue(
				validationMessageDisplayed,
				"Expected validation message was not displayed for blank mandatory fields"
		);

		System.out.println(
				"Validation message displayed successfully"
		);

		/*STEP 7: VERIFY USER HAS NOT PROCEEDED
		 */

		String currentUrl =
				driver.getCurrentUrl().toLowerCase();

		Assert.assertFalse(
				currentUrl.contains("payment"),
				"Guest user proceeded to Payment despite incomplete details"
		);

		System.out.println(
				"Guest user was prevented from proceeding with incomplete details"
		);
	}
}
