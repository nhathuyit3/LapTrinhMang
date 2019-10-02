/*(C) Copyright 2019 Fresher Academy. All Rights Reseved.
 *
 *@author Ho Nhat Huy Dev
 *@date: Oct 1, 2019
 *@Time: 9:23:18 AM
 *version 4.0
 *|@Name|                |@Package|           |@Date| 
 *|Laptrinhmang|      |ProjectDemo|    |Oct 1, 2019|
 */
package ProjectDemo;

public class Producer extends Thread{
	private SynchQueue synQue;
	private int minItem, maxItem;
	public Producer(SynchQueue que, int min, int no)
	{
		synQue = que;
		minItem = min;
		maxItem = min + no;
	}
	public void run()
	{
		for(int item = minItem; item <= maxItem; item++) {
			System.out.println("Producer:" + this + "value" + item);
			synQue.insert(item);
		}
	}
}
