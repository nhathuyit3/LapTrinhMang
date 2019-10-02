/*(C) Copyright 2019 Fresher Academy. All Rights Reseved.
 *
 *@author Ho Nhat Huy Dev
 *@date: Oct 1, 2019
 *@Time: 9:28:57 AM
 *version 4.0
 *|@Name|                |@Package|           |@Date| 
 *|Laptrinhmang|      |ProjectDemo|    |Oct 1, 2019|
 */
package ProjectDemo;

public class MultiProdCons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int noCons = 3;
		int noProds= 4;
		SynchQueue sque = new SynchQueue(5);
		Consumer[] cons = new Consumer[noCons];
		Producer[] prods = new Producer[noProds];
		
		for(int i = 0; i < noCons; i += 1)
		{
			cons [i] = new Consumer(sque);	
			cons[i].start();
		}
		for(int i = 0; i < noProds; i += 1)
		{
			prods[i] = new Producer(sque, i*100, 50);
			prods[i].start();
		}
		
		for(int i = 0; i < noProds; i += 1)
		{
			try {
				prods[i].join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			};
		}
		
		for(int i = 0; i < noCons; i += 1)
		{
			sque.insert( -1);
		}
		for(int i = 0; i < noCons; i+=1)
		{
			try {
				cons[i].join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			};
		}
		System.out.println("Successful completion");
	}

}
