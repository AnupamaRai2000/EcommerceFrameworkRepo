package com.plug.ecommerce.practicee;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class PlugTechSamsungWishlistTest extends BaseClass {

	@Test
	public void verifySamsungS23AddedToWishlist() {

		/* STEP 1: CREATE HOMEPAGE OBJECT
		 */

		HomePage hp = new HomePage(driver);

		/* STEP 2: SEARCH FOR SAMSUNG GALAXY S23 PLUS
		 */

		hp.searchProduct(
				"Samsung Galaxy S23 Plus 256GB 5G"
		);

		System.out.println(
				"Samsung Galaxy S23 Plus product searched successfully"
		);

		/* STEP 3: OPEN THE REQUIRED PRODUCT
		 */

		driver.findElement(
				By.xpath(
						"(//*[contains(normalize-space(.),'Samsung Galaxy S23 Plus 256GB 5G')]/ancestor::a[1])[1]"
				)
		).click();

		System.out.println(
				"Samsung Galaxy S23 Plus product page opened"
		);

		/* STEP 4: SELECT PHANTOM BLACK
		 */

		driver.findElement(
				By.xpath(
						"//*[normalize-space()='Phantom Black']/ancestor::label[1]"
				)
		).click();

		/* STEP 5: SELECT 256GB
		 */

		driver.findElement(
				By.xpath(
						"//*[normalize-space()='256GB']/ancestor::label[1]"
				)
		).click();

		/* STEP 6: SELECT GOOD CONDITION
		 */

		driver.findElement(
				By.xpath(
						"//*[normalize-space()='Good']/ancestor::label[1]"
				)
		).click();

		System.out.println(
				"Phantom Black / 256GB / Good selected successfully"
		);

		/* STEP 7: CLICK WISHLIST / HEART ICON
		 */

		hp.clickHeart();

		System.out.println(
				"Wishlist / Heart icon clicked successfully"
		);

		/* STEP 8: SELECT MY WISHLIST CHECKBOX
		 */

		WebElement myWishlistCheckbox =
				driver.findElement(
						By.xpath(
								"//label[normalize-space()='My Wishlist']//input[@type='checkbox']"
						)
				);

		myWishlistCheckbox.click();

		System.out.println(
				"My Wishlist checkbox selected successfully"
		);

		/* STEP 9: CLICK ADD TO LIST
		 */

		driver.findElement(
				By.xpath(
						"//button[normalize-space()='Add to List']"
				)
		).click();

		System.out.println(
				"Add To List button clicked successfully"
		);

		/* STEP 10: VERIFY SUCCESS MESSAGE
		 */

		String pageText =
				driver.getPageSource().toLowerCase();

		boolean wishlistSuccess =
				pageText.contains(
						"samsung galaxy s23 plus 256gb 5g"
				)
				&& pageText.contains(
						"phantom black"
				)
				&& pageText.contains(
						"256gb"
				)
				&& pageText.contains(
						"good"
				)
				&& (
						pageText.contains(
								"has been added"
						)
						|| pageText.contains(
								"added to 1 list"
						)
						|| pageText.contains(
								"successfully"
						)
				);

		Assert.assertTrue(
				wishlistSuccess,
				"Product was not added successfully to My Wishlist"
		);

		System.out.println(
				"Samsung Galaxy S23 Plus 256GB 5G - Phantom Black (Unlocked) - Phantom Black / 256GB / Good has been added to My Wishlist successfully"
		);
	}
}
