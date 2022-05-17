package main;

import javax.swing.JFrame;

public class InstrumentWindow extends JFrame
{
	private final int WIDTH = 400;
	private final int HEIGHT = 600;
	
	public InstrumentWindow()
	{
		this.setTitle("Instrument Practice Log");
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}