package com.plug.ecommerce.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtility {

	Connection con;

	

	public void connectToDB() throws SQLException {

		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/projects",
				"root",
				"root");

		System.out.println(
				"---- Database connected successfully ----");
	}

	

	public void executeAndGetData(
			String query,
			int columnIndex,
			String expectedData) throws SQLException {

		Statement statement =
				con.createStatement();

		ResultSet result =
				statement.executeQuery(query);

		boolean flag = false;

		while (result.next()) {

			String actualData =
					result.getString(columnIndex);

			if (actualData != null
					&& actualData.contains(expectedData)) {

				flag = true;
				break;
			}
		}

		if (flag) {

			System.out.println(
					"---- Data is verified ----");

		} else {

			System.out.println(
					"---- Data is not present ----");
		}

		result.close();
		statement.close();
	}

	
	public String getDataFromDB(
			String query,
			int columnIndex) throws SQLException {

		Statement statement =
				con.createStatement();

		ResultSet result =
				statement.executeQuery(query);

		String value = "";

		while (result.next()) {

			value =
					result.getString(columnIndex);
		}

		result.close();
		statement.close();

		return value;
	}

	

	public int executeUpdate(
			String query) throws SQLException {

		Statement statement =
				con.createStatement();

		int result =
				statement.executeUpdate(query);

		statement.close();

		return result;
	}

	public void closeDB() throws SQLException {

		if (con != null) {

			con.close();

			System.out.println(
					"---- Database connection closed ----");
		}
	}
}
