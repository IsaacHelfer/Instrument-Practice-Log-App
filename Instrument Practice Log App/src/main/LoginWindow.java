package main;

import javax.swing.JFrame;

public class LoginWindow extends JFrame
{
	private final int WIDTH = 400;
	private final int HEIGHT = 300;
	private LoginPanel panel;
	
	public LoginWindow()
	{
		panel = new LoginPanel(this);
		
		this.setTitle("Login Page");
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.add(panel);
	}
}