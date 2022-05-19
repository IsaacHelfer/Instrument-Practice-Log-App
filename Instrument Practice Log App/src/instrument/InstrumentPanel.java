package instrument;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import login.LoginPanel;
import stopWatch.StopWatchWindow;

public class InstrumentPanel extends JPanel implements ActionListener
{
	private InstrumentWindow instrumentWindow;
	private LoginPanel loginPanel;
	private JButton stopWatch;
	
	public InstrumentPanel(InstrumentWindow window, LoginPanel loginPanel)
	{	
		this.instrumentWindow = window;
		this.loginPanel = loginPanel;
		
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
		new StopWatchWindow(instrumentWindow, loginPanel);
	}
}