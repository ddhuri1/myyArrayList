package myArrayList.test;

import java.util.Arrays;
import myArrayList.MyArrayList;
import myArrayList.util.Results;

/**
 * @author Devina Dhuri
 */
 
public class MyArrayListTest 
{
	String test1,test2,test3,test4,test5,test6,test7,test8,test9,test10,test11;
	
	public MyArrayListTest() {}
	
	public void testMe(MyArrayList myArrayList, Results results) 
	{
		checkInsert(myArrayList,results); 
		checkPrettyPrint(myArrayList,results); 
		checkInitialSize(myArrayList,results);
		checkSizeAfterAddingNewElements(myArrayList,results);
		checkCompact(myArrayList,results);
		checkSizeAterRemoveAndCompact(myArrayList,results);
		checkIndexOfSortedElements(myArrayList,results);
		checkSum(myArrayList,results);
		checkArrayResize(myArrayList,results);
		checkValidElements(myArrayList,results);
		checkSumAfterRemoval(myArrayList,results);
	}
	
	/**
	* This Function will check if after after inserting new values,
	*  it is inserted properly.
	* @param MyArrayList - the list to be tested 
	* and Results object - to store the test results.
	*/
	public void checkInsert(MyArrayList myArrayList, Results results) 
	{
		test1 = "checkInsert";
		myArrayList.removeValue(0);
		myArrayList.compact();
		int oldSize = myArrayList.size();
		myArrayList.insertSorted(0);
		
		if((myArrayList.size() == oldSize + 1) && (myArrayList.indexOf(0) == 0)) 
		{
			results.storeNewResult("checkInsert", "PASS");
		}
		else 
		{
			results.storeNewResult("checkInsert", "FAIL");
		}
	}
	
	/**
	* This Function will check if after after inserting new values,
	*  is the initial size maintained.
	* @param MyArrayList - the list to be tested 
	* and Results object - to store the test results.
	*/
	public void checkInitialSize(MyArrayList myArrayList, Results results) 
	{
		test3 = "checkInitialSize";
		myArrayList = new MyArrayList();
		for(int i =0; i<50;i++)
		{
			myArrayList.insertSorted(i);
		}
		if(myArrayList.indexOf(49) == 49) 
		{
			results.storeNewResult("checkInitialSize", "PASS");
		}
		else 
		{
			results.storeNewResult("checkInitialSize", "FAIL");
		}
	}
	
	/**
	* This Function will check if after after inserting new values,
	*  is the size of the array correctly increased.
	* @param MyArrayList - the list to be tested 
	* and Results object - to store the test results.
	*/
	public void checkPrettyPrint(MyArrayList myArrayList, Results results) 
	{
		test2 = "checkPrettyPrint";
		myArrayList.insertSorted(10000);
		if(myArrayList.toString().contains(", 10000 ]")) 
		{
			results.storeNewResult("checkPrettyPrint", "PASS");
		}
		else 
		{
			results.storeNewResult("checkPrettyPrint", "FAIL");
		}
	}
	
	/**
	* This Function will check if after after inserting new values,
	*  is the size of the array correctly increased.
	* @param MyArrayList - the list to be tested 
	* and Results object - to store the test results.
	*/
	public void checkSizeAfterAddingNewElements(MyArrayList myArrayList, Results results) 
	{
		test4 = "checkSizeAfterAddingNewElements";
		int sizeOld = myArrayList.size();
		myArrayList.insertSorted(1);
		myArrayList.insertSorted(40);
		myArrayList.insertSorted(40);
		myArrayList.insertSorted(30);
		int sizeNew = myArrayList.size();
		if(sizeNew == (sizeOld + 4)) 
		{
			results.storeNewResult("checkSizeAfterAddingNewElements", "PASS");
		}
		else 
		{
			results.storeNewResult("checkSizeAfterAddingNewElements", "FAIL");
		}
	}

	/**
	* This Function will check if after removing elements from the array,
	* and compacting it, is the size change within the range expected.
	* @param MyArrayList - the list to be tested 
	* and Results object - to store the test results.
	*/
	public void checkCompact(MyArrayList myArrayList, Results results) 
	{
		test5 = "checkCompact" ;
		myArrayList.insertSorted(0);
		myArrayList.removeValue(0);
		myArrayList.insertSorted(1);
		int oldSize = myArrayList.size();
		myArrayList.compact();
		int newSize = myArrayList.size();
		if((newSize < oldSize) && (myArrayList.indexOf(1) == 0)) 
		{
			results.storeNewResult("checkCompact", "PASS");
		}
		else 
		{
			results.storeNewResult("checkCompact", "FAIL");
		}
	}
	
	/**
	* This Function will check if after adding values more than initial 
	* size, is the array resized correctly. This test is just a stress 
	* test.
	* @param MyArrayList - the list to be tested 
	* and Results object - to store the test results.
	*/
	public void checkArrayResize(MyArrayList myArrayList, Results results) 
	{
		test9 = "checkArrayResize";
		int count = 0;
		int oldSize = myArrayList.size();
		for(int i =0; i<1000;i++)
		{
			myArrayList.insertSorted(i);
			count ++;
			
		}
		int sizeNew = myArrayList.size();
		
		if(sizeNew == oldSize + count)
		{
			results.storeNewResult("checkArrayResize", "PASS");
		}
		else 
		{
			results.storeNewResult("checkArrayResize", "FAIL");
		}	
	}
	
