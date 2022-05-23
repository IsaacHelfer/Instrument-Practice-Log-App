package stopWatch;

import javax.swing.JFrame;

import instrument.InstrumentPanel;
import instrument.InstrumentWindow;
import login.LoginPanel;
import managers.FileManager;

@SuppressWarnings("serial")
public class StopWatchWindow extends JFrame
{
	private String filePath;
	private FileManager fileManager;
	private StopWatchPanel panel;
	
	private final int WIDTH = 400;
	private final int HEIGHT = 400;
	
	public StopWatchWindow(InstrumentWindow window, InstrumentPanel instrumentPanel, LoginPanel loginPanel)
	{
		panel = new StopWatchPanel(this, window, instrumentPanel, loginPanel);
		filePath = "assets/clock.png";
		fileManager = new FileManager(filePath);
		fileManager.setImage(this, filePath);
		
		this.setTitle("Stop Watch");
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.add(panel);
		this.setVisible(true);
	}
}
