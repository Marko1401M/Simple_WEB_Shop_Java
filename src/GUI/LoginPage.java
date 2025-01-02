package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage extends JPanel{
	GUI gui;
	JLabel naslov = new JLabel();
	JLabel username = new JLabel();
	JLabel password = new JLabel();
	Engine engine = Engine.getEngine();
	JTextField usernameInput = new JTextField(25);
	JPasswordField passwordInput = new JPasswordField(25);
	JButton loginButton = new JButton();
	public LoginPage(GUI gui) {
		this.gui = gui;
		setLayout(null);
		naslov.setText("Login page");
		naslov.setFont(new Font("Arial",Font.PLAIN,50));
		naslov.setBounds(250, 50, 250, 250);
		username.setBounds(250, 150, 250, 200);
		username.setText("Unesite username:");
		username.setFont(new Font("Arial",Font.PLAIN,25));
		usernameInput.setBounds(465,240,100,25);
		password.setBounds(250, 180, 250, 200);
		password.setText("Unesite password:");
		password.setFont(new Font("Arial",Font.PLAIN,25));
		passwordInput.setBounds(465, 270, 100, 25);
		loginButton.setFont(new Font("Arial",Font.PLAIN,20));
		loginButton.setBounds(300, 300, 100, 50);
		loginButton.setText("Login");
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() instanceof JButton) {
					String username = usernameInput.getText();
					char[] temp = passwordInput.getPassword();
					String password = new String(temp);
					if(engine.checkLogin(username, password)) {
						System.out.println("Uspesan Login!");
						gui.logIn();
					}
					else System.out.println("Neuspesan Login!");
					
				}
				
			}
		});
		this.add(loginButton);
		this.add(passwordInput);
		//password.setText
		this.add(password);
		this.add(usernameInput);
		this.add(username);
		this.add(naslov);
		setBounds(0, 0, 600, 600);
	}
}
