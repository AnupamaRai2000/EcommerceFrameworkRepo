package com.plug.ecommerce.practices;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class PlugTechSearchTest extends BaseClass {

	@Test
	public void searchProductTest() {

		// Create object of HomePage
		HomePage hp = new HomePage(driver);

		// Click Search, enter iPhone and submit
		hp.searchProduct("iPhone");

		// Verify search results page is displayed
		Assert.assertTrue(
				driver.getTitle().toLowerCase().contains("iphone"),
				"Search results page related to iPhone is not displayed"
		);

		System.out.println(
				"Search results page related to iPhone is displayed successfully"
		);
	}
}
