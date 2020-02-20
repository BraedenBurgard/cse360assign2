//	Braeden Burgard
//	1214815082
//	Assignment 1

//	SimpleList contains a 10-long array of integers and a variable
//	that holds the current # of integers in the array. Methods exist
//	to add and remove integers as if it were a queue, as well as to count or
//	search for an integer, and a readable toString method.

package assign2;

public class SimpleList {

	//list will become a 10-long array of integers
	private int[] list;
	//count describes the number of integers currently in list
	private int count;
	
	//constructor. Makes a 10-long empty list
	public SimpleList() 
	{
		list = new int[10];
		count = 0;
	}
	
	//adds given number to first index, moves all others back accordingly
	//if the list is full after this operation, add 50% more indexes at the end of the list
	public void add(int num)
	{
		for(int i = 8; i >= 0; i--)
		{
			list[i+1] = list[i];
		}
		list[0] = num;
		count = count();
		
		//increase size by 50% if necessary
		if(count == list.length)
		{
			int[] newList = new int[list.length * 3 / 2];
			copyList(list, newList);
			list = newList;
		}
	}
	
	//finds and removes given number, moves all others forward accordingly
	//if the list is more than 25% empty afterwards, 
	public void remove(int num)
	{
		int index = search(num);
		if(index != -1)
		{
			count--;
			for(int i = index; i < 9; i++)
			{
				list[i] = list[i+1];
			}
			list[9] = 0;
		}
		
		//if list is more than 25% empty, decrease list size by 25%
		if((float)count < (float)list.length * .75)
		{
			int[] newList = new int[list.length * 4 / 3];
			copyList(list, newList);
			list = newList;
		}
	}
	
	//counts how many integers are currently in the array
	public int count()
	{
		//count2 is a temporary variable
		//it will hold a recalculated value of count
		int count2 = 0;
		for(int i = 0; i < list.length; i++)
		{
			if(list[i] != 0)
			{
				count2 = i+1;
			}
		}
		return count2;
	}
	
	//returns all of the numbers in the array, with a space in between each
	public String toString()
	{
		//str will be built by the for loop, and returned to look like:
		//num1 num2 num3 etc.
		String str = "";
		for(int i = 0; i < count - 1; i++)
		{
			str += list[i] + " ";
		}
		if(count != 0)
		{
			str += list[count-1];
		}
		return str;
	}
	
	//finds the first occurrence of a given number
	public int search(int num)
	{
		for(int i = 0; i < count; i++)
		{
			if(list[i] == num) 
			{
				//return the index of the FIRST occurrence of the given number
				return i;
			}
		}
		//return -1 if integer is not in list
		return -1;
	}

	//I use this method to simplify add and remove methods
	//It copies every element of list A into list B, up until it reaches the end of a list
	private void copyList(int[] A, int[] B)
	{
		for(int i = 0; i < A.length && i < B.length; i++)
		{
			B[i] = A[i];
		}
	}
	
	//returns the entire array. Used for testing only
	public int[] getList()
	{
		return list;
	}
	
	//returns count. Used for testing only
	public int getCount()
	{
		return count;
	}
	
}
