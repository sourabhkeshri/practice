package practice.multithreading;

public class EvenOddPrinter {

	private static int MAX_NUMBER=100;
	private static int n=1;
	private static final Object lock = new Object();
	
	public static void main(String[] args) {
		Thread evenT = new Thread(new Even(),"Even Thread");
		Thread oddT = new Thread(new Odd(),"Odd Thread");
		
		evenT.start();
		oddT.start();

	}
	
	static class Even implements Runnable{

		@Override
		public void run() {
			while(n<=MAX_NUMBER) {
				synchronized(lock) {
					if(n%2==0) {
						System.out.println(Thread.currentThread().getName()+":"+n);
						n++;
						lock.notify();
					}else {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
		
	}
	
	static class Odd implements Runnable{

		@Override
		public void run() {
			while(n<=MAX_NUMBER) {
				synchronized (lock) {
					if(n%2!=0) {
						System.out.println(Thread.currentThread().getName()+":"+n);
						n++;
						lock.notify();
					}else {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
		
	}

}

