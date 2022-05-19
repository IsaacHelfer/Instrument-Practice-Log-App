package stopWatch;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import instrument.InstrumentWindow;
import login.LoginPanel;

public class StopWatchPanel extends JPanel implements ActionListener
{
	private StopWatchWindow stopWatchWindow;
	private InstrumentWindow instrumentWindow;
	private LoginPanel loginPanel;
	private JButton startButton;
	private JButton endButton;
	private JButton backToHome;
	private JTextField timeLabel;
	private StopWatch stopWatch;
	
	public StopWatchPanel(StopWatchWindow stopWatchWindow, InstrumentWindow instrumentWindow, LoginPanel loginPanel)
	{
		this.stopWatchWindow = stopWatchWindow;
		this.instrumentWindow = instrumentWindow;
		this.loginPanel = loginPanel;
		
		this.setLayout(null);
		this.requestFocus();
		
		startButton = new JButton();
		startButton.setText("START");
		startButton.setVisible(true);
		startButton.setFont(new Font("Comic Sans", Font.PLAIN, 30));
		startButton.setFocusable(false);
		startButton.setBounds(95, 200, 200, 100);
		startButton.setBackground(Color.GREEN);
		startButton.addActionListener(this);
		
		endButton = new JButton();
		endButton.setText("END");
		endButton.setVisible(false);
		endButton.setFont(new Font("Comic Sans", Font.PLAIN, 30));
		endButton.setFocusable(false);
		endButton.setBounds(95, 200, 200, 100);
		endButton.setBackground(Color.RED);
		endButton.addActionListener(this);
		
		backToHome = new JButton();
		backToHome.setText("Back To Home Page");
		backToHome.setVisible(true);
		backToHome.setFont(new Font("Comic Sans", Font.PLAIN, 17));
		backToHome.setFocusable(false);
		backToHome.setBounds(0, 312, 200, 50);
		backToHome.setBackground(Color.RED);
		backToHome.addActionListener(this);
		
		timeLabel = new JTextField();
		timeLabel.setBounds(135, 0, 300, 100);
		timeLabel.setFont(new Font("Comic Sans", Font.BOLD, 55));
		timeLabel.setEditable(false);
		timeLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
	
		this.add(startButton);
		this.add(endButton);
		this.add(backToHome);
		this.add(timeLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == startButton)
		{	
			startButton.setVisible(false);
			endButton.setVisible(true);
			backToHome.setVisible(false);
		
			stopWatch = new StopWatch(timeLabel, loginPanel.getUsername());
			
			stopWatch.start();
		}
		
		if (e.getSource() == endButton)
		{
			stopWatch.stop();
			
			startButton.setVisible(true);
			endButton.setVisible(false);
			backToHome.setVisible(true);
		}
		
		if (e.getSource() == backToHome)
		{
			stopWatchWindow.setVisible(false);
			instrumentWindow.setVisible(true);
		}
	}
}
