package Computer;

public class UDisk implements USB{

	@Override
	public void Insert() {
		// TODO Auto-generated method stub
		System.out.println("U盘已经与电脑连接");
		
	}

	@Override
	public void Start() {
		// TODO Auto-generated method stub
		System.out.println("U盘已启用");
		
	}

	@Override
	public void Stop() {
		// TODO Auto-generated method stub
		System.out.println("U盘已从电脑安全拔出");
		
	}
	
	

}
