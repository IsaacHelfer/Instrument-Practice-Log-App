package main;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class StopWatch
{
	private Timer timer;
	private TimerTask timerTask;
	private int seconds;
	private int minutes;
	private int hours;
	
	public StopWatch(JLabel label)
	{
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
				
				updateLabel(label, seconds, minutes, hours);
			}
		};
	}
	
	public void start()
	{
		timer.scheduleAtFixedRate(timerTask, 1000, 1000);
	}
	
	public void stop()
	{
		System.out.println("stop");
	}
	
	public void restart()
	{
		
	}
	
	public void updateLabel(JLabel label, long seconds, int minutes, int hours)
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
}
