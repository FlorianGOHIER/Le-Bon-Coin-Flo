package com.jee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jee.modele.User;

public class UserDAO {
	
	public static List<User> getAllUsers() {
		
		List<User> res = new ArrayList<>();
		try {
			Connection con = UtilConnexion.seConnecter();
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM users");
			
			while (rs.next() ) {
				int id = rs.getInt("id");
				String login = rs.getString("login");
				String email = rs.getString("mail");
				String passw = rs.getString("password");
				String firstn = rs.getString("firstname");
				String lastn = rs.getString("lastname");
				String adress = rs.getString("adress");
				
				res.add( new User(id, login, email, passw, lastn, firstn, adress));
			}
			con.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public static boolean deleteUser(int id) {
		try {
			Connection con = UtilConnexion.seConnecter();
			PreparedStatement ps = con.prepareStatement("DELETE FROM users WHERE id=?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
			con.close();
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			
			return false;
		}
	}
	
	public static boolean createUser(String login, String email, String passw, String firstn, String lastn, String adress) {
		
		try {
			Connection con = UtilConnexion.seConnecter();
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO users(login, mail, password, firstname, lastname, adress) VALUE (?,?,?,?,?,?)");
			ps.setString(1, login);
			ps.setString(2, email);
			ps.setString(3, passw);
			ps.setString(4, firstn);
			ps.setString(5, lastn);
			ps.setString(6, adress);			
			
			ps.executeUpdate();
			con.close();
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}	
	}
	
	public static User getOneUser(int id) {
		
		User u = null;
		
		try {
			Connection con = UtilConnexion.seConnecter();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if ( rs.next() == true) {
				u = new User(rs.getInt("id"), rs.getString("login"), rs.getString("mail"), rs.getString("password"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("adress"));
			}
			
			ps.executeUpdate();
			rs.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} return u;
	}
	
	public static boolean updateUser(int id, String login, String email, String passw, String firstn, String lastn, String adress) {
		
		try {
			Connection con = UtilConnexion.seConnecter();
			PreparedStatement ps = con.prepareStatement("UPDATE users SET login=?, mail=?, password=?, firstname=?, lastname=?, adress=? WHERE id=?");
			ps.setString(1,login);
			ps.setString(2, email);
			ps.setString(3, passw);
			ps.setString(4, firstn);
			ps.setString(5, lastn);
			ps.setString(6, adress);
			ps.setInt(7, id);
			
			ps.executeUpdate();
			con.close();
						
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
