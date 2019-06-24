package myArrayList.util;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Devina Dhuri
 */
 
public class Results implements FileDisplayInterface, StdoutDisplayInterface 
{
	private String outFile;
	private PrintWriter writer;
	private String[] result = new String[100]; //dataStructure to store the testMethods
	int sizeResult = 0;

	/**
	 * constructor for results
	 * @param outFile - file for writing Result
	 */
	public Results(String outFile) 
	{
		this.outFile = outFile;
		for(int i=0; i < result.length; i++)
		{
			result[i] = "";
		}
	}
	
	/**
	* This Function will write output to the file.
	* @param String to write to file
	*/
	public void writeToFile(String s) 
	{
		try 
		{
			writer = new PrintWriter(outFile, "UTF-8");
			writer.println("The sum of all the values in the array list is: " + s);
			writer.close();
		} 
		catch (IOException e) 
		{
			System.err.println("Exit from Program");
			System.err.println("Error writing to file");
			System.exit(0);
		}
	}
		
	/**
	* This Function will write output to the terminal.
	* @param String to write to terminal.
	*/	
	public void writeToStdout(String s) 
	{
		System.out.println("The sum of all the values in the array list is: " + s);
		for(int i=0;i<sizeResult;i++)
		{
			System.out.println(result[i]);
		}
	}
	
	/**
	* This Function will store the test method results.
	* @param testName - name of test suite 
	* and testResult indicating Pass or Fail. 
	*/
	public void storeNewResult(String testName, String testResult) 
	{
		result[sizeResult++] = testName + " " + testResult;
	}

	/**
	* @return String representation of an object
	*/
	public String toString()
	{
		return "--------------------------" + "\n" + getClass().getName()+"@"+Integer.toHexString(hashCode()) + "\n" + "Output FileName:" + outFile + " \n " + "No of Tests:" + sizeResult + "\n" + "--------------------------" + "\n" ;
	}
}
