import java.sql.SQLException;

import Baza.Baza;
import GUI.GUI;

public class Main {
	public static void main(String[] args ) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		GUI prikaz = new GUI();
	}
}
