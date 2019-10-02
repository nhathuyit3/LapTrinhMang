/*(C) Copyright 2019 Fresher Academy. All Rights Reseved.
 *
 *@author Ho Nhat Huy Dev
 *@date: Sep 28, 2019
 *@Time: 3:08:11 PM
 *version 4.0
 *|@Name|                |@Package|           |@Date| 
 *|Laptrinhmang|      |ProjectDemo|    |Sep 28, 2019|
 */
package ProjectDemo;

public class ThreadHelloCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountThread count = new CountThread();
		HelloThread hello = new HelloThread();
		count.start();
		hello.start();
	}

}
