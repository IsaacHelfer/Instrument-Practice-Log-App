package stopWatch;

import javax.swing.JFrame;

import login.LoginPanel;
import managers.FileManager;

public class StopWatchWindow extends JFrame
{
	private final int WIDTH = 400;
	private final int HEIGHT = 600;
	private String filePath;
	private FileManager fileManager;
	private StopWatchPanel panel;
	
	public StopWatchWindow()
	{
		panel = new StopWatchPanel();
		filePath = "assets/clock.png";
		fileManager = new FileManager(filePath);
		fileManager.setImage(this, filePath);
		
		this.setTitle("Instrument Practice Log");
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.add(panel);
		this.setVisible(true);
	}
	
	public int getWidth()
	{
		return this.WIDTH;
	}
	
	public int getHeight()
	{
		return this.HEIGHT;
	}
}
