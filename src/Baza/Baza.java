package Baza;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Baza {
	Connection con;
	
	public Baza(){
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/db_shop","root","");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void print() {
		try {
			PreparedStatement stmt =  con.prepareStatement("SELECT * from user");
			ResultSet res = stmt.executeQuery();
			while(res.next()) {
				System.out.println(res.getInt("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ResultSet getUsers() {
		try {
			PreparedStatement stmt =  con.prepareStatement("SELECT * from user");
			ResultSet res = stmt.executeQuery();
			return res;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet getOglasi() {
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * from oglas");
			ResultSet res = stmt.executeQuery();
			return res;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public boolean checkLogin(String username, String password) {
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * from admin where username = '" + username + "' and password='" + password +"'");
			ResultSet res = stmt.executeQuery();
			if(res.next()) return true;
			return false;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public void deleteUser(int id) {
		try {
			PreparedStatement stmt = con.prepareStatement("DELETE FROM USER WHERE id = '" + id + "'");
			stmt.execute();
			stmt = con.prepareStatement("DELETE FROM oglas where id_korisnika = '" + id + "'");
			stmt.execute();
			stmt = con.prepareStatement("DELETE FROM follow where id_oglasa = '" + id + "'");
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public User getUserById(int id) {
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * from user where id = '" + id + "'");
			ResultSet res = stmt.executeQuery();
			while(res.next()) {
				return  new User(res.getInt("id"), res.getString("username"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void deleteOglas(int id) {
		try {
			PreparedStatement stmt = con.prepareStatement("DELETE FROM oglas where id = '" + id + "'");
			stmt.execute();
			stmt = con.prepareStatement("DELETE FROM follow where id_oglasa = '" + id + "'");
			stmt.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void addAdmin(String username, String password) {
		try {
			PreparedStatement stmt = con.prepareStatement("INSERT into admin(username, password) VALUES('" + username + "','"+ password + "')");
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public Oglas getOglasById(int id) {
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * from oglas where id= '" + id + "'");
			ResultSet res = stmt.executeQuery();
			while(res.next()) {
				return new Oglas(res.getInt("id"), res.getString("naslov"), getUserById(res.getInt("id_korisnika")),res.getString("path_slike"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
