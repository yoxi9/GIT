package one;

import java.util.ArrayList;
import java.util.List;

public class ListSimpleDome {
	
	public static void main(String[] args) {
		
		List<String> S=new ArrayList<String>();
		String abc=new String("abc");
		S.add(abc);
		S.add("hhh");
		S.add(2,"jjj");
		S.add("lll");
		
		for(int i=0;i<S.size();i++) {
			System.out.println(S.get(i));
		}
		
		/*List<Dog> doglist=new ArrayList<>();
		doglist.add(new Dog("q",5,"京巴"));
		doglist.add(new Dog("k",6,"金毛"));
		doglist.add(new Dog("l",7,"拉布拉多"));
		System.out.println(doglist.size());*/
		
		List<Dog> doglist=new ArrayList<>();
		
		
		
		
	}

}
