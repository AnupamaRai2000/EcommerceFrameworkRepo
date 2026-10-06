package com.plug.ecommerce.homepagetest;

import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class HomePageLoginTest extends BaseClass {

	@Test
	public void verifyLoginNavigation() {

		HomePage hp =
				new HomePage(driver);

		hp.clickAccount();

		System.out.println(
				"Login navigation executed successfully");
	}
}
