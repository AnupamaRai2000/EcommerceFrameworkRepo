package com.plug.ecommerce.homepagetest;

import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class HomePageAudioTest extends BaseClass {

	@Test
	public void verifyAudioNavigation() {

		HomePage hp =
				new HomePage(driver);

		hp.clickAudio();

		System.out.println(
				"Audio category navigation executed successfully");
	}
}
