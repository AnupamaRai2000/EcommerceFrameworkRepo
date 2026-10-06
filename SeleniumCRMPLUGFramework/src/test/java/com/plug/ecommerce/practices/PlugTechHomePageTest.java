package com.plug.ecommerce.practices;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class PlugTechHomePageTest extends BaseClass {

	@Test
	public void verifyPlugTechHomePage() {

		// Create object of HomePage
		HomePage hp = new HomePage(driver);

		// Verify Plug.tech Home Page is displayed
		Assert.assertTrue(
				hp.isHomePageDisplayed(),
				"Plug.tech Home Page is not displayed successfully"
		);

		System.out.println(
				"Plug.tech Home Page is displayed successfully"
		);
	}
}
