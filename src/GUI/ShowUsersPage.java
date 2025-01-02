package GUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Baza.User;

public class ShowUsersPage extends JPanel{
	GUI gui;
	JScrollPane prikazKorisnika = new JScrollPane();
	JLabel naslov = new JLabel();
	Engine engine = Engine.getEngine();
	JButton nazad = new JButton();
	int x = 0;
	int y = 0;
	int height = 50;
	int width = 200;
	public ShowUsersPage(GUI gui) {
		this.gui = gui;
		this.setLayout(null);
		this.setBounds(0,0,600,600);
		this.setBackground(new Color(80, 224, 205));
		nazad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gui.setPage(new HomePage(gui));
			}
		});
		prikazKorisnika.setBounds(50,25,250,400);
		
		List<User> lista = engine.getUsers();
		naslov.setText("Prikaz svih korisnika:");
		JPanel temp3 = new JPanel();
		nazad.setText("Nazad");
		nazad.setBounds(25,540,100,50);
		nazad.setFont(new Font("Arial",Font.PLAIN,20));
		temp3.setLayout(new BoxLayout(temp3, BoxLayout.Y_AXIS));
		for(User user : lista) {
			JPanel temp = new JPanel();
			temp.setLayout(new FlowLayout(FlowLayout.LEFT));
			JButton btn = new JButton();
			btn.setText("BAN");
			btn.setBackground(Color.red);
			btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					engine.ban(user.getId());
					osveziGUI();
				}
			});
			
			JLabel temp2 = new JLabel();
			temp2.setText(user.getUsername());
			temp.add(temp2);
			temp.add(btn);
			temp3.add(temp);
			System.out.println(user);
		}
		prikazKorisnika.setViewportView(temp3);
		this.add(naslov);
		this.add(prikazKorisnika);
		this.add(nazad);
	}
	public void osveziGUI() {
		JPanel temp3 = new JPanel();
		this.remove(prikazKorisnika);
		prikazKorisnika = new JScrollPane();
		prikazKorisnika.setBounds(50,25,250,400);
		temp3.setLayout(new BoxLayout(temp3, BoxLayout.Y_AXIS));
		List<User> lista = engine.getUsers();
		for(User user : lista) {
			JPanel temp = new JPanel();
			temp.setLayout(new FlowLayout(FlowLayout.LEFT));
			JButton btn = new JButton();
			btn.setText("BAN");
			btn.setBackground(Color.red);
			btn.setText("BAN");
			btn.setBackground(Color.red);
			btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					engine.ban(user.getId());
					osveziGUI();
				}
			});
			JLabel temp2 = new JLabel();
			temp2.setText(user.getUsername());
			temp.add(btn);
			temp.add(temp2);
			temp3.add(temp);
			System.out.println(user);
		}
		prikazKorisnika.setViewportView(temp3);
		this.add(prikazKorisnika);
		this.repaint();
		this.revalidate();
	}
}
