/*(C) Copyright 2019 Fresher Academy. All Rights Reseved.
 *
 *@author Ho Nhat Huy Dev
 *@date: Oct 1, 2019
 *@Time: 9:04:45 AM
 *version 4.0
 *|@Name|                |@Package|           |@Date| 
 *|Laptrinhmang|      |ProjectDemo|    |Oct 1, 2019|
 */
package ProjectDemo;

public class SynchQueue {
	private int front = 0, back = 0;
	private int noItems = 0;
	private int[] tabItems;
	private int maxnoItems;
	
	public SynchQueue (int maxsize)
	{
		maxnoItems = maxsize;
		tabItems = new int[maxnoItems];
	}
	
	public int queueSize() {
		return noItems;
	}
	
	public synchronized void insert (int item)
	{
		while(noItems == maxnoItems)
		{
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		};
		tabItems[back] = item;
		back = (back + 1) % maxnoItems;
		noItems += 1;
		notifyAll();
	}
	
	public synchronized int remove()
	{
		int item;
		while(noItems == 0)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			};
		}
		item = tabItems[front];
		front = (front + 1) % maxnoItems;
		noItems -= 1;
		notifyAll();
		return item;
	}
}

