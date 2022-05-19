package login;

import javax.swing.JFrame;

import managers.FileManager;

@SuppressWarnings("serial")
public class LoginWindow extends JFrame
{
	private final int WIDTH = 400;
	private final int HEIGHT = 300;
	private LoginPanel panel;
	private FileManager fileManager;
	private String filePath;
	
	public LoginWindow()
	{
		panel = new LoginPanel(this);
		filePath = "assets/lock.png";
		fileManager = new FileManager(filePath);
		fileManager.setImage(this, filePath);
		
		this.setTitle("Login Page");
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.add(panel);
	}
}