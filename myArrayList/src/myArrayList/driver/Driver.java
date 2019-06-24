package myArrayList.driver;

import myArrayList.MyArrayList;
import myArrayList.util.Results;
import myArrayList.util.FileProcessor;
import myArrayList.test.MyArrayListTest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * @author Devina Dhuri
 */
public class Driver 
{
	public static void main(String[] args)
	{
		String inFile="";
		String line;
		String OutFile="";
		int data;
		int sum;		
		try
		{
			//validation check for arguments.
			if (args.length != 2 || args[0].equals("${arg0}") || args[1].equals("${arg1}"))
			{
				throw new IllegalArgumentException("Error Illegal Number of Arguments");
			}
			
			else if(args.length == 2)
			{
				if (args[0].equals("${arg0}") || args[1].equals("${arg1}"))
				{
					throw new Exception("Error Incorrect Input or Output file");
				}
				else
				{
					inFile = args[0];
					OutFile = args[1];
					MyArrayList myList ;
					File file=new File(inFile);
					boolean exists = file.exists();
					
					//checks of File exists.
					if(exists == false)
					{
						throw new FileNotFoundException("Error File Not Found");
					}
					FileProcessor fp = new FileProcessor(inFile);
					myList = new MyArrayList();
					line = fp.readLine();
					
					//Reading a file line by line
					while(line != null)
					{
						data =  Integer.parseInt(line);
						myList.insertSorted(data);
						line = fp.readLine();
					}
					//System.out.println(myList.toString());
					sum = myList.sum();
					Results results = new Results(OutFile);
					MyArrayListTest myArrayTest = new MyArrayListTest();
					myArrayTest.testMe(myList, results);
					
					//Print Results
					results.writeToFile(String.valueOf(sum));
					results.writeToStdout(String.valueOf(sum));
				}
			}
		}
		catch(IllegalArgumentException e) 
		{ 
			
			System.err.println("Exit from Driver : Exiting Program");
			System.err.println(e.getMessage());
			System.exit(0);
		}
		catch(FileNotFoundException e) 
		{ 
			
			System.err.println("Exit from Driver : Exiting Program");
			System.err.println(e.getMessage());
			System.exit(0);
		}
		catch(Exception e) 
		{ 
			System.err.println("Exit from Driver : Exiting Program");
			System.err.println(e.getMessage());
			System.exit(0);
		}
		

	}
}
