package stopWatch;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import instrument.InstrumentWindow;
import login.LoginPanel;
import managers.FileManager;

public class StopWatchWindow extends JFrame
{
	private String filePath;
	private FileManager fileManager;
	private StopWatchPanel panel;
	
	private final int WIDTH = 400;
	private final int HEIGHT = 400;
	
	public StopWatchWindow(InstrumentWindow window)
	{
		panel = new StopWatchPanel(this, window);
		filePath = "assets/clock.png";
		fileManager = new FileManager(filePath);
		fileManager.setImage(this, filePath);
		
		this.setTitle("Stop Watch");
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.add(panel);
		this.setVisible(true);
	}
}
