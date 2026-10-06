package com.plug.ecommerce.homepagetest;

import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class HomePageSellTest extends BaseClass {

	@Test
	public void verifySellNavigation() {

		HomePage hp =
				new HomePage(driver);

		hp.clickSell();

		System.out.println(
				"Sell navigation executed successfully");
	}
}
