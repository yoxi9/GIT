package Computer;

public class Test {
	public static void main(String[] args) {
		
		UDisk U=new UDisk();
		U.Insert();
		U.Start();
		U.Stop();
		
		External E=new External();
		E.Insert();
		E.Start();
		E.Stop();
		
		Mouse M=new Mouse();
		M.Insert();
		M.Start();
		M.Stop();
	}

}
