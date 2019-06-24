## Name: Devina Sachin Dhuri

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on the project.
#### Note: build.xml is present in myArrayList/src folder.
To clean, compile and run, be sure to be in the myArrayList folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command:  ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description: Data Structures used

Design a data structure named "MyArrayList" with the following properties:
The data structure should have an integer array as a private data member. Start with some initial int array size, say 50. If the input size is greater than 50, then create a new array of size 75, copy the contents of the original array into this new array, and then continue).
void insertSorted(int newValue) : This method should insert a new value but keep the data structure sorted in ascending order. If a value is a duplicate, you can store it before or after an existing value.
void printInsertionOrder() : This method should print the contents of the array in the order of insertion. As an added constraint, you cannot use another array to store the order, but are free to use other data structures for storing metadata that will enable printing in the inserted order. Provide a justification in your README.md in terms of space or time complexity for your choice of data structure(s) for the metadata.
void removeValue(int value); This method should remove all occurences of a value, if it exists, and then move the remaining values so that the array list has all values in ascending order.
compact() This method should get rid of internal empty buckets in the array and shrink the array if necessary. After compating, the elements in the end of the array that are not assigned should be set to "-1". The compact() > functionality can be tested by calling removeValue(...) on random internal values and then calling compact() to test if the capacity has indeed been reduced. You can optionally use a "load factor" similar to the one used in hash tables, to decide when the compact() method should be called. The load factor can be 1.0 by default, but can reset if it is passed in the constructor. The use of load factor is optional, just for your own design convenience.
int indexOf(int value); This method should return the index of the first occurrence a value. It should return -1 if the value does not exist in the array list.
int size(); This method should return the total number of values that are stored in the array list.
int sum(); This method should return the sume of all values that are stored in the array list.
For all the above methods, provide your own implementation. If you find an online source for any of the above methods, cite the url, use the same logic, but implement in your own way.
An empty constructor, which sets the privata data members to default values.
A toString(...) method that prints all the values of the array in a pretty manner. You can decide what "pretty print" means.
You can use private helper functions to consolidate operations such as array resizing and sorted insertion/removal.



int[] array is used for storing the input from the given file
Array is initialized to 50 at the beginning. 
As and when input size increases, array size is then increased by 50% each time.

Sorting: Bubble Sort

Worst case Time complexity:O(n^2)
Space complexity:O(n)

Lookup: 
Time complexity:O(1)

To print the insertion order, a string is used to which every time
an element is added, th element is appended to the string.
-----------------------------------------------------------------------


