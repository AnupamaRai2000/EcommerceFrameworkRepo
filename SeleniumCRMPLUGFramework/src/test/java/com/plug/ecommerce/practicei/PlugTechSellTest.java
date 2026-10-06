package com.plug.ecommerce.practicei;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class PlugTechSellTest extends BaseClass {

	@Test
	public void verifySellPage() {

		/* Create object of HomePage
		 */
		HomePage hp = new HomePage(driver);

		/* Click Sell from navigation menu
		 */
		hp.clickSell();

		/* Verify Sell page is displayed
		 */
		Assert.assertTrue(
				driver.getTitle()
						.toLowerCase()
						.contains("sell"),
				"Sell page is not displayed successfully"
		);

		System.out.println(
				"Sell page is displayed successfully"
		);
	}
}
