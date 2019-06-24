package myArrayList;

import java.lang.String ;

/**
 * @author Devina Dhuri
 */
 
public class MyArrayList 
{
	private int size ;
	
	// Initial size of the array default set to 50
	private int iniSize ;
	private String insertedOrder = "";
	private int[] myList ;
	private int[] temp ;
	int data ;
	String tempStr;

	/**
	 * constructor for MyArrayList
	 */
	public MyArrayList() 
	{
		iniSize = 50;
		size = 0;
		myList = new int[iniSize];
		temp = new int[iniSize];
	}
	
	/**
	* This Function will check if the array size exceeds
	* the initial size, if yes it will increase the size
	* to half more than initial size.
	* @param line - element to be entered in the array. 
	*/
	public void checkSize(String line)
	{
		//String[] inArray = line.split("\\r?\\n");
		if((size >= iniSize) )
		{
			temp = myList;
			iniSize = iniSize + (iniSize / 2);
			myList = new int[iniSize];
			for(int i=0; i < temp.length; i++)
			{
				myList[i] = temp[i];
			}
		}
	}
	
	/**
	* This Function will compute the sum of the elements 
	* in the array.
	*/
	public int sum() 
	{
		if(myList.length>0) 
		{
			int sum=0;
			for(int i=0;i<size;i++)
			{
				if (myList[i] != -1)
				{
					sum = sum + myList[i];
				}
			}
			return sum;
		}
		else 
		{
			return 0; // If array is empty
		}		
	}
	
	/**
	* This Function will find the number of 
	* elements in the array.
	*/
	public int size() 
	{
		if(myList.length>0) 
		{
			int arraySize=0;
			for(int i=0;i<size;i++)
			{
				arraySize += 1;
			}
			return arraySize;
		}
		else 
		{
			return -1;
		}
	}
	
	/**
	* This Function will find the index of a specific element.
	* It returns -1 if elements not found.
	* @param value - element of which index has to be found.
	*/
	public int indexOf(int value) 
	{
		for(int i=0;i<size;i++)
		{
			if (myList[i] == value)
			{
				return i;
			}
		}
		return -1; // If element not found
	}
	
	/**
	* This Function will print the array.
	*/
	public String toString() 
	{
		int i;
		String arrayPrint = "[ ";
		for(i=0;i<size-1;i++) 
		{
			arrayPrint = arrayPrint + myList[i] + " , ";
		}
		//appending the last element of the array
		if (i == size - 1)
		{
			arrayPrint = arrayPrint + myList[i] + "";
		}
		arrayPrint = arrayPrint + " ]";
		return arrayPrint;
	}
	
	/**
	* This Function will remove all occurrences from the 
	* array and sort it. Note that removeValue simply 
	* replaces the value by -1 without taking it 
	* out of the array. Thus the size is intact.
	* @param value - element to be removed.
	*/
	public void removeValue(int value) 
	{
		int index = 0;
		for(int i=0;i<size;i++) 
		{
			if(myList[i] == value) 
			{
				myList[i] = -1;	
			}
		}
		insertedOrder = insertedOrder.replaceAll(" "+value, "");
		sortArray();
	} 
	
	/**
	* This Function will get rid of empty buckets(-1 data ) 
	* in the array that are created by removeValue function.
	*/
	public void compact() 
	{
		int index = 0;
		for(int i=0;i<size;i++) 
		{
			if(myList[i] == -1) 
			{
				for(int j=i;j<size-1;j++) 
				{
					myList[j] = myList[j+1];
				}
				i = i - 1;
				size--;
			}
		}
	} 
	
	/**
	* This Function will sort the array in 
	* ascending order, using Bubble sort.
	*/
	public void sortArray() 
	{
		for(int i=0;i<size;i++) 
		{
			for(int j = i+1;j<size;j++) 
			{
				int temp = 0;
				if(myList[i] > myList[j]) 
				{
					temp = myList[i];
					myList[i] = myList[j];
					myList[j] = temp;
				}
			}
		}
	}
	
	/**
	* This Function will insert elements into the array in 
	* sorted order.
	* @param newValue - new value to be entered in the list.
	*/
	public void insertSorted(int newValue) 
	{
		tempStr = String.valueOf(newValue);
		checkSize(String.valueOf(newValue));
		// Given data values are between 0 to 10000.
		if((newValue <= 10000) && (newValue >= 0)) 
		{
			myList[size++] = newValue;
		}	
		insertedOrder = insertedOrder + " " + tempStr ; 
		sortArray();
	}
	
	/**
	* This Function will print the order of insertion.
	*/
	public void printInsertionOrder()
	{
		System.out.println("Inserted order of the array is: " + insertedOrder);
	}

	/**
	* Accessors and Mutators for the data members.
	*/

	public int getSize() 
	{
		return size;
	}
	public void setSize(int size) 
	{
		this.size = size;
	}
	
	public int getIniSize() 
	{
		return iniSize;
	}
	public void setIniSize(int iniSize) 
	{
		this.iniSize = iniSize;
	}
	
	public String getInsertedString() 
	{
		return insertedOrder;
	}
	public void setInsertedString(String insertedOrder) 
	{
		this.insertedOrder = insertedOrder;
	}
	
	public int[] getArray() 
	{
		return myList;
	}
	public void setArray(int[] myList) 
	{
		this.myList = myList;
	}

	public int[] getArrayTemp() 
	{
		return temp;
	}
	public void setArrayTemp(int[] temp) 
	{
		this.temp = temp;
	}
	
	
	
}
