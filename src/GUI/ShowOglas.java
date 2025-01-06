package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.net.http.HttpRequest;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Baza.Oglas;
import Baza.User;

public class ShowOglas extends JPanel{
	JButton nazad = new JButton();
	Engine engine = Engine.getEngine();
	JPanel info = new JPanel();
	ImageIcon image = new ImageIcon();
	JPanel imagePanel = new JPanel();
	User autor;
	Oglas oglas;
	GUI gui;
	public ShowOglas(GUI gui) {
		this.gui = gui;
		
		oglas = engine.getOglasById(engine.getIdOglasa());
		autor = oglas.getAutor();
		JLabel aboutAuthor = new JLabel();
		aboutAuthor.setText("Autor: " + autor.getUsername());
		aboutAuthor.setFont(new Font("Arial", Font.PLAIN, 25));
		
		JLabel naslovOglasa = new JLabel();
		naslovOglasa.setText("Naslov: " + oglas.getNaslov());
		naslovOglasa.setFont(new Font("Arial", Font.PLAIN, 25));
		
		JLabel temp = new JLabel();
		Image img =new ImageIcon("C:\\wamp64\\www\\KP\\" + oglas.getPath_slike()).getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
		temp.setIcon(new ImageIcon(img));
		temp.setBounds(300, 15, 300, 300);
		
		this.add(temp);
		info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
		info.setBounds(15, 15, 250, 500);
		info.add(aboutAuthor);
		info.add(naslovOglasa);
		
		this.add(info);
		nazad.setText("Nazad");
		nazad.setBounds(25,540,100,50);
		nazad.setFont(new Font("Arial",Font.PLAIN,20));
		nazad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gui.setPage(new ShowOglasiPage(gui));
			}
		});
		
		add(nazad);
		
		setLayout(null);
		setBounds(0,0,600,600);
		setVisible(true);
		setBackground(new Color(255,250,205));
	}
}
