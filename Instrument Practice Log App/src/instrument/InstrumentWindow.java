package instrument;

import javax.swing.JFrame;

import login.LoginPanel;
import managers.FileManager;

public class InstrumentWindow extends JFrame
{
	private final int WIDTH = 400;
	private final int HEIGHT = 600;
	private InstrumentPanel panel;
	private String filePath;
	private FileManager fileManager;
	
	public InstrumentWindow(LoginPanel loginPanel)
	{
		panel = new InstrumentPanel();
		filePath = "assets/guitar.png";
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