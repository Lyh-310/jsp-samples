package com.demo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.demo.model.User;

public class UserService {
	
	Connection con;
	
	public UserService() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/try?serverTimezone=UTC", "root", "password");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int insertUser(User user) {
		
		try {
			PreparedStatement ps = con.prepareStatement("insert into users1000 (name, age, email) values (?,?,?)");
			ps.setString(1, user.getName());
			ps.setInt(2,  user.getAge());
			ps.setString(3,  user.getEmail());
			return ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

}
