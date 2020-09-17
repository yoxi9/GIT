package threaddemo;


class SellTicketWin extends Thread {
	static int ticket = 80;
	/*没有static的话，token是每个对象对不一样的，
	 既然不一样，所以三个线程使用了三个不同的token*/
	static String token = new String("abc"); 

	public SellTicketWin(String title) {
		// TODO Auto-generated constructor stub
		super.setName(title);
	}

	public SellTicketWin() {

	}
	
	/*
	 * 因为各线程实例不同，所以每个线程使用的锁是不同的，
	 * 所以使用this来作为互斥锁的几个线程间没有互斥关系，所以都可以被CPU处理。
	 * 
	 * 多thread子类来实现多线程这种情况，使用同步方法不凑效
	 */
	
	public synchronized void sell(){ 
		while (ticket > 0) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "卖掉第:"
					+ (ticket--) + "张票");
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (token) {
			while (ticket > 0) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println(Thread.currentThread().getName() + "卖掉第:"
						+ (ticket--) + "张票");
			}
		}
	}
}

public class Demo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SellTicketWin win1 = new SellTicketWin("窗口1");
		win1.start();

		SellTicketWin win2 = new SellTicketWin("窗口2");
		win2.start();

		SellTicketWin win3 = new SellTicketWin("窗口3");
		win3.start();
	}
}