package instrument;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import login.LoginPanel;
import login.LoginWindow;
import stopWatch.StopWatchWindow;

@SuppressWarnings("serial")
public class InstrumentPanel extends JPanel implements ActionListener
{
	private InstrumentWindow instrumentWindow;
	private LoginWindow loginWindow;
	private LoginPanel loginPanel;
	private JButton stopWatch;
	private JButton logOut;
	
	public InstrumentPanel(InstrumentWindow window, LoginWindow loginWindow, LoginPanel loginPanel)
	{	
		this.instrumentWindow = window;
		this.loginWindow = loginWindow;
		this.loginPanel = loginPanel;
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.requestFocus();
		
		stopWatch = new JButton();
		stopWatch.setText("Use Stop Watch");
		stopWatch.setVisible(true);
		stopWatch.setFont(new Font("Comic Sans", Font.PLAIN, 30));
		stopWatch.setFocusable(false);
		stopWatch.addActionListener(this);
		
		logOut = new JButton();
		logOut.setText("Log Out");
		logOut.setVisible(true);
		logOut.setFont(new Font("Comic Sans", Font.PLAIN, 30));
		logOut.setFocusable(false);
		logOut.addActionListener(this);
	
		this.add(stopWatch);
		this.add(logOut);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == stopWatch)
		{
			instrumentWindow.setVisible(false);
			new StopWatchWindow(instrumentWindow, loginPanel);
		}
		
		if (e.getSource() == logOut)
		{
			instrumentWindow.setVisible(false);
			loginWindow.setVisible(true);
		}
	}
}