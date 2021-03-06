package instrument;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;

import login.LoginPanel;
import login.LoginWindow;
import managers.FileManager;
import stopWatch.StopWatchWindow;

@SuppressWarnings("serial")
public class InstrumentPanel extends JPanel implements ActionListener
{
	private InstrumentWindow instrumentWindow;
	private InstrumentPanel instrumentPanel;
	private LoginWindow loginWindow;
	private LoginPanel loginPanel;
	private FileManager fileManager;
	private JButton stopWatch;
	private JButton logOut;
	private JButton addLog;
	private JButton removeLog;
	private JTextArea logArea;
	private JScrollPane logField;
	private JViewport logFieldView;
	
	public InstrumentPanel(InstrumentWindow window, LoginWindow loginWindow, LoginPanel loginPanel)
	{	
		this.instrumentPanel = this;
		this.instrumentWindow = window;
		this.loginWindow = loginWindow;
		this.loginPanel = loginPanel;
		this.fileManager = new FileManager("logs/" + loginPanel.getUsername() + "_log.txt");
		
		this.setLayout(null);
		this.requestFocus();
		
		logOut = new JButton();
		logOut.setBounds(285, 0, 100, 30);
		logOut.setText("Log Out");
		logOut.setVisible(true);
		logOut.setFont(new Font("Comic Sans", Font.PLAIN, 15));
		logOut.setFocusable(false);
		logOut.addActionListener(this);
		
		logArea = new JTextArea();
		logArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		logArea.setFont(new Font("Comic Sans", Font.PLAIN, 30));
		logArea.setEditable(false);
		
		logField = new JScrollPane(logArea);
		logField.setBounds(60, 60, 270, 200);
		logField.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		addLog = new JButton();
		addLog.setBounds(60, 280, 100, 50);
		addLog.setText("Add Log");
		addLog.setVisible(true);
		addLog.setFont(new Font("Comic Sans", Font.PLAIN, 15));
		addLog.setFocusable(false);
		addLog.addActionListener(this);
		
		removeLog = new JButton();
		removeLog.setBounds(210, 280, 120, 50);
		removeLog.setText("Remove Log");
		removeLog.setVisible(true);
		removeLog.setFont(new Font("Comic Sans", Font.PLAIN, 15));
		removeLog.setFocusable(false);
		removeLog.addActionListener(this);
		
		stopWatch = new JButton();
		stopWatch.setText("Use Stop Watch");
		stopWatch.setBounds(90, 350, 200, 50);
		stopWatch.setVisible(true);
		stopWatch.setFont(new Font("Comic Sans", Font.PLAIN, 15));
		stopWatch.setFocusable(false);
		stopWatch.addActionListener(this);
		
		fileManager.updateScrollField(logArea);
		
		this.add(stopWatch);
		this.add(logOut);
		this.add(logField);
		this.add(addLog);
		this.add(removeLog);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == stopWatch)
		{
			SwingUtilities.invokeLater(new Runnable() {
			    public void run() {
			    	instrumentWindow.setVisible(false);
			    	new StopWatchWindow(instrumentWindow, instrumentPanel, loginPanel);
			    }
			});
		}
		
		if (e.getSource() == logOut)
		{
			instrumentWindow.setVisible(false);
			loginWindow.setVisible(true);
		}
		
		if (e.getSource() == addLog)
		{
			System.out.println("add log");
		}
		
		if (e.getSource() == removeLog)
		{
			System.out.println("remove log");
		}
	}
	
	public FileManager getFileManager()
	{
		return this.fileManager;
	}
	
	public JTextArea getTextArea()
	{
		return this.logArea;
	}
}