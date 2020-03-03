// The "QueueTest" class.
// Author: Jackson
// Date: 1/8/2019
// Purpose: To create and test a queue
// Input: Keyboard
// Output: Console/screen

import java.awt.*;
import hsa.Console;

public class QueueTest
{
    static Console c;           // The output console

    public static void main (String[] args)
    {
	c = new Console ();
	int num = 1;
	Queue queue1 = new StraightLineQueue ();
	Queue queue2 = new ShiftingQueueOnFull ();
	Queue queue3 = new ShiftingQueueOnRemove ();
	Queue queue4 = new CircularQueue ();
	Queue queue5 = new LinkedListQueue ();
	boolean stop = false;
	char key = ' ';
	while (!stop)
	{
	    c.println ("Straight Line Implementation");
	    queue1.printQueue (c);
	    c.println ();
	    c.println ("Shifting when full Implementation");
	    queue2.printQueue (c);
	    c.println ();
	    c.println ("Shifting when removing Implementation");
	    queue3.printQueue (c);
	    c.println ();
	    c.println ("Circular List Implementation");
	    queue4.printQueue (c);
	    c.println ();
	    c.println ("Linked List Implementation");
	    queue5.printQueue (c);
	    c.println ();
	    c.println ("Press a number between 1-4 to perform an action");
	    c.println ("1) Add a number");
	    c.println ("2) Remove a number");
	    c.println ("3) Reset queues");
	    c.println ("4) Exit program");
	    key = c.getChar ();
	    if (key == '1' || key == '2' || key == '3' || key == '4')
		c.clear ();
	    if (key == '1')
	    {
		queue1.add (num);
		queue2.add (num);
		queue3.add (num);
		queue4.add (num);
		queue5.add (num);
		num++;
		c.println ("Straight Line Implementation");
		queue1.printQueue (c);
		c.println ();
		c.println ("Shifting when full Implementation");
		queue2.printQueue (c);
		c.println ();
		c.println ("Shifting when removing Implementation");
		queue3.printQueue (c);
		c.println ();
		c.println ("Circular List Implementation");
		queue4.printQueue (c);
		c.println ();
		c.println ("Linked List Implementation");
		queue5.printQueue (c);
		c.println ();
	    }
	    else if (key == '2')
	    {
		queue1.remove ();
		queue2.remove ();
		queue3.remove ();
		queue4.remove ();
		queue5.remove ();
		c.println ("Straight Line Implementation");
		queue1.printQueue (c);
		c.println ();
		c.println ("Shifting when full Implementation");
		queue2.printQueue (c);
		c.println ();
		c.println ("Shifting when removing Implementation");
		queue3.printQueue (c);
		c.println ();
		c.println ("Circular List Implementation");
		queue4.printQueue (c);
		c.println ();
		c.println ("Linked List Implementation");
		queue5.printQueue (c);
		c.println ();
	    }
	    else if (key == '3')
	    {
		num = 1;
		queue1.reset ();
		queue2.reset ();
		queue3.reset ();
		queue4.reset ();
		queue5.reset ();
		c.println ("Straight Line Implementation");
		queue1.printQueue (c);
		c.println ();
		c.println ("Shifting when full Implementation");
		queue2.printQueue (c);
		c.println ();
		c.println ("Shifting when removing Implementation");
		queue3.printQueue (c);
		c.println ();
		c.println ("Circular List Implementation");
		queue4.printQueue (c);
		c.println ();
		c.println ("Linked List Implementation");
		queue5.printQueue (c);
		c.println ();
	    }
	    else if (key == '4')
	    {
		stop = true;
	    }
	    c.clear ();
	}

	// Place your program here.  'c' is the output console
    } // main method
} // QueueTest class

// Author: Jackson
// Date: 1/8/2019
// Purpose: To create a queue implementation
// Fields:
//      nums - contains the integers in the queue
//      front - contains the position of the front of the queue
//      back - contains the back of the queue
// Methods:
//      abstract add - adds an integer to the queue
//      abstract remove - removes and returns the first integer in the queue
//      abstract toString - returns the elements in the queue as a string
//      abstract printQueue - prints the queue with front and back indicators in a given Console
//      reset - resets the queue

abstract class Queue
{
    public int[] nums;
    public int front;
    public int back;
    abstract public boolean add (int num);
    abstract public int remove ();
    abstract public String toString ();
    abstract public void printQueue (Console c);

    public Queue ()
    {
	nums = new int [10];
	front = 0;
	back = 0;
    }


    // Author: Jackson
    // Date: 1/9/2018
    // Purpose: To reset the queue
    // Inpit: None
    // Output: Changes this.nums

    public void reset ()
    {
	nums = new int [10];
	front = 0;
	back = 0;
    }
}

