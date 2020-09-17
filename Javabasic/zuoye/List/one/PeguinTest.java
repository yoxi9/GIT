package one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
 
public class PeguinTest {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		List<Peguin> list = new ArrayList<Peguin>();
		
		list.add(new Peguin(1,12));
		list.add(new Peguin(2,9));
		list.add(new Peguin(2,6));
		list.add(new Peguin(3,10));
		list.add(new Peguin(4,3));
		list.add(new Peguin(1,6));
		list.add(new Peguin(5,8));
		System.out.println("企鹅的数量为："+ list.size());
		System.out.println("****遍历所有企鹅的信息****");
		
		for (int i = 0; i < list.size(); i++) {
			Peguin peguin = list.get(i);
			System.out.println("编号:" +peguin.getNo() + "年龄:" + peguin.getAge());
		}
		
		for (int i = 0; i < list.size(); i++) {
			Peguin peguin = list.get(i);
			if(peguin.getNo() == 1) {
				list.remove(i);
			}
		}
		Iterator<Peguin> it = list.iterator();
		while(it.hasNext()) {
			Peguin p = it.next();
			if(p.getNo() ==1) {
				it.remove();
			}
		}
		System.out.println("移除后list的长度：" + list.size());
		System.out.println("集合中是否包含编号为5，年龄为8的企鹅："+list.contains(new Peguin(5,8)) );
	
 
	Collections.sort(list);
	System.out.println("****按照编号排序****");
	System.out.println(list);
	
	Collections.sort(list,new PeguinAge());
	System.out.println("****按照年龄排序****");
	System.out.println(list);
	
	}
}

