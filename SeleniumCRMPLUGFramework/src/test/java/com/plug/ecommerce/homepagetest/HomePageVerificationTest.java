package com.plug.ecommerce.homepagetest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class HomePageVerificationTest extends BaseClass {

    @Test
    public void verifyHomePageDisplayed() {

        HomePage hp = new HomePage(driver);

        Assert.assertTrue(
                hp.isHomePageDisplayed(),
                "Home Page is not displayed");

        System.out.println(
                "Home Page is displayed successfully");
    }
}
