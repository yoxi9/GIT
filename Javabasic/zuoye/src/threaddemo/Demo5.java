package threaddemo;


class SellTicketWin extends Thread {
	static int ticket = 80;
	/*û��static�Ļ���token��ÿ������Բ�һ���ģ�
	 ��Ȼ��һ�������������߳�ʹ����������ͬ��token*/
	static String token = new String("abc"); 

	public SellTicketWin(String title) {
		// TODO Auto-generated constructor stub
		super.setName(title);
	}

	public SellTicketWin() {

	}
	
	/*
	 * ��Ϊ���߳�ʵ����ͬ������ÿ���߳�ʹ�õ����ǲ�ͬ�ģ�
	 * ����ʹ��this����Ϊ�������ļ����̼߳�û�л����ϵ�����Զ����Ա�CPU����
	 * 
	 * ��thread������ʵ�ֶ��߳����������ʹ��ͬ����������Ч
	 */
	
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

public class Demo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SellTicketWin win1 = new SellTicketWin("����1");
		win1.start();

		SellTicketWin win2 = new SellTicketWin("����2");
		win2.start();

		SellTicketWin win3 = new SellTicketWin("����3");
		win3.start();
	}
}