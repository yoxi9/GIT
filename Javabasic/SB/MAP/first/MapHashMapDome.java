package first;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapHashMapDome {
	
	public static void main(String[] args) {
		Map<Dog,String> map=new HashMap<Dog,String>();
		map.put(new Dog("zhangsan", 4, "��ë"), "zhangahuang");
        map.put(new Dog("lisi", 4, "��������"), "liabu");
        map.put(new Dog("wanger", 4, "����"), "wangjinba");
        
        /*System.out.println(map);

        System.out.println(map.size());*/
     
        map.put(new Dog("wanger", 5, "����"), "wangtugou");
        /* System.out.println(map.size());
        System.out.println(map);*/
        
        Set<Map.Entry<Dog,String>> entries=map.entrySet();
        
        Iterator<Map.Entry<Dog,String>> iterator=entries.iterator();
        
        while(iterator.hasNext()) {
        	Map.Entry<Dog,String> entry=iterator.next();
        	
        	
        }
	}

}


/*package collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class test {
    private String name;
    private String num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public test() {

    }

    public test(String name, String num) {
        this.name = name;
        this.num = num;
    }

    public static void main(String[] args) {

        Map<String, Student> map = new HashMap<>();
        map.put("1", new Student("��", "A"));
        map.put("2", new Student("��", "B"));
        map.put("3", new Student("Ů", "C"));
        map.put("4", new Student("Ů", "D"));

        Student t1 = map.get("1");
        if (t1 == null) {
            System.out.println("�޸�ѧ����Ϣ");
        } else {
            System.out.println(map.get("1"));
        }

        Student t9 = map.get("9");
        if (t9 == null) {
            System.out.println("�޸�ѧ����Ϣ");
        } else {
            System.out.println(map.get("9"));
        }

        Set<Map.Entry<String, Student>> entries = map.entrySet();

        Iterator<Map.Entry<String, Student>> iterator = entries.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Student> entry = iterator.next();
            System.out.println("ѧ�ţ�" + entry.getKey() + "\t" + "������" + entry.getValue());


        }
    }
}*/