// Author: Jackson
// Date: 1/10/2019
// Purpose: To create a straight line implementation of a queue
// Fields:
//      nums - contains the array of integers
//      front - contains the position of the front of the array
//      back - contains the position of the back of the array
// Methods:
//      add - adds an integer to the array
//      remove - removes an integer from the array
//      toString - returns the elements in the queue as a string
//      printQueue - prints the queue with front and back indicators in a given Console

class StraightLineQueue extends Queue
{
    public StraightLineQueue ()
    {
	super ();
    }


    // Author: Jackson
    // Date: 1/9/2018
    // Purpose: To add an integer to the array
    // Inpit: Parameters(int num)
    // Output: Adds a given integer to the back of the queue if not full,
    //         returns true if integer added, otherwise false

    public boolean add (int num)
    {
	boolean added = false;
	if (back < 10)
	{
	    nums [back] = num;
	    back++;
	    added = true;
	}
	return added;
    }


    // Author: Jackson
    // Date: 1/9/2018
    // Purpose: To remove and return a integer from the queue
    // Input: None
    // Output: Moves front forward and returns the integer removed if not empty

    public int remove ()
    {
	int num = 0;
	if (front != back)
	{
	    num = nums [front];
	    front++;
	}
	return num;
    }


    // Author: Jackson
    // Date: 1/9/2018
    // Purpose: To get the elements in a queue as a String
    // Input: None
    // Output: Returns a String containing all the elements in the array as a String

    public String toString ()
    {
	String num = "| ";
	for (int i = 0 ; i < front ; i++)
	{
	    num += " | ";
	}
	for (int i = front ; i < back ; i++)
	{
	    num += nums [i] + " | ";
	}
	for (int i = back ; i < 10 ; i++)
	{
	    num += " | ";
	}
	return num;
    }


    // Author: Jackson
    // Date: 1/9/2018
    // Purpose: To print the queue with the front and back indicators in a given Console
    // Input: Parameters(Console c)
    // Output: Prints the queue with the front and back shown on a given Console

    public void printQueue (Console c)
    {
	int digits;
	int num;
	String string = toString ();
	c.println (string);
	c.print ("  ");
	for (int i = 0 ; i < front ; i++)
	{
	    c.print ("   ");
	}
	c.print ("F");
	for (int i = front ; i < back - 1 ; i++)
	{
	    num = nums [i];
	    digits = 0;
	    while (num != 0)
	    {
		num /= 10;
		digits++;
	    }
	    for (int j = 0 ; j < digits ; j++)
		c.print (" ");
	    c.print ("   ");
	}
	if (front != back)
	{
	    c.print ("   B");
	}
	else
	{
	    c.print ("B");
	}
    }
}

// Author: Jackson
// Date: 1/13/2019
// Purpose: To create a shifting queue when queue is full
// Fields:
//      nums - contains the array of integers
//      front - contains the position of the front of the array
//      back - contains the position of the back of the array
// Methods:
//      add - adds an integer to the array, shifts elements if full and can shift
//      shift - shifts all the elements in the array

class ShiftingQueueOnFull extends StraightLineQueue
{
    public ShiftingQueueOnFull ()
    {
	super ();
    }


    // Author: Jackson
    // Date: 1/9/2018
    // Purpose: To add an integer to the array
    // Inpit: Parameters(int num)
    // Output: Adds a given integer to the back of the queue if not full and shifts if back is pointing to end of array,
    //         returns true if integer added, otherwise false

    public boolean add (int num)
    {
	boolean added = true;
	if (back > 9)
	{
	    if (front != 0)
		shift ();
	    else
		added = false;
	}
	if (added)
	{
	    nums [back] = num;
	    back++;
	}
	return added;
    }


    //  Author: Jackson
    // Date: 1/9/2018
    // Purpose: To shift all the elements in the queue to the front
    // Input: None
    // Output: Changes elements in the front of the queue

    public void shift ()
    {
	for (int i = 0 ; i < back - front ; i++)
	{
	    nums [i] = nums [front + i];
	}
	back = back - front;
	front = 0;
    }
}

// Author: Jackson
// Date: 1/13/2019
// Purpose: To create a shifting line implementation of a queue where the queue always shifts after removing an item
// Fields:
//      nums - contains the array of integers
//      front - contains the position of the front of the array
//      back - contains the position of the back of the array
// Methods:
//      remove - removes an integer to the array then shifts all elements

class ShiftingQueueOnRemove extends ShiftingQueueOnFull
{
    public ShiftingQueueOnRemove ()
    {
	super ();
    }


