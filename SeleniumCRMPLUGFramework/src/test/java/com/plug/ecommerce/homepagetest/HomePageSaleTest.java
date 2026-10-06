package com.plug.ecommerce.homepagetest;

import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class HomePageSaleTest extends BaseClass {

	@Test
	public void verifySaleNavigation() {

		HomePage hp =
				new HomePage(driver);

		hp.clickSale();

		System.out.println(
				"Sale navigation executed successfully");
	}
}
