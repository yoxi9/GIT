package threaddemo;


class SellZhuanJia extends Thread{
	
	static int ticket=40;
	static String token = new String();
	
	public SellZhuanJia(String title) {
		// TODO Auto-generated constructor stub
		super.setName(title);
	}

	public SellZhuanJia() {

	}
	
	public synchronized void sell(){ 
		while (ticket > 0) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "������:"
				+ (ticket--) + "��Ʊ");
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
				System.out.println(Thread.currentThread().getName() + "������:"
					+ (ticket--) + "��Ʊ");
			}	
		}
	}	
}


public class ZhuanJia {
	public static void mian(String[] args) {
		SellZhuanJia zj1= new SellZhuanJia("����1");
		zj1.start();

		SellZhuanJia zj2 = new SellZhuanJia("����2");
		zj2.start();

		SellZhuanJia zj3 = new SellZhuanJia("����3");
		zj3.start();
	}

}
