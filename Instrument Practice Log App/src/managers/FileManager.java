package managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FileManager 
{
	private File file;
	
	public FileManager(String filePath)
	{
		this.file = new File(filePath);
		
		if (!file.exists())
		{
			createNewFile();
		}
	}
	
	private void createNewFile() 
	{
		try 
		{
			file.createNewFile();
		} 
		catch (IOException e) 
		{
			System.out.println("Error creating a new file...");
			e.printStackTrace();
		}
	}
	
	// filling the hash map with the login information in the "login_info.txt"
	public void fillHashMap(HashMap<String, String> hashMap)
	{
		try
		{
			Scanner scan = new Scanner(file);
			
			while (scan.hasNextLine())
			{
				String data = scan.nextLine();
				
				String username = data.substring(0, data.indexOf("-"));
				String password = data.substring(data.indexOf("-") + 1);
				
				if (username.contains(" "))
				{
					username.substring(0, username.indexOf(" "));
				}
				
				if (password.contains(" "))
				{
					password.substring(0, password.indexOf(" "));
				}
				
				hashMap.put(username, password);
			}
			
			scan.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error filling hash map...");
			e.printStackTrace();
		}
	}
	
	public void printFileContents()
	{
		try
		{
			Scanner scan = new Scanner(file);
			
			while (scan.hasNextLine())
			{
				String data = scan.nextLine();
				
				System.out.println(data);
			}
			
			scan.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error printing file contents...");
			e.printStackTrace();
		}
	}
	
	public void addToFile(String username, String password)
	{
		try 
		{
			FileWriter fileEditor = new FileWriter(file, true);
			fileEditor.write(username + "-" + password + "\n");
			fileEditor.close();
		}
		catch (IOException e)
		{
			System.out.println("Error adding to file...");
			e.printStackTrace();
		}
	}
	
	public void addTimeToFile(String time)
	{
		try 
		{
			FileWriter fileEditor = new FileWriter(file, true);
			fileEditor.write(time + "\n");
			fileEditor.close();
		}
		catch (IOException e)
		{
			System.out.println("Error adding time to file...");
			e.printStackTrace();
		}
	}
	
	public boolean contains(String value)
	{
		try
		{
			Scanner scan = new Scanner(file);
			
			while (scan.hasNextLine())
			{
				String data = scan.nextLine();
				
				if (data.equals(value))
				{
					scan.close();
					return true;
				}
			}
			
			scan.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error when checking for contatins...");
			e.printStackTrace();
		}
		
		return false;
	}
	
	public void setImage(JFrame window, String filePath)
	{
		try 
		{
			window.setIconImage(ImageIO.read(new File(filePath)));
		} 
		catch (IOException e) 
		{
			System.out.println("Error setting image...");
			e.printStackTrace();
		}
	}
	
	public void updateScrollField(JTextArea textArea)
	{
		int num = 1;
		
		try
		{
			textArea.setText("");
			Scanner scan = new Scanner(file);
			
			while (scan.hasNextLine())
			{
				String data = scan.nextLine();
				
				textArea.append("[" + num + "] " + data + "\n");
				
				num++;
			}
			
			scan.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error updating scroll field contents...");
			e.printStackTrace();
		}
	}
	
	// for developer use only
	public void clearFile()
	{
		file.delete();
		createNewFile();
	}
}