	/**
	* This Function will check if while inserting elements into the array,
	* only valid elements, i.e in the range of 0 - 10000 are entered.
	* @param MyArrayList - the list to be tested 
	* and Results object - to store the test results.
	*/
	public void checkValidElements(MyArrayList myArrayList, Results results) 
	{
		test10 = "checkValidElements";
		int sizeOld = myArrayList.size();
		myArrayList.insertSorted(-444);
		myArrayList.insertSorted(1000000);
		int sizeNew = myArrayList.size();
		if(sizeNew == sizeOld)
		{
			results.storeNewResult("checkValidElements", "PASS");
		}
		else 
		{
			results.storeNewResult("checkValidElements", "FAIL");
		}	
	}
	
	/**
	* This Function will check if after removing all occurrences of certain 
	* element and compacting the array, the size is properly maintained  .
	* @param MyArrayList - the list to be tested 
	* and Results object - to store the test results.
	*/
	public void checkSizeAterRemoveAndCompact(MyArrayList myArrayList, Results results) 
	{
		test6 = "checkSizeAterRemoveAndCompact";
		myArrayList.removeValue(0);
		myArrayList.compact();
		int oldSize = myArrayList.size();
		myArrayList.insertSorted(3);
		myArrayList.insertSorted(4);
		myArrayList.insertSorted(0);
		myArrayList.insertSorted(0);
		myArrayList.insertSorted(0);
		myArrayList.insertSorted(5);
		myArrayList.insertSorted(10);
		myArrayList.insertSorted(60);
		myArrayList.insertSorted(7);
		myArrayList.insertSorted(0);
		myArrayList.insertSorted(8);
		
		int toBeDeleted = 4;
		int newAdded = 11;
		myArrayList.removeValue(0);
		myArrayList.compact();
		int newSize = myArrayList.size();
		
		if( newSize == oldSize + newAdded - toBeDeleted) 
		{
			results.storeNewResult("checkSizeAterRemoveAndCompact", "PASS");
		}
		else 
		{
			results.storeNewResult("checkSizeAterRemoveAndCompact", "FAIL");
		}
	}
	
	/**
	* This Function will check if after adding elements to the existing array,
	* is the index of the smaller element smaller than the index of the 
	* index of the larger element.
	* @param MyArrayList - the list to be tested 
	* and Results object - to store the test results.
	*/
	public void checkIndexOfSortedElements(MyArrayList myArrayList, Results results) 
	{
		test7 = "checkIndexOfSortedElements";
		myArrayList.insertSorted(5);
		myArrayList.insertSorted(4);
		
		if(myArrayList.indexOf(4) < myArrayList.indexOf(5)) 
		{
			results.storeNewResult("checkIndexOfSortedElements", "PASS");
		}
		else 
		{
			results.storeNewResult("checkIndexOfSortedElements", "FAIL");
		}
	}
	
	/**
	* This Function will check if after adding elements to the existing array,
	* is the sum of the array maintained according to the new elements added.
	* @param MyArrayList - the list to be tested 
	* and Results object - to store the test results.
	*/
	public void checkSum(MyArrayList myArrayList, Results results) 
	{
		test8 = "checkSum";
		int oldSum = myArrayList.sum();
		myArrayList.insertSorted(10);
		myArrayList.insertSorted(20);
		int tempSum = 30;
		int newSum = myArrayList.sum();
		if( newSum == oldSum + tempSum) 
		{
			results.storeNewResult("checkSum", "PASS");
		}
		else 
		{
			results.storeNewResult("checkSum", "FAIL");
		}
	}
	
	/**
	* This Function will check if after removing elements from the array,
	* is the sum of the array maintained according to the new elements removed.
	* @param MyArrayList - the list to be tested 
	* and Results object - to store the test results.
	*/
	public void checkSumAfterRemoval(MyArrayList myArrayList, Results results) 
	{
		test11 = "checkSumAfterRemoval";
		myArrayList.removeValue(10);
		int oldSum = myArrayList.sum();
		myArrayList.insertSorted(10);
		myArrayList.insertSorted(20);
		myArrayList.insertSorted(10);
		myArrayList.insertSorted(20);
		myArrayList.insertSorted(10);
		myArrayList.insertSorted(20);
		int tempSum = myArrayList.sum();
		myArrayList.removeValue(10);
		int delSum = 30;
		int newSum = myArrayList.sum();
		if((oldSum + 90 == tempSum) && (newSum + delSum == tempSum)) 
		{
			results.storeNewResult("checkSumAfterRemoval", "PASS");
		}
		else 
		{
			results.storeNewResult("checkSumAfterRemoval", "FAIL");
		}
	}
	
	/**
	* @return String representation of an object
	*/
	public String toString()
	{
		String finalResult = getClass().getName()+"@"+Integer.toHexString(hashCode()) + "\n" ;
		return "--------------------------" + "\n" + finalResult + "Tests Performed: " + test1 + "\n"+ test2 + "\n" + test3 + "\n" + test4 + "\n" + test5 + "\n" + test6 + "\n" + test7 + "\n" + test8 + "\n" + test9 + "\n" + test10 + "\n" + test11 + "\n" + "--------------------------" + "\n" ; 
	}
}