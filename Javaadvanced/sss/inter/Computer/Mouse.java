package Computer;

public class Mouse implements USB{

	@Override
	public void Insert() {
		// TODO Auto-generated method stub
		System.out.println("鼠标已经与电脑连接");
		
	}

	@Override
	public void Start() {
		// TODO Auto-generated method stub
		System.out.println("鼠标正在使用");
		
	}

	@Override
	public void Stop() {
		// TODO Auto-generated method stub
		System.out.println("鼠标已从电脑安全拔出");
		
	}

}
