package com.plug.ecommerce.practices;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class PlugTechAddToCartTest extends BaseClass {

	@Test
	public void addiPhoneToCartTest() {

		// Create HomePage object
		HomePage hp = new HomePage(driver);

		// Search for iPhone
		hp.searchProduct("iPhone");

		// Select iPhone product from search results
		driver.findElement(
				By.xpath(
						"//*[contains(normalize-space(.),'iPhone')]/ancestor::a[1]"
				)
		).click();

		// Click Add to Cart
		driver.findElement(
				By.xpath(
						"//button[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'add to cart')]"
				)
		).click();

		// Open Cart
		driver.findElement(
				By.xpath(
						"//*[name()='svg' and contains(@class,'icon-cart-empty')]/ancestor::a[1]"
				)
		).click();

		// Verify iPhone is displayed in Cart
		Assert.assertTrue(
				driver.getPageSource()
						.toLowerCase()
						.contains("iphone"),
				"iPhone is not displayed in the cart"
		);

		System.out.println(
				"iPhone was added successfully to the cart"
		);
	}
}
