package one;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListIteratorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Dog> doglist = new ArrayList<>();
		Dog dog1=new Dog("ww", 5, "����");
		Dog dog2=new Dog("ah", 7, "��ë");
		Dog dogfeifei=new Dog("fei", 2, "��������");
		
		
		doglist.add(dog1);
		doglist.add(dog2);
		doglist.add(dogfeifei);
		doglist.add(new Dog("xiao", 3, "ѩ����"));
		//�����ĵڶ��ַ�ʽ���Ƽ�������������collection��ʵ�ּ�����
		System.out.println("------Iterator����collection------");
		Iterator<Dog> iterator=doglist.iterator();
		while(iterator.hasNext()){
			Dog dogtemp=iterator.next();
			System.out.println(dogtemp);
		}
		
		//�����ĵ����ַ�ʽ
		System.out.println("------��ǿforѭ������list-----------");
		for(Dog dog:doglist){
			System.out.println(dog);
		}
	}
}
