package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class InstrumentPanel extends JPanel implements ActionListener
{
	private JButton startButton;
	private JButton endButton;
	private StopWatch stopWatch;
	
	public InstrumentPanel(InstrumentWindow instrumentWindow, LoginPanel panel)
	{
		this.setLayout(null);
		
		startButton = new JButton();
		startButton.setText("START TIMER");
		startButton.setVisible(true);
		startButton.setFont(new Font("Comic Sans", Font.PLAIN, 20));
		startButton.setFocusable(false);
		startButton.setBounds(95, 200, 200, 100);
		startButton.addActionListener(this);
		
		endButton = new JButton();
		endButton.setText("END");
		endButton.setVisible(false);
		endButton.setFont(new Font("Comic Sans", Font.PLAIN, 20));
		endButton.setFocusable(false);
		endButton.addActionListener(this);
		
		this.add(startButton);
		this.add(endButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == startButton)
		{	
			startButton.setVisible(false);
			endButton.setVisible(true);
			
			this.setLayout(new FlowLayout(FlowLayout.CENTER));
			
			JLabel timeLabel = new JLabel();
			timeLabel.setFont(new Font("Comic Sans", Font.BOLD, 55));
			
			this.add(timeLabel);
			
			stopWatch = new StopWatch(timeLabel);
			
			stopWatch.start();
		}
		
		if (e.getSource() == endButton)
		{
			stopWatch.stop();
			
			startButton.setVisible(false);
		}
	}
}