package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import instrument.InstrumentWindow;
import managers.FileManager;

@SuppressWarnings("serial")
public class LoginPanel extends JPanel implements ActionListener
{
	private LoginPanel loginPanel;
	private LoginWindow loginWindow;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JTextField usernameField;
	private JTextField passwordField;
	private JButton signup;
	private JButton login;
	private HashMap<String, String> loginInfo;
	private FileManager textFileManager;
	private FileManager logFileManager;
	private String username;
	private String password;
	
	private String txtFile;
	private String logPath;
	
	private boolean usernamePicked = false;
	private boolean passwordPicked = false;
	
	public LoginPanel(LoginWindow frame)
	{
		this.setLayout(null);
		this.requestFocus();
		
		loginPanel = this;
		
		loginWindow = frame;
		loginInfo = new HashMap<String, String>();
		
		txtFile = "login_info.txt";
		textFileManager = new FileManager(txtFile);
		textFileManager.fillHashMap(loginInfo);
		//textFileManager.clearFile(); // (only use when need to clear file for development purposes)
		
		usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(40, 50, 62, 10);
		
		usernameField = new JTextField();
		usernameField.setBounds(usernameLabel.getX() + 80, usernameLabel.getY() - 9, 210, 30);
		usernameField.setName("usernameField");
		usernameField.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {
			// checking for changes of the username field
			public void changedUpdate(DocumentEvent e) 
			{
				changed(usernameField);
			}

			@Override
			public void insertUpdate(DocumentEvent e) 
			{
				changed(usernameField);
			}

			@Override
			public void removeUpdate(DocumentEvent e) 
			{
				changed(usernameField);
			}
		});
		
		passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(usernameLabel.getX(), usernameLabel.getY() + 50, 62, 10);
		
		passwordField = new JTextField();
		passwordField.setName("passwordField");
		passwordField.setBounds(passwordLabel.getX() + 80, usernameLabel.getY() + 40, 210, 30);
		passwordField.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {
			// checking for changes of the password field
			public void changedUpdate(DocumentEvent e) 
			{
				changed(passwordField);
			}

			@Override
			public void insertUpdate(DocumentEvent e) 
			{
				changed(passwordField);
			}

			@Override
			public void removeUpdate(DocumentEvent e) 
			{
				changed(passwordField);
			}
		});
		
		signup = new JButton();
		signup.setText("SIGN UP");
		signup.setFocusable(false);
		signup.addActionListener(this);
		signup.setEnabled(false);
		signup.setBounds(usernameLabel.getX() + 40, usernameLabel.getY() + 120, 100, 30);
		
		login = new JButton();
		login.setText("LOGIN");
		login.setFocusable(false);
		login.addActionListener(this);
		login.setEnabled(false);
		login.setBounds(usernameField.getX() + 85, usernameLabel.getY() + 120, 100, 30);
		
		this.add(usernameLabel);
		this.add(usernameField);
		this.add(passwordLabel);
		this.add(passwordField);
		this.add(signup);
		this.add(login);
	}
	
	public void changed(JTextField field)
	{
		if (field.getText().equals(""))
		{		
			signup.setEnabled(false);
			login.setEnabled(false);
			
			if (field.getName().equals("usernameField"))
			{
				usernamePicked = false;
			}
			else
			{
				passwordPicked = false;
			}
		}
		else
		{
			if (field.getName().equals("usernameField"))
			{
				usernamePicked = true;
			}
			else
			{
				passwordPicked = true;
			}
			
			if (usernamePicked && passwordPicked)
			{
				signup.setEnabled(true);
				login.setEnabled(true);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		username = "";
		password = "";
		
		if (e.getSource() == signup)
		{
			username = usernameField.getText();
			password = passwordField.getText();
			
			if (loginInfo.containsKey(username))
			{
				JOptionPane.showMessageDialog(null, "Username already exists.", "Login Error", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				if (username.length() > 20)
				{
					JOptionPane.showMessageDialog(null, "Username is too long. Max username length is 20.", "Login Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Signup Successful", "Signup Successful", JOptionPane.INFORMATION_MESSAGE);
					
					loginInfo.put(username, password);
					
					textFileManager.addToFile(username, password);
					
					logPath = "logs/" + username + "_log.txt";
					logFileManager = new FileManager(logPath);
				}
			}
		}
		
		if (e.getSource() == login)
		{
			username = usernameField.getText();
			password = passwordField.getText();
			
			if (loginInfo.containsKey(username) && loginInfo.containsValue(password))
			{
				SwingUtilities.invokeLater(new Runnable() {
				    public void run() {
				    	loginWindow.setVisible(false);
				        new InstrumentWindow(loginWindow, loginPanel);
				    }
				});
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Username or password is incorrect.", "Login Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public String getFilePath()
	{
		return this.logPath;
	}
}
