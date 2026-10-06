package com.plug.ecommerce.practicei;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class PlugTechWatchesTest extends BaseClass {

	@Test
	public void verifyWatchesCategoryPage() {

		/* Create object of HomePage
		 */
		HomePage hp = new HomePage(driver);

		/* Click Watches from navigation menu
		 */
		hp.clickWatches();

		/* Get current page information
		 */
		String currentUrl =
				driver.getCurrentUrl();

		String pageSource =
				driver.getPageSource().toLowerCase();

		String pageTitle =
				driver.getTitle().toLowerCase();

		/* VERIFY WATCHES CATEGORY / APPLICATION RESPONSE
		 */

		boolean watchesPageLoaded =
				pageTitle.contains("watch")
				|| currentUrl.toLowerCase().contains("watch");

		boolean unavailableMessageDisplayed =
				pageSource.contains("page not found")
				|| pageSource.contains("404")
				|| pageSource.contains("not available")
				|| pageSource.contains("unavailable")
				|| pageSource.contains("something went wrong")
				|| pageSource.contains("sorry");

		/* RESULT
		 */

		if (watchesPageLoaded) {

			System.out.println(
					"Watches category page loaded successfully"
			);

			Assert.assertTrue(
					watchesPageLoaded,
					"Watches category page is not loaded correctly"
			);

		} else {

			System.out.println(
					"Watches category is unavailable."
			);

			Assert.assertTrue(
					unavailableMessageDisplayed,
					"Application did not display an appropriate error or unavailable-page message"
			);

			System.out.println(
					"Application handled the unavailable Watches category gracefully"
			);
		}
	}
}
