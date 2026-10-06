package com.plug.ecommerce.homepagetest;

import org.testng.annotations.Test;

import com.plug.ecommerce.genericutility.BaseClass;
import com.plug.ecommerce.objectrepository.HomePage;

public class HomePageSmartwatchTest extends BaseClass {

    @Test
    public void verifySmartwatchNavigation() {

        HomePage hp = new HomePage(driver);

        hp.clickWatches();

        System.out.println(
                "Smartwatch category navigation executed successfully");
    }
}
