/*(C) Copyright 2019 Fresher Academy. All Rights Reseved.
 *
 *@author Ho Nhat Huy Dev
 *@date: Sep 28, 2019
 *@Time: 3:28:06 PM
 *version 4.0
 *|@Name|                |@Package|           |@Date| 
 *|Laptrinhmang|      |ProjectDemo|    |Sep 28, 2019|
 */
package ProjectDemo;

public class MsgRunnable implements Runnable{
	private String message;
	private static final int TIMES = 10;
	public MsgRunnable(String aMessage)
	{
		message = aMessage;
	}
	
	public void run()
	{
		for(int i = 0; i <TIMES; i++)
		{
			try {
				System.out.println(message);
				int pause = (int) (Math.random() * 3000);
				Thread.sleep(pause);
			} catch (InterruptedException e) {
				// TODO: handle exception
				System.out.println(e.toString());
			}
		}
	}
}
