package edu.ben.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.models.User;

public class UserDao {
	private static String TABLE_NAME = "cookbook.user";
	DBConnector connector = new DBConnector();

	Connection conn = connector.getConnection();

	public void addUser(User u) {
		String sql = "INSERT INTO " + TABLE_NAME + " (firstName, lastName, pWord, userName, email) VALUES " + "('"
				+ u.getFirstName() + "', '" + u.getLastName() + "', '" + u.getpWord() + "', '" + u.getUserName() + "', '" + u.getEmail() + "')";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public boolean userExists(User u) {
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE userName= '" + u.getUserName() + "'";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("userName").equals(u.getUserName())) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean userLogin(String userName, String password) {
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE userName= '" + userName + "' and pWord= '" + password + "'";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("userName").equals(userName) && rs.getString("pWord").equals(password)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public String setUserName(HttpServletRequest request, HttpServletResponse response) {
		String userName = "Sign in now";
		if(request.getSession().getAttribute("userName").equals(null)) {
			return userName;
		}else {
			return (String) request.getAttribute("userName");
		}
	}
	
	
	public boolean checkRole(String userName) {
		String sql = "SELECT role FROM " + TABLE_NAME + " WHERE role=1";
		
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			
			if (rs.getInt("role") == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
		
	}

}
