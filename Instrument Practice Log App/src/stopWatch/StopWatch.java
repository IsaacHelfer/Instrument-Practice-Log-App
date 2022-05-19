package stopWatch;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JTextField;

import managers.FileManager;

public class StopWatch
{
	private Timer timer;
	private FileManager fileManager;
	private TimerTask timerTask;
	private JTextField label;
	private int seconds;
	private int minutes;
	private int hours;
	private String time;
	
	private boolean stop = false;
	
	public StopWatch(JTextField label)
	{
		//fileManager = new FileManager();
		// access log file for user
		this.label = label;
		
		seconds = 0;
		minutes = 0;
		hours = 0;
		
		timer = new Timer();
		timerTask = new TimerTask () {
			public void run() {
				seconds++;
				
				if (seconds == 60)
				{
					minutes++;
					seconds = 0;
				}
				
				if (minutes == 60)
				{
					hours++;
					minutes = 0;
				}
				
				if (!stop)
				{
					updateLabel(label, seconds, minutes, hours);
				}
			}
		};
	}
	
	public void start()
	{
		timer.scheduleAtFixedRate(timerTask, 1000, 1000);
	}
	
	public void stop()
	{
		this.stop = true;

		String time = label.getText();
		
		fileManager.addTimeToFile(time);
		
		label.setText("");
	}
	
	public void updateLabel(JTextField label, long seconds, int minutes, int hours)
	{
		if (hours < 1)
		{
			if (seconds < 10)
			{
				label.setText(minutes + ":0" + seconds);
			}
			else
			{
				label.setText(minutes + ":" + seconds);
			}
		}
		else
		{
			label.setText(hours + ":" + minutes + "" + seconds);
		}
	}
	
	public String getTime()
	{
		return this.time;
	}
}
