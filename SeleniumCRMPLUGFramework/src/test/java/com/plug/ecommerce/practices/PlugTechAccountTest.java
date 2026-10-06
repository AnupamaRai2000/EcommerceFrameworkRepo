package com.plug.ecommerce.practices;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class PlugTechAccountTest extends BaseClass {

	@Test
	public void verifySignInPage() {

		// Create object of HomePage
		HomePage hp = new HomePage(driver);

		// Click Account / Profile icon
		hp.clickAccount();

		// Verify Sign In page is displayed
		Assert.assertTrue(
				driver.getTitle().toLowerCase().contains("sign"),
				"Sign In page is not displayed"
		);

		System.out.println(
				"Sign In page is displayed successfully"
		);
	}
}
