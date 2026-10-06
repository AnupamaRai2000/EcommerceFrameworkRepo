package com.plug.ecommerce.genericutility;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	String propertyFilePath =
			"./src/test/resources/Credentials.properties";
	
//	String propertyFilePath =
//	        System.getProperty("user.dir")
//	        + "/src/test/resources/Credentials.properties";


	

	public String readDataFromPropertyFile(
			String key) throws IOException {

		FileInputStream fis =
				new FileInputStream(propertyFilePath);

		Properties pObj =
				new Properties();

		pObj.load(fis);

		String value =
				pObj.getProperty(key);

		fis.close();

		return value;
	}
	

	
	public void writeDataIntoPropertyFile(
			String key,
			String value) throws IOException {

		FileInputStream fis =
				new FileInputStream(propertyFilePath);

		Properties pObj =
				new Properties();

		pObj.load(fis);

		fis.close();

		pObj.setProperty(key, value);

		FileOutputStream fos =
				new FileOutputStream(propertyFilePath);

		pObj.store(
				fos,
				"Updated Property File");

		fos.close();
	}

	
	public boolean isPropertyAvailable(
			String key) throws IOException {

		FileInputStream fis =
				new FileInputStream(propertyFilePath);

		Properties pObj =
				new Properties();

		pObj.load(fis);

		boolean status =
				pObj.containsKey(key);

		fis.close();

		return status;
	}
}
