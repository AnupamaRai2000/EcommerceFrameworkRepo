package com.plug.ecommerce.homepagetest;

import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class HomePageAndroidTest extends BaseClass {

	@Test
	public void verifyAndroidNavigation() {

		HomePage hp =
				new HomePage(driver);

		hp.clickAndroid();

		System.out.println(
				"Android category navigation executed successfully");
	}
}
