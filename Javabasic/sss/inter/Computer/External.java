package Computer;

public class External implements USB{

	@Override
	public void Insert() {
		// TODO Auto-generated method stub
		System.out.println("移动硬盘已经与电脑连接");
		
	}

	@Override
	public void Start() {
		// TODO Auto-generated method stub
		System.out.println("移动硬盘正在启用");
		
	}

	@Override
	public void Stop() {
		// TODO Auto-generated method stub
		System.out.println("移动硬盘已安全拔出");
		
	}
	

}
