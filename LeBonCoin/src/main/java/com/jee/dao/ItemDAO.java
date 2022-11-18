package com.jee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jee.modele.Item;

public class ItemDAO {
	
public static List<Item> getAllItems() {
		
		List<Item> res = new ArrayList<>();
		try {
			Connection con = UtilConnexion.seConnecter();
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM items");
			
			while (rs.next() ) {
				int id = rs.getInt("id");
				int userId = rs.getInt("user_id");
				String title = rs.getString("title");
				String descr = rs.getString("description");
				float price = rs.getFloat("price");
				String dateCrea = rs.getString("date_creation");
				String dateModif = rs.getString("date_modification");
				
				res.add( new Item(id, userId, title, descr, price, dateCrea, dateModif));
			}
			con.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public static boolean deleteItem(int id) {
		try {
			Connection con = UtilConnexion.seConnecter();
			PreparedStatement ps = con.prepareStatement("DELETE FROM items WHERE id=?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
			con.close();
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			
			return false;
		}
	}
	
	public static boolean createItem(int UserId, String title, String description, float price) {
		
		try {
			Connection con = UtilConnexion.seConnecter();
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO items(user_id, title, description, price) VALUE (?,?,?,?)");
			ps.setInt(1, UserId);
			ps.setString(2, title);
			ps.setString(3, description);
			ps.setFloat(4, price);			
			
			ps.executeUpdate();
			con.close();
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}	
	}
	
	public static Item getOneItem(int id) {
		
		Item i = null;
		
		try {
			Connection con = UtilConnexion.seConnecter();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM items WHERE id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if ( rs.next() == true) {
				i = new Item(rs.getInt("id"), rs.getInt("user_id"), rs.getString("title"), rs.getString("description"), rs.getFloat("price"), rs.getString("date_creation"), rs.getString("date_modification"));
			}
			
			ps.executeUpdate();
			rs.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} return i;
	}
	
	public static boolean updateItem(int UserId, String title, String description, float price) {
		
		try {
			Connection con = UtilConnexion.seConnecter();
			PreparedStatement ps = con.prepareStatement("UPDATE users SET title=?, description=?, price=?, date_modifaication=CURRENT_TIMESTAMP WHERE id=?");
			ps.setString(1,title);
			ps.setString(2, description);
			ps.setFloat(3, price);
			ps.setInt(4, UserId);
			
			ps.executeUpdate();
			con.close();
						
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
