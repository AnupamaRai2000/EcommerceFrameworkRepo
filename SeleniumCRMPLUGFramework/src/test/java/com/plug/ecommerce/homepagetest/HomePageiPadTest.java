package com.plug.ecommerce.homepagetest;

import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class HomePageiPadTest extends BaseClass {

	@Test
	public void verifyiPadNavigation() {

		HomePage hp =
				new HomePage(driver);

		hp.clickiPad();

		System.out.println(
				"iPad category navigation executed successfully");
	}
}
