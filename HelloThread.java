/*(C) Copyright 2019 Fresher Academy. All Rights Reseved.
 *
 *@author Ho Nhat Huy Dev
 *@date: Sep 25, 2019
 *@Time: 1:41:21 PM
 *version 4.0
 *|@Name|                |@Package|           |@Date| 
 *|Laptrinhmang|      |ProjectDemo|    |Sep 25, 2019|
 */
package ProjectDemo;
//*HelloThread prints "Hello!" at random intervals.*/ 
public class HelloThread extends Thread{
	/*time the thread is paused for (expressed in ms).*/ 
	int pause;
	/*number of times the message is printed.*/ 
	private static final int TIMES = 10;
	public void run () {
		/*"Hello" is printed TIMES times.*/ 
		for(int i = 0; i < TIMES; i++)
		{
			try {
				System.out.println("Hello!");
				pause = (int) (Math.random() * 3000);
				sleep(pause);
			} catch (InterruptedException e) {
				// TODO: handle exception
				System.out.println(e.toString());
			}
		}
	}
}
