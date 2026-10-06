package com.plug.ecommerce.homepagetest;

import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class HomePageSearchTest extends BaseClass {

	@Test
	public void searchProductFromHomePage() {

		HomePage hp =
				new HomePage(driver);

		hp.searchProduct("iPhone");

		System.out.println(
				"Product search executed successfully");
	}
}
