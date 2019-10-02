/*(C) Copyright 2019 Fresher Academy. All Rights Reseved.
 *
 *@author Ho Nhat Huy Dev
 *@date: Oct 1, 2019
 *@Time: 9:19:46 AM
 *version 4.0
 *|@Name|                |@Package|           |@Date| 
 *|Laptrinhmang|      |ProjectDemo|    |Oct 1, 2019|
 */
package ProjectDemo;

public class Consumer extends Thread{
	private SynchQueue synQue;
	public Consumer(SynchQueue que)
	{
		synQue = que;
	}
	public void run()
	{
		int item = 0;
		do {
			item = synQue.remove();
			System.out.println("Consumer:" + this + "Value" + item);
		} while (item != -1);
	}
}
