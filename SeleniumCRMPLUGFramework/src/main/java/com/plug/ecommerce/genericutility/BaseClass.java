package com.plug.ecommerce.genericutility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.plug.ecommerce.objectrepository.LoginPage;

public class BaseClass {



public WebDriver driver;

public FileUtility flib = new FileUtility();
public ExcelUtility elib = new ExcelUtility();
public JavaUtility jlib = new JavaUtility();
public WebdriverUtility wlib = new WebdriverUtility();
public DatabaseUtility dbLib = new DatabaseUtility();



@BeforeSuite
public void configBS() throws Exception {

	System.out.println("===== Before Suite =====");

	/*
	 * Enable this when database validation
	 * is required.
	 *
	 * dbLib.connectToDB();
	 */
}



@BeforeClass
public void configBC() throws Exception {

	System.out.println("===== Launch Browser =====");

	String BROWSER =
			flib.readDataFromPropertyFile("browser");

	String URL =
			flib.readDataFromPropertyFile("url");

	driver =
			wlib.launchBrowser(BROWSER);

	wlib.maximizeWindow(driver);

	wlib.implicitWait(driver, 15);

	driver.get(URL);

	System.out.println("Browser : " + BROWSER);
	System.out.println("URL     : " + URL);
}



@BeforeMethod
public void configBM() throws Exception {

	String USER_TYPE =
			flib.readDataFromPropertyFile("userType");

	if (USER_TYPE.equalsIgnoreCase("guest")) {

		System.out.println(
				"===== Guest Shopper =====");

		/*
		 * Guest user does not require login.
		 *
		 * Application is already opened in
		 * @BeforeClass.
		 */

	} else if (USER_TYPE.equalsIgnoreCase("registered")) {

		System.out.println(
				"===== Registered User =====");

		String USERNAME =
				flib.readDataFromPropertyFile("username");

		String PASSWORD =
				flib.readDataFromPropertyFile("password");

		LoginPage lp =
				new LoginPage(driver);

		lp.loginToApp(USERNAME, PASSWORD);

	} else {

		System.out.println(
				"Invalid userType: " + USER_TYPE);
	}
}



@AfterClass
public void configAC() {

	System.out.println("===== Close Browser =====");

	wlib.quitBrowser(driver);
}


/*
 * Enable this when database connection
 * is enabled in @BeforeSuite.
 */

/*
@AfterSuite
public void configAS() throws Exception {

	System.out.println("===== Close Database =====");

	dbLib.closeDB();
}
*/


}