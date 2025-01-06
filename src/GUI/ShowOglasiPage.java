package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Baza.Oglas;

public class ShowOglasiPage extends JPanel{
	GUI gui;
	JButton nazad = new JButton();
	Engine engine = Engine.getEngine();
	JLabel naslov = new JLabel();
	JScrollPane prikazOglasa = new JScrollPane();
	public ShowOglasiPage(GUI gui) {
		this.gui = gui;
		this.setBounds(0,0,600,600);
		this.setBackground(new Color(114,114,226));
		this.setLayout(null);
		naslov.setBounds(10, 5, 100, 20);
		naslov.setText("Prikaz oglasa:");
		prikazOglasa.setBounds(50,25,350,550);
		nazad.setText("Nazad");
		nazad.setBounds(25,540,100,50);
		nazad.setFont(new Font("Arial",Font.PLAIN,20));
		nazad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gui.setPage(new HomePage(gui));
			}
		});
		List<Oglas> oglasi = engine.getOglasi();
		JPanel temp = new JPanel();
		temp.setLayout(new BoxLayout(temp, BoxLayout.Y_AXIS));
		for(Oglas oglas : oglasi) {
			JPanel temp2 = new JPanel();
			temp2.setLayout(new FlowLayout(FlowLayout.LEFT));
			JButton btn = new JButton();
			btn.setText("Obrisi");
			btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					engine.obrisiOglas(oglas.getId());
					osveziGUI();
				}
			});
			JButton btn2 = new JButton();
			btn2.setText("Prikazi");
			btn2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(e.getSource() instanceof JButton) {
						engine.setIdOglasa(oglas.getId());
						gui.setPage(new ShowOglas(gui));
					}
				}
			});
			JLabel temp3 = new JLabel();
			temp3.setText("Naslov: " + oglas.getNaslov() + ", Autor: " + oglas.getAutor().getUsername());
			temp2.add(btn);
			temp2.add(btn2);
			temp2.add(temp3);
			temp2.setSize(250, 50);
			temp.add(temp2);
			

		}
		prikazOglasa.setViewportView(temp);
		this.add(naslov);
		this.add(nazad);
		this.add(prikazOglasa);
	}
	public void osveziGUI() {
		List<Oglas> oglasi = engine.getOglasi();
		JPanel temp = new JPanel();
		this.remove(prikazOglasa);
		prikazOglasa = new JScrollPane();
		prikazOglasa.setBounds(50,25,250,400);
		temp.setLayout(new BoxLayout(temp, BoxLayout.Y_AXIS));
		for(Oglas oglas : oglasi) {
			JPanel temp2 = new JPanel();
			temp2.setLayout(new FlowLayout(FlowLayout.LEFT));
			JButton btn = new JButton();
			btn.setText("Obrisi");
			btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					engine.obrisiOglas(oglas.getId());
					osveziGUI();
				}
			});
			JLabel temp3 = new JLabel();
			temp3.setText("Naslov: " + oglas.getNaslov() + ", Autor: " + oglas.getAutor().getUsername());
			temp2.add(btn);
			temp2.add(temp3);
			temp2.setSize(250, 50);
			temp.add(temp2);
			

		}
		prikazOglasa.setViewportView(temp);
		this.add(naslov);
		this.add(nazad);
		this.add(prikazOglasa);
		this.repaint();
		this.revalidate();
	}
	
}
