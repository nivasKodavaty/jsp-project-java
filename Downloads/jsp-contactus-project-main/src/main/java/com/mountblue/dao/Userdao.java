package com.mountblue.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mountblue.model.Usermodel;

public class Userdao {
	private static final String URL = "jdbc:postgresql://localhost:5432/Workdatabase";
	private static final String USER = "nivas";
	private static final String PASSWORD = "Nivas@30.2";

	public int registerUser(Usermodel usermodel) throws SQLException, ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO mountblue_users" + "  (fullname,email,message) VALUES " + " (?, ?, ?);";

		int result = 0;
		Class.forName("org.postgresql.Driver");

		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);

			preparedStatement.setString(1, usermodel.getFullname());
			preparedStatement.setString(2, usermodel.getEmail());
			preparedStatement.setString(3, usermodel.getMessage());

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();

		}
		return result;
	}
	
}
