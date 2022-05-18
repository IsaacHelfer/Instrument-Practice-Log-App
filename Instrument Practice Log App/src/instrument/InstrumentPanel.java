package instrument;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import stopWatch.StopWatchWindow;

public class InstrumentPanel extends JPanel implements ActionListener
{
	private JButton useStopWatch;
	
	public InstrumentPanel()
	{	
		this.setLayout(null);
		
		useStopWatch = new JButton();
		useStopWatch.setText("Use Stop Watch");
		useStopWatch.setBounds(100, 100, 200, 100);
		
		this.add(useStopWatch);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		System.out.println("test");
		StopWatchWindow stopWatchWindow = new StopWatchWindow();
	}
}