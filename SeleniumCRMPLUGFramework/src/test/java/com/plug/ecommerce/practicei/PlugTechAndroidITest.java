package com.plug.ecommerce.practicei;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class PlugTechAndroidITest extends BaseClass {

	@Test
	public void verifyAndroidCategoryPage() {

		// Create object of HomePage
		HomePage hp = new HomePage(driver);

		// Click Android from navigation menu
		hp.clickAndroid();

		// Verify Android category page is displayed
		Assert.assertTrue(
				driver.getTitle()
						.toLowerCase()
						.contains("android"),
				"Android category page is not displayed"
		);

		System.out.println(
				"Android category page is displayed successfully"
		);
	}
}
