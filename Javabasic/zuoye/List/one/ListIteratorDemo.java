package one;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListIteratorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Dog> doglist = new ArrayList<>();
		Dog dog1=new Dog("ww", 5, "京巴");
		Dog dog2=new Dog("ah", 7, "金毛");
		Dog dogfeifei=new Dog("fei", 2, "拉布拉多");
		
		
		doglist.add(dog1);
		doglist.add(dog2);
		doglist.add(dogfeifei);
		doglist.add(new Dog("xiao", 3, "雪纳瑞"));
		//遍历的第二种方式，推荐，适用于所有collection的实现集合类
		System.out.println("------Iterator遍历collection------");
		Iterator<Dog> iterator=doglist.iterator();
		while(iterator.hasNext()){
			Dog dogtemp=iterator.next();
			System.out.println(dogtemp);
		}
		
		//遍历的第三种方式
		System.out.println("------增强for循环遍历list-----------");
		for(Dog dog:doglist){
			System.out.println(dog);
		}
	}
}