    // Author: Jackson
    // Date: 1/13/2019
    // Purpose: To remove the first element and shift all other elements
    // Input: None
    // Output: Removes the first element in the queue and shifts the queue if not empty

    public int remove ()
    {
	int num = 0;
	if (back != 0)
	{
	    num = nums [front];
	    front++;
	    shift ();
	}
	return num;
    }
}

// Author: Jackson
// Date: 1/8/2019
// Purpose: To create a queue implementation
// Fields:
//      nums - contains the integers in the queue
//      front - contains the position of the front of the queue
//      back - contains the back of the queue
// Methods:
//      add - adds an integer to the queue
//      remove - removes and returns the first integer in the queue
//      toString - returns the elements in the queue as a string
//      printQueue - prints the queue with front and back indicators in a given Console

class CircularQueue extends Queue
{
    public CircularQueue ()
    {
	super ();
    }


    // Author: Jackson
    // Date: 1/9/2018
    // Purpose: To add an integer to the array
    // Inpit: Parameters(int num)
    // Output: Adds a given integer to the back of the queue if not full,
    //         returns true if integer added, otherwise false

    public boolean add (int num)
    {
	boolean added = true;
	if ((back + 1) % 10 != front)
	{
	    nums [back % 10] = num;
	    back++;
	}
	else
	{
	    added = false;
	}
	return added;
    }


    // Author: Jackson
    // Date: 1/9/2018
    // Purpose: To remove and return a integer from the queue
    // Input: None
    // Output: Moves front forward and returns the integer removed if not empty

    public int remove ()
    {
	int num = 0;
	if (front % 10 != back % 10)
	{
	    num = nums [front % 10];
	    front++;
	}
	return num;
    }


    // Author: Jackson
    // Date: 1/9/2018
    // Purpose: To get the elements in a queue as a String
    // Input: None
    // Output: Returns a String containing all the elements in the array as a String

    public String toString ()
    {
	String num = "| ";
	if (front % 10 < back % 10)
	{
	    for (int i = 0 ; i < front % 10 ; i++)
	    {
		num += " | ";
	    }
	    for (int i = front % 10 ; i < back % 10 ; i++)
	    {
		num += nums [i] + " | ";
	    }
	    for (int i = back % 10 ; i < 10 ; i++)
	    {
		num += " | ";
	    }
	}
	else if (front % 10 == back % 10)
	{
	    for (int i = 0 ; i < 10 ; i++)
	    {
		num += " | ";
	    }
	}
	else
	{
	    for (int i = 0 ; i < back % 10 ; i++)
	    {
		num += nums [i] + " | ";
	    }
	    for (int i = back % 10 ; i < front % 10 ; i++)
	    {
		num += " | ";
	    }
	    for (int i = front % 10 ; i < 10 ; i++)
	    {
		num += nums [i] + " | ";
	    }
	}
	return num;
    }


    // Author: Jackson
    // Date: 1/9/2018
    // Purpose: To print the queue with the front and back indicators in a given Console
    // Input: Parameters(Console c)
    // Output: Prints the queue with the front and back shown on a given Console

    public void printQueue (Console c)
    {
	int digits;
	int num;
	String string = toString ();
	c.println (string);
	c.print ("  ");
	front %= 10;
	back %= 10;
	if (front < back)
	{
	    for (int i = 0 ; i < front ; i++)
	    {
		c.print ("   ");
	    }
	    c.print ("F");
	    for (int i = front ; i < back - 1 ; i++)
	    {
		num = nums [i];
		digits = 0;
		while (num != 0)
		{
		    num /= 10;
		    digits++;
		}
		for (int j = 0 ; j < digits ; j++)
		    c.print (" ");
		c.print ("   ");
	    }
	    c.print ("   B");
	}
	else if (front == back)
	{
	    for (int i = 0 ; i < front ; i++)
	    {
		c.print ("   ");
	    }
	    c.print ("F");
	    for (int i = front ; i < back - 1 ; i++)
	    {
		num = nums [i];
		digits = 0;
		while (num != 0)
		{
		    num /= 10;
		    digits++;
		}
		for (int j = 0 ; j < digits ; j++)
		    c.print (" ");
		c.print ("   ");
	    }
	    c.print ("B");
	}
	else
	{
	    for (int i = 0 ; i < back ; i++)
	    {
		num = nums [i];
		digits = 0;
		while (num != 0)
		{
		    num /= 10;
		    digits++;
		}
		for (int j = 0 ; j < digits ; j++)
		    c.print (" ");
		c.print ("   ");
	    }
	    c.print ("B");
	    for (int i = back ; i < front - 1 ; i++)
	    {
		c.print ("   ");
	    }
	    c.print ("  F");
	}
    }
}

