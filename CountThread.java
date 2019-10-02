/*(C) Copyright 2019 Fresher Academy. All Rights Reseved.
 *
 *@author Ho Nhat Huy Dev
 *@date: Sep 25, 2019
 *@Time: 10:27:40 AM
 *version 4.0
 *|@Name|                |@Package|           |@Date| 
 *|Laptrinhmang|      |ProjectDemo|    |Sep 25, 2019|
 */
//CountThread does the counting//
//HelloThread does the printing//
package ProjectDemo;
//CountThread increments a value and prints it//
public class CountThread  extends Thread{
	//time the thread is pause for ( in ms)//
	int pause;
	//*number of times the message is printed.*//
	private static final int TIMES = 10;
	//*run() is the method doing the actual thread task.*//
	public void run()
	{
		for(int i = 0; i < TIMES; i++)
		{
			try {
				System.out.println(i);
				pause = (int) (Math.random() * 3000 );
				sleep(pause);
			} catch (InterruptedException e) {
				// TODO: handle exception
				System.out.println(e.toString());
			}
		}
	}
}
