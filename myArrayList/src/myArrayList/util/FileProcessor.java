package myArrayList.util;

import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Scanner; 
import java.io.File; 

/**
 * @author Devina Dhuri
 */
 
public class FileProcessor 
{
	BufferedReader reader;
	FileInputStream fis;
	String line = null;
	String inFile;
	int status=0;
	
	/**
	 * constructor for FileProcessor
	 * @param inFile - file to be processed
	 */
	public FileProcessor(String inFile) 
	{
		this.inFile = inFile;
		try
		{
			fis = new FileInputStream(inFile);
			reader = new BufferedReader(new InputStreamReader(fis));
		}
		catch(Exception e)
		{
			System.err.println("Exit from File Processor : Exiting Program");
			System.err.println("Error Opening the Input File");
			System.exit(0);
		}
	}
	
	/**
	 * method to read line from file line by line
	 * @return one line at a time from the input file
	 */
	public String readLine() throws IOException
	{
		try 
		{
			return reader.readLine();
		}
		catch (IOException e) 
		{
			System.err.println("Exit from File Processor : Exiting Program");
			System.err.println("Error Reading the Input File");
			System.exit(0);
		}	
		return null;
	}
	
	/**
	* @return String representation of an object
	*/
	public String toString()
	{
		return "--------------------------" + "\n" + getClass().getName()+"@"+Integer.toHexString(hashCode()) + "\n" + "Input FileName:" + inFile + " \n " + "--------------------------" + "\n";
	}
}
