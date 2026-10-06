package com.plug.ecommerce.practicei;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class PlugTechInvalidSearchTest extends BaseClass {

	@Test
	public void verifyInvalidProductSearch() {

		/* Create object of HomePage
		 */
		HomePage hp = new HomePage(driver);

		/*Search for non-existing product
		 */
		hp.searchProduct("xyznonexistingproduct123");

		/* Verify appropriate no-results message is displayed
		 */
		String pageSource =
				driver.getPageSource().toLowerCase();

		Assert.assertTrue(
				pageSource.contains("no results found")
						|| pageSource.contains("no results")
						|| pageSource.contains("product not found"),
				"Appropriate no-results message is not displayed"
		);

		System.out.println(
				"Invalid search input handled successfully and appropriate no-results message is displayed"
		);
	}
}
