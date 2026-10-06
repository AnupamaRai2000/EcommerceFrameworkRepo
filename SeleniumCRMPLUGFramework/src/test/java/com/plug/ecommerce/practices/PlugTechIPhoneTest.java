package com.plug.ecommerce.practices;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class PlugTechIPhoneTest extends BaseClass {

	@Test
	public void verifyiPhoneCategoryPage() {

		// Create object of HomePage
		HomePage hp = new HomePage(driver);

		// Click iPhone from navigation menu
		hp.clickiPhone();

		// Verify iPhone category page is displayed
		Assert.assertTrue(
				driver.getTitle().toLowerCase().contains("iphone"),
				"iPhone category page is not displayed"
		);

		System.out.println(
				"iPhone category page is displayed successfully"
		);
	}
}
