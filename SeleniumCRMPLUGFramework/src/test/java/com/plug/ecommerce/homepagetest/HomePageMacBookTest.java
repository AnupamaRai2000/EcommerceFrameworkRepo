package com.plug.ecommerce.homepagetest;

import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class HomePageMacBookTest extends BaseClass {

	@Test
	public void verifyMacBookNavigation() {

		HomePage hp =
				new HomePage(driver);

		hp.clickMacBook();

		System.out.println(
				"MacBook category navigation executed successfully");
	}
}
