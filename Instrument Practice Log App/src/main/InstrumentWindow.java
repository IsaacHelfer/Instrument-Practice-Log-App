package main;

import javax.swing.JFrame;

public class InstrumentWindow extends JFrame
{
	private final int WIDTH = 400;
	private final int HEIGHT = 600;
	private String filePath;
	private FileManager fileManager;
	
	public InstrumentWindow()
	{
		filePath = "assets/guitar.png";
		fileManager = new FileManager(filePath);
		fileManager.setImage(this, filePath);
		
		this.setTitle("Instrument Practice Log");
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}