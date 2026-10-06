package com.plug.ecommerce.practices;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class PlugTechCartTest extends BaseClass {

	@Test
	public void verifyCartPage() {

		// Create object of HomePage
		HomePage hp = new HomePage(driver);

		// Click Cart icon
		hp.clickCart();

		// Verify Cart page is displayed
		Assert.assertTrue(
				driver.getTitle().toLowerCase().contains("cart"),
				"Cart page is not displayed successfully"
		);

		System.out.println(
				"Cart page is displayed successfully"
		);
	}
}
