package stopWatch;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StopWatchPanel extends JPanel implements ActionListener
{
	private JButton startButton;
	private JButton endButton;
	private StopWatch stopWatch;
	
	public StopWatchPanel()
	{
		this.setLayout(null);
		
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
			
			JTextField timeLabel = new JTextField();
			timeLabel.setFont(new Font("Comic Sans", Font.BOLD, 55));
			timeLabel.setBounds(140, 0, 300, 100);
			timeLabel.setEditable(false);
			timeLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
			this.add(timeLabel);
			
			stopWatch = new StopWatch(timeLabel);
			
			stopWatch.start();
		}
		
		if (e.getSource() == endButton)
		{
			stopWatch.stop();
			
			startButton.setVisible(true);
		}
	}
}
