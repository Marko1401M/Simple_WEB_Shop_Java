package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame{
	LoginPage login;
	HomePage homePage;
	JPanel current;
	public GUI() {
		login = new LoginPage(this);
		setBounds(500,150,800,800);
		getContentPane().add(login);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	public void logIn() {
		this.getContentPane().remove(login);
		homePage = new HomePage(this);
		this.getContentPane().add(homePage);
		this.getContentPane().revalidate();
		this.getContentPane().repaint();
		current = homePage;
		System.out.println("lalalal");
	}
	public void setPage(JPanel newPage) {
		this.getContentPane().remove(current);
		current = newPage;
		this.getContentPane().add(current);
		this.getContentPane().revalidate();
		this.getContentPane().repaint();
	}
}
