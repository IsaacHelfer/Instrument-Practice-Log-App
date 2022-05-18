package main;

import javax.swing.SwingUtilities;

import login.LoginWindow;

public class Main 
{
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				LoginWindow window = new LoginWindow();
			}
		});
	}
}