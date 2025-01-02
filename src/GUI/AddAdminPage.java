package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AddAdminPage extends JPanel{
	GUI gui;
	JLabel inp_username = new JLabel();
	JLabel inp_password = new JLabel();
	JLabel naslov = new JLabel();
	JTextField username = new JTextField();
	JPasswordField password = new JPasswordField();
	JButton addAdminButton = new JButton();
	Engine engine = Engine.getEngine();
	JButton nazad = new JButton();
	public AddAdminPage(GUI gui) {
		this.gui = gui;
		setLayout(null);
		naslov.setText("Add admin page");
		naslov.setFont(new Font("Arial",Font.PLAIN,50));
		naslov.setBounds(250, 50, 400, 250);
		inp_username.setBounds(250, 150, 250, 200);
		inp_username.setText("Unesite username:");
		inp_username.setFont(new Font("Arial",Font.PLAIN,25));
		username.setBounds(465,240,100,25);
		inp_password.setBounds(250, 180, 250, 200);
		inp_password.setText("Unesite password:");
		inp_password.setFont(new Font("Arial",Font.PLAIN,25));
		password.setBounds(465, 270, 100, 25);
		addAdminButton.setBounds(300, 300, 200, 50);
		addAdminButton.setFont(new Font("Arial",Font.PLAIN,25));
		addAdminButton.setText("Dodaj admina");
		addAdminButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() instanceof JButton) {
					String user = username.getText();
					char[] pass = password.getPassword();
					engine.addAdmin(user, new String(pass));
					osveziGUI();
				}
			}
		});
		nazad.setText("Nazad");
		nazad.setBounds(25,540,100,50);
		nazad.setFont(new Font("Arial",Font.PLAIN,20));
		nazad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() instanceof JButton) {
					gui.setPage(new HomePage(gui));
				}
			}
		});
		this.add(nazad);
		this.add(naslov);
		this.add(inp_username);
		this.add(username);
		this.add(inp_password);
		this.add(password);
		this.add(addAdminButton);
		this.setBackground(new Color(80,224,205));
		this.setBounds(0,0,600,600);
	}
	public void osveziGUI() {
		username.setText("");
		password.setText("");
		JOptionPane op = new JOptionPane();
		JOptionPane.showConfirmDialog(this, "Admin je uspesno dodat!","Naslov", JOptionPane.OK_CANCEL_OPTION);
		this.repaint();
		this.revalidate();
	}
}
