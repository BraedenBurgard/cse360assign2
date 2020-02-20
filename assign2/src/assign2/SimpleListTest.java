//	Braeden Burgard
//	1214815082
//	Assignment 2

//	SimpleListTest contains two tests for each method of SimpleList,
//	except for getList() and getCount() which are simple get methods
//	I used for testing. For each method, one test should pass, one should fail.

package assign2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimpleListTest {

	@Test
	//add a number to the list, then see if it was successfully added
	//this test should pass
	public void testAddPass() {
		//create new SimpleList. Add a number, then test if it is in 0th index
		SimpleList list = new SimpleList();
		list.add(1);
		assertEquals(1, list.getList()[0]);
	}
	
	@Test
	//add a number to the list, then make sure count was changed
	//this test should fail
	public void testAdd2()
	{
		//create new SimpleList. Add a number, make sure count is not still 0
		SimpleList list = new SimpleList();
		list.add(1);
		assertFalse(0 == list.getList()[0]);
	}
	
	@Test
	//add a couple numbers to the list, then remove them. Then check that the list is empty
	//this test should pass
	public void testRemovePass()
	{
		//create new SimpleList. Add 2 numbers, remove them. Make sure index 0 is now 0 (empty)
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		list.remove(1);
		list.remove(2);
		assertEquals(0, list.getList()[0]);
	}
	
	@Test
	//add a number to the list, then remove it. Make sure count was changed
	//this test should fail
	public void testRemove2()
	{
		//create new SimpleList. Add 2 numbers, make sure count was changed
		SimpleList list = new SimpleList();
		list.add(1);
		list.remove(1);
		assertFalse(1 == list.getCount());
	}
	
	@Test
	//add a couple numbers to the list, then make sure count shows 2
	//this test should pass
	public void testCountPass()
	{
		//create new SimpleList. Add 2 numbers, make sure count got updated
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		assertEquals(2, list.count());
	}
	
	@Test
	//add a couple numbers to the list, then make sure count shows 2
	//this test should fail
	public void testCount2()
	{
		//create new SimpleList. Add 2 numbers, make sure it isn't zero
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		assertFalse(0 == list.count());
	}
	
	@Test
	//add a couple numbers to the list, then see what toString returns
	//this test should pass
	public void testToStringPass()
	{
		//create new SimpleList. Add 2 numbers, make sure toString returns "1 2"
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		assertEquals("2 1", list.toString());
	}
	
	@Test
	//add a couple numbers to the list, make sure toString returns something
	//this test should fail
	public void testToString2()
	{
		//create new SimpleList. Add 2 numbers, check if toString returns nothing
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		assertFalse(list.toString().equals(""));
	}
	
	@Test
	//add a couple numbers to the list, make sure that the program can find "1".
	//this test should pass
	public void testSearchPass()
	{
		//create new SimpleList. Add 2 numbers, search for integer 1. Should be index 1.
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		assertEquals(1, list.search(1));
	}
	
	@Test
	//add a couple numbers to the list, make sure the program can find "2"
	//this test should fail
	public void testSearchFalse()
	{
		//create new SimpleList. Add 2 numbers
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		//if integer 2 can't be found, -1 will be returned from search()
		assertFalse(-1 == list.search(2));
	}
	
	@Test
	//add a couple numbers to the list, make sure the program can find "2"
	//this test should pass
	public void testAppend1()
	{
		//create new SimpleList. Add 2 numbers
		SimpleList list = new SimpleList();
		list.append(1);
		list.append(2);
		//2 should have been added to the end of the list, which would be index 1 here.
		assertEquals(1, list.search(2));
	}
	
	@Test
	//add a few numbers to the list to make sure append() works with larger quantities of integers
	//this test should pass
	public void testAppend2()
	{
		//create new SimpleList. Add 2 numbers
		SimpleList list = new SimpleList();
		list.append(1);
		list.append(2);
		list.append(3);
		list.append(4);
		list.append(5);
		list.append(6);
		list.append(7);
		list.append(8);
		list.append(9);
		list.append(10);
		list.append(11);
		list.append(12);
		//If all went well, 11 must be in index 10.
		assertEquals(10, list.search(11));
	}
	
	@Test
	//adds many numbers to test the functionality of expanding the list with add
	//this test should pass
	public void testAddMany()
	{
		//create new SimpleList. Add 12 numbers
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(11);
		list.add(12);
		//If all went well, 1 must be in index 11.
		assertEquals(11, list.search(1));
	}
	
	@Test
	//adds many numbers, then removes them to test the functionality of shrinking the list with remove
	//this test should pass
	public void testRemoveMany()
	{
		//create new SimpleList. Add 2 numbers
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		
		list.remove(1);
		list.remove(2);
		
		//Test the size of a list equivalent to one in the SimpleList. It should have shrunk by 2 indexes
		assertEquals(8, list.getList().length);
	}
	
	

}
