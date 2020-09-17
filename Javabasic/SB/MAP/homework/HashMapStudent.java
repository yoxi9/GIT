package homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;



public class HashMapStudent {
	
	public static void main(String[] args) {
		
		Map<String,Student> map=new HashMap<>();
		map.put("1",new Student("A","11"));
		map.put("2",new Student("B","21"));
		map.put("3",new Student("C","31"));
		map.put("4",new Student("D","41"));
		
		Student t1=map.get("1");
		if(t1==null) {
			System.out.println("无该学生信息");
		}else {
			System.out.println(map.get("1"));
		}
		
		Student t9=map.get("9");
		if(t9==null) {
			System.out.println("无该学生信息");
		}else {
			System.out.println(map.get("9"));
		}
		
        Set<Entry<String, Student>> entries=map.entrySet();
        
        Iterator<Entry<String, Student>> iterator=entries.iterator();
        
        while(iterator.hasNext()) {
        	Entry<String, Student> entry=iterator.next();
        	System.out.println("序号："+entry.getKey()+"\t"+entry.getValue());
        	
		
		
	}
}
}
