package com.plug.ecommerce.practicee;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class PlugTechWishlistProductTest extends BaseClass {

	@Test
	public void addSamsungS23PlusToWishlist() {

		/* STEP 1: CREATE HOMEPAGE OBJECT
		 */

		HomePage hp = new HomePage(driver);

		/* STEP 2: SEARCH FOR SAMSUNG GALAXY S23 PLUS
		 */

		hp.searchProduct(
				"Samsung Galaxy S23 Plus 256GB 5G"
		);

		/* STEP 3: OPEN THE REQUIRED PRODUCT
		 */

		driver.findElement(
				By.xpath(
						"//a[contains(.,'Samsung Galaxy S23 Plus 256GB 5G - Phantom Black (Unlocked)')]"
				)
		).click();

		/* STEP 4: SELECT REQUIRED OPTIONS
		 */

		/* Select Phantom Black color
		 */
		driver.findElement(
				By.xpath(
						"//*[contains(normalize-space(.),'Phantom Black')]/ancestor::*[self::label or self::button][1]"
				)
		).click();

		// Select 256GB storage
		driver.findElement(
				By.xpath(
						"//*[contains(normalize-space(.),'256GB')]/ancestor::*[self::label or self::button][1]"
				)
		).click();

		// Select Good condition
		driver.findElement(
				By.xpath(
						"//*[normalize-space(.)='Good']/ancestor::*[self::label or self::button][1]"
				)
		).click();

		System.out.println(
				"Required product options selected successfully"
		);

		/* STEP 5: CLICK WISHLIST / HEART ICON
		 */

		driver.findElement(
				By.xpath(
						"//*[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'add to wishlist')]"
				)
		).click();

		System.out.println(
				"Wishlist / Heart icon clicked successfully"
		);

		/* STEP 6: SELECT MY WISHLIST CHECKBOX
		 */

		driver.findElement(
				By.xpath(
						"//*[normalize-space(.)='My Wishlist']/preceding::input[@type='checkbox'][1]"
				)
		).click();

		System.out.println(
				"My Wishlist selected successfully"
		);

		/* STEP 7: CLICK ADD TO LIST
		 */

		driver.findElement(
				By.xpath(
						"//button[normalize-space()='Add to List']"
				)
		).click();

		System.out.println(
				"Add To List button clicked successfully"
		);

		/* STEP 8: VERIFY SUCCESS MESSAGE
		 */

		String pageSource =
				driver.getPageSource();

		boolean productAdded =
				pageSource.contains(
						"Samsung Galaxy S23 Plus 256GB 5G"
				)
				&& (
						pageSource.contains(
								"has been added"
						)
						|| pageSource.contains(
								"added to"
						)
						|| pageSource.contains(
								"successfully"
						)
				);

		Assert.assertTrue(
				productAdded,
				"Samsung Galaxy S23 Plus was not added successfully to My Wishlist"
		);

		System.out.println(
				"Samsung Galaxy S23 Plus 256GB 5G - Phantom Black (Unlocked) - Phantom Black / 256GB / Good has been added to My Wishlist successfully"
		);
	}
}
