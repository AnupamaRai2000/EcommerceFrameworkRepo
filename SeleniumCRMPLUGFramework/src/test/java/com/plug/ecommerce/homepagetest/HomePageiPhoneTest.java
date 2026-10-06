package com.plug.ecommerce.homepagetest;

import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class HomePageiPhoneTest extends BaseClass {

	@Test
	public void verifyiPhoneNavigation() {

		HomePage hp =
				new HomePage(driver);

		hp.clickiPhone();

		System.out.println(
				"iPhone category navigation executed successfully");
	}
}
