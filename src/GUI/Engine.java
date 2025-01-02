package GUI;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Baza.Baza;
import Baza.Oglas;
import Baza.SHA1;
import Baza.User;

public class Engine {
	private Baza baza;
	private static Engine engine = null;
	String username;
	int id;
	private Engine() {
		baza = new Baza();
	}
	
	public static synchronized Engine getEngine() {
		if(engine == null) {
			engine = new Engine();
		}
		return engine;
	}
	
	public boolean checkLogin(String username, String password) {
		if(baza.checkLogin(username, SHA1.SHA1(password))) {
			this.username = username;
			return true;
		}
		return false;
	}
	public List<User> getUsers() {
		ResultSet res = baza.getUsers();
		List<User> lista = new ArrayList<User>();
		try {
			while(res.next()) {
				lista.add(new User(res.getInt("id"), res.getString("username")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	public List<Oglas> getOglasi() {
		ResultSet res = baza.getOglasi();
		List<Oglas> lista = new ArrayList<Oglas>();
		try {
			while(res.next()) {
				User temp = baza.getUserById(res.getInt("id_korisnika"));
				lista.add(new Oglas(res.getInt("id"),res.getString("naslov"),temp, res.getString("path_slike")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	public void ban(int id) {
		this.baza.deleteUser(id);
	}
	public void obrisiOglas(int id) {
		baza.deleteOglas(id);
	}
	public void addAdmin(String username, String password) {
		baza.addAdmin(username, SHA1.SHA1(password));
	}
}
