package com.plug.ecommerce.practices;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class PlugTechiPadTest extends BaseClass {

	@Test
	public void verifyiPadCategoryPage() {

		// Create object of HomePage
		HomePage hp = new HomePage(driver);

		// Click iPad from navigation menu
		hp.clickiPad();

		// Verify iPad category page is displayed
		Assert.assertTrue(
				driver.getTitle().toLowerCase().contains("ipad"),
				"iPad category page is not displayed"
		);

		System.out.println(
				"iPad category page is displayed successfully"
		);
	}
}
