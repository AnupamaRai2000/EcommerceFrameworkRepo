package com.plug.ecommerce.practicei;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class PlugTechProductCartTest extends BaseClass {

	@Test
	public void verifyProductAddedToCart() {

		/* Create HomePage object
		 */
		HomePage hp = new HomePage(driver);

		/* Search for an available product
		 */
		hp.searchProduct("iPhone");

		/* Select the first available iPhone product
		 */
		driver.findElement(
				By.xpath(
						"(//*[contains(normalize-space(.),'iPhone')]/ancestor::a[1])[1]"
				)
		).click();

		/* Store selected product information
		 */
		String productName =
				driver.findElement(
						By.xpath(
								"//h1 | //h1[contains(@class,'product')]"
						)
				).getText();

		System.out.println(
				"Selected Product: " + productName
		);

		/* Click Add to Cart
		 */
		driver.findElement(
				By.xpath(
						"//button[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'add to cart')]"
				)
		).click();

		System.out.println(
				"Product added to cart"
		);

		/* Open Cart
		 */
		driver.findElement(
				By.xpath(
						"//*[name()='svg' and contains(@class,'icon-cart-empty')]/ancestor::a[1]"
				)
		).click();

		/* Verify selected product is displayed in Cart
		 */
		String cartPageSource =
				driver.getPageSource();

		Assert.assertTrue(
				cartPageSource.contains(productName),
				"Selected product is not displayed in the Cart"
		);

		System.out.println(
				"Selected product is displayed in the Cart successfully"
		);
	}
}
