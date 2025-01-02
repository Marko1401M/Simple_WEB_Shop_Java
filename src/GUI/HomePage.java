package GUI;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePage extends JPanel{
	GUI gui;
	JLabel naslov = new JLabel();
	Engine engine = Engine.getEngine();
	JButton openWebPage = new JButton();
	JButton showUsers = new JButton();
	JButton showOglase = new JButton();
	JButton addAdmin = new JButton();
	public HomePage(GUI gui) {
		this.gui = gui;
		this.setBounds(0, 0, 600, 600);
		this.setLayout(null);
		naslov.setBounds(250, 25, 450, 200);
		naslov.setText("Home page");
		naslov.setFont(new Font("Arial",Font.PLAIN,50));
		showUsers.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() instanceof JButton) {
					gui.setPage(new ShowUsersPage(gui));
				}
				
			}
		});
		showUsers.setText("Prikazi Sve Korisnike");
		showUsers.setBounds(250,250,250,50);
		showUsers.setFont(new Font("Arial",Font.PLAIN,20));
		showOglase.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() instanceof JButton) {
					gui.setPage(new ShowOglasiPage(gui));
				}
				
			}
		});
		showOglase.setText("Prikazi Sve Oglase");
		showOglase.setBounds(250,320,250,50);
		showOglase.setFont(new Font("Arial",Font.PLAIN,20));
		openWebPage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() instanceof JButton) {
					try {
					    Desktop.getDesktop().browse(new URL("http://localhost/KP/login.php").toURI());
					} catch (Exception ex) {}
				}
			}
		});
		openWebPage.setText("Otvori web sajt");
		openWebPage.setBounds(250, 390, 250, 50);
		openWebPage.setFont(new Font("Arial",Font.PLAIN,20));
		addAdmin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() instanceof JButton) {
					gui.setPage(new AddAdminPage(gui));
				}
			}
		});
		addAdmin.setText("Dodaj Admina");
		addAdmin.setBounds(250, 460, 250, 50);
		addAdmin.setFont(new Font("Arial",Font.PLAIN,20));
		this.add(addAdmin);
		this.add(openWebPage);
		this.add(showOglase);
		this.add(showUsers);
		this.setBackground(new Color(164,164,238));
		this.add(naslov);
	}
}
