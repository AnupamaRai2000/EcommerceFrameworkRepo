package com.plug.ecommerce.practicei;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class PlugTechSearchTest extends BaseClass {

	@Test
	public void verifySearchResultsForiPhone() {

		/* Create object of HomePage
		 */
		HomePage hp = new HomePage(driver);

		/* Click Search icon, enter iPhone and submit search
		 */
		hp.searchProduct("iPhone");

		/* Verify Search Results Page
		 */
		Assert.assertTrue(
				driver.getCurrentUrl()
						.toLowerCase()
						.contains("search"),
				"Search Results Page is not displayed successfully"
		);

		System.out.println(
				"Search Results Page related to iPhone is displayed successfully"
		);
	}
}
