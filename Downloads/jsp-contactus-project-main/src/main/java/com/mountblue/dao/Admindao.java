package com.mountblue.dao;

import com.mountblue.model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Admindao {
	private static final String URL = "jdbc:postgresql://localhost:5432/Workdatabase";
	private static final String USER = "nivas";
	private static final String PASSWORD = "Nivas@30.2";

	public List<Usermodel> getActiveUsers() throws SQLException, ClassNotFoundException {
		List<Usermodel> userList = new ArrayList<>();
		String sql = "SELECT * FROM mountblue_users WHERE archieved = false";

		Class.forName("org.postgresql.Driver");

		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				String name = resultSet.getString("fullname");
				String email = resultSet.getString("email");
				String message = resultSet.getString("message");
				int id = resultSet.getInt("sno");
				Usermodel user = new Usermodel();
				user.setFullname(name);
				user.setEmail(email);
				user.setMessage(message);
				user.setId(id);
				userList.add(user);
			}
		}
		return userList;
	}

	public List<Usermodel> getArchievedUsers() throws SQLException, ClassNotFoundException {
		List<Usermodel> userList = new ArrayList<>();
		String sql = "SELECT * FROM mountblue_users WHERE archieved = true";

		Class.forName("org.postgresql.Driver");

		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				String name = resultSet.getString("fullname");
				String email = resultSet.getString("email");
				String message = resultSet.getString("message");
				int id = resultSet.getInt("sno");
				Usermodel user = new Usermodel();
				user.setFullname(name);
				user.setEmail(email);
				user.setMessage(message);
				user.setId(id);
				userList.add(user);
			}
		}
		return userList;
	}

	public int updateUserActive(int id) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE mountblue_users SET archieved = false WHERE sno = " + id;

		Class.forName("org.postgresql.Driver");

		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected;
			

		}
	}
	public int updateUserArchieve(int id) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE mountblue_users SET archieved = true WHERE sno = " + id;
		System.out.print(sql);

		Class.forName("org.postgresql.Driver");

		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
			int rowsAffected = preparedStatement.executeUpdate();
			System.out.print(rowsAffected);
			return rowsAffected;

		}
	}

}
