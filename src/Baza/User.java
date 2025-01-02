package Baza;

public class User {
	int id;
	String username;
	public User(int id, String username) {
		this.id = id;
		this.username = username;
	}
	@Override
	public String toString() {
		return id + " : " + username;
	}
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
}