// Author: Jackson
// Date: 12/6/2018
// Purpose: To  create a node class
// Fields:
//      data - contains the data of the node
//      next - contains the next Node in the linked list
// Methods:
//      clone - creates a copy of the Node
//      toString - creates a string containing all the data in the Nodes

class Node implements Cloneable
{
    public int data;
    public Node next;

    public Node (int info)
    {
	data = info;
	next = null;
    }


    public Node ()
    {
	this (0);
    }


    // Author: Jackson
    // Date: 12/6/2018
    // Purpose: To create a copy of the Node
    // Input: None
    // Output: Returns a Node object which is the copy of the the Node

    public Object clone () throws CloneNotSupportedException
    {
	Node newObject = (Node) super.clone ();
	if (next == null)
	    newObject.next = null;
	else
	    newObject.next = (Node) next.clone ();
	return newObject;
    }


    // Author: Jackson
    // Date: 12/6/2018
    // Purpose: To return the data of alln the Nodes as a string
    // Input: None
    // Output: Returns a string which contains the data of all the Nodes in the list

    public String toString ()
    {
	String info = "| ";
	info = info + data + " | ";
	if (next != null)
	    info = info + next.toString ();
	return info;
    }
}

// Author: Jackson
// Date: 11/13/2018
// Purpose: To create a linked list implementation of queues
// Fields:
//      nums - contains the integers in the queue
//      front - contains the position of the front of the queue
//      back - contains the back of the queue
// Methods:
//      isEmpty - checks if the queue is empty
//      numNodes - returns the number of Nodes in the queue
//      add - adds an integer to the queue
//      remove - removes the first integer in the queue
//      toString - returns the numbers in the queue as a string
//      printQueue - prints the queue with front and back indicators in a given Console
//      reset - resets the queue

class LinkedListQueue extends Queue
{
    public Node front;
    public Node back;

    public LinkedListQueue ()
    {
	front = null;
	back = null;
    }


    // Author: Jackson
    // Date: 1/13/2019
    // Purpose: To check if the queue is empty
    // Input: None
    // Output: Returns true if  the queue is empty, else returns false

    public boolean isEmpty ()
    {
	return front == null;
    }


    // Author: Jackson
    // Date: 1/13/2019
    // Purpose: To get the number of Nodes in the queue
    // Input: None
    // Output: Returns the number of Nodes in the queue

    public int numNodes ()
    {
	int count = 0;
	Node current;
	if (!isEmpty ())
	{
	    current = front;
	    while (current.next != null)
	    {
		current = current.next;
		count++;
	    }
	}
	return count;
    }


    // Author: Jackson
    // Date: 1/9/2018
    // Purpose: To add an integer to the array
    // Inpit: Parameters(int num)
    // Output: Adds a Node to the back of the queue,
    //         returns true because Node is always added

    public boolean add (int num)
    {
	Node node = new Node (num);
	if (!isEmpty ())
	{
	    back.next = node;
	    back = node;
	}
	else
	{
	    front = node;
	    back = node;
	}
	return true;
    }


    // Author: Jackson
    // Date: 1/13/2019
    // Purpose: To remove a node from the queue
    // Input: None
    // Output: Removes the first Node from the queue

    public int remove ()
    {
	if (!isEmpty ())
	{
	    front = front.next;
	}
	return 0;
    }


    // Author: Jackson
    // Date: 12/6/2018
    // Purpose: To create a string containing all the data of the nodes
    // Input: None
    // Otuput: Returns a string containing all the data in the list of Nodes,
    //         return "empty" if this.list is empty

    public String toString ()
    {
	String info;
	if (isEmpty ())
	{
	    info = "Empty";
	}
	else
	{
	    info = front.toString ();
	}
	return info;
    }


    // Author: Jackson
    // Date: 1/9/2018
    // Purpose: To print the queue with the front and back indicators in a given Console
    // Input: Parameters(Console c)
    // Output: Prints the queue with the front and back shown on a given Console

    public void printQueue (Console c)
    {
	int digits;
	int num;
	Node current = front;
	c.print ("  F");
	c.println ();
	String string = toString ();
	c.println (string);
	c.print ("  ");
	for (int i = 0 ; i < numNodes () ; i++)
	{
	    num = current.data;
	    current = current.next;
	    digits = 0;
	    while (num != 0)
	    {
		num /= 10;
		digits++;
	    }
	    for (int j = 0 ; j < digits ; j++)
		c.print (" ");
	    c.print ("     ");
	}
	c.print ("B");
    }


    // Author: Jackson
    // Date: 1/13/2019
    // Purpose: To reset the nodes and empty the queue
    // Input: None
    // Output: Makes front and back point to null

    public void reset ()
    {
	front = null;
	back = null;
    }
}


