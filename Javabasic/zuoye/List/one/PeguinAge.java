package one;

import java.util.Comparator;

public class PeguinAge implements Comparator<Peguin>{
	
	@Override
	public int compare(Peguin o1, Peguin o2) {
		// TODO Auto-generated method stub
		return o1.getAge() - o2.getAge();
	}


}
