/*(C) Copyright 2019 Fresher Academy. All Rights Reseved.
 *
 *@author Ho Nhat Huy Dev
 *@date: Sep 30, 2019
 *@Time: 4:32:24 PM
 *version 4.0
 *|@Name|                |@Package|           |@Date| 
 *|Laptrinhmang|      |ProjectDemo|    |Sep 30, 2019|
 */
package ProjectDemo;

import java.util.Date;

public class RunnableMsgDate {
	public static void main(String[] args) {
		MsgRunnable mr = new MsgRunnable("Hello!*");
		DateRunnable dr = new DateRunnable(new Date());
		
		Thread mt = new Thread(mr);
		Thread dt = new Thread(dr);
		
		mt.start();
		dt.start();
	}
}
