package com.plug.ecommerce.homepagetest;

import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class HomePageAccessoriesTest extends BaseClass {

	@Test
	public void verifyAccessoriesNavigation() {

		HomePage hp =
				new HomePage(driver);

		hp.clickAccessories();

		System.out.println(
				"Accessories category navigation executed successfully");
	}
}
