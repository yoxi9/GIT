package abc;

public class CustomerBiz {
	
		String[] name=new String[5];
		int i=0;
		
		public void addnames(String str) {
			
			name[i]=str;
			i++;
	}

		public void shownames() {
			
			System.out.println("********************");
			System.out.println("客户姓名列表");
			System.out.println("********************");
			
			for(int j=0;j<i;j++) {
				System.out.println(name[j]+"/t");
			}
		}
}
