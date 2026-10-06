package com.plug.ecommerce.practices;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class PlugTechWishlistTest extends BaseClass {

	@Test
	public void verifyWishlistPage() {

		// Create object of HomePage
		HomePage hp = new HomePage(driver);

		// Click Wishlist / Heart icon
		hp.clickHeart();

		// Verify Wishlist page is displayed
		Assert.assertTrue(
				driver.getTitle().toLowerCase().contains("wishlist"),
				"My Wishlist page is not displayed"
		);

		System.out.println(
				"My Wishlist page is displayed successfully"
		);
	}
}
