package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class TextFileManager 
{
	private File file;
	
	public TextFileManager(String filePath)
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
			
			e.printStackTrace();
		}
	}

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
				
				hashMap.put(username, password);
			}
			
			scan.close();
		}
		catch (FileNotFoundException e)
		{
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
			e.printStackTrace();
		}
		
		return false;
	}
	
	// for developer use only
	public void clearFile()
	{
		file.delete();
		createNewFile();
	}
}