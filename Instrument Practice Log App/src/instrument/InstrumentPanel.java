package instrument;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import stopWatch.StopWatchWindow;

public class InstrumentPanel extends JPanel implements ActionListener
{
	private InstrumentWindow instrumentWindow;
	private JButton stopWatch;
	
	public InstrumentPanel(InstrumentWindow window)
	{	
		instrumentWindow = window;
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.requestFocus();
		
		stopWatch = new JButton();
		stopWatch.setText("Use Stop Watch");
		stopWatch.setVisible(true);
		stopWatch.setFont(new Font("Comic Sans", Font.PLAIN, 30));
		stopWatch.setFocusable(false);
		stopWatch.addActionListener(this);
	
		this.add(stopWatch);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		instrumentWindow.setVisible(false);
		new StopWatchWindow(instrumentWindow);
	}
}