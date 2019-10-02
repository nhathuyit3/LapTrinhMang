/*(C) Copyright 2019 Fresher Academy. All Rights Reseved.
 *
 *@author Ho Nhat Huy Dev
 *@date: Sep 28, 2019
 *@Time: 3:13:01 PM
 *version 4.0
 *|@Name|                |@Package|           |@Date| 
 *|Laptrinhmang|      |ProjectDemo|    |Sep 28, 2019|
 */
package ProjectDemo;

import java.util.Date;

public class DateRunnable implements Runnable{
	private Date date;
	private static final int TIMES = 10;
	public DateRunnable(Date eDate)
	{
		date = eDate;
	}
	public void run()
	{
		for(int i = 0; i < TIMES; i++) {
			try {
				Date nowDate = new Date();
				System.out.println("started:" + date + "now:" + nowDate);
				int pause = (int) (Math.random() * 3000);
				Thread.sleep(pause);
			} catch ( InterruptedException e) {
				// TODO: handle exception
				System.out.println(e.toString());
			}
		}
	}
}
