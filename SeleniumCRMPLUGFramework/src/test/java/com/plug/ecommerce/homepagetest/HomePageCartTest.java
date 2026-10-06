package com.plug.ecommerce.homepagetest;

import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class HomePageCartTest extends BaseClass {

	@Test
	public void verifyCartNavigation() {

		HomePage hp =
				new HomePage(driver);

		hp.clickCart();

		System.out.println(
				"Cart navigation executed successfully");
	}
}
