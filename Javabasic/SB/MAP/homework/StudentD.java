package homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class StudentD {
	    private String id;
	    private String name;

	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public StudentD(String id, String name) {
	        this.id = id;
	        this.name = name;
	    }

	    public StudentD() {

	    }

	    @Override
	    public String toString() {
	        return "ѧ�ţ�" + this.getId() + "\tѧ��������" + this.getName();
	    }

	    public static void main(String[] args) {
	        Map<String, List<Student>> map = new HashMap<String, List<Student>>();
	        List<Student> commonClass = new ArrayList<Student>();
	        List<Student> strengthenClass = new ArrayList<Student>();
	        
	        map.put("��ͨ��", commonClass);
	        map.put("ǿ����", strengthenClass);

	        commonClass.add(new Student("A","1" ));
	        commonClass.add(new Student("B","2" ));
	        commonClass.add(new Student("C","3" ));

	        strengthenClass.add(new Student("X","1" ));
	        strengthenClass.add(new Student("Y","2" ));
	        strengthenClass.add(new Student("Z","3"));

	        Set<Map.Entry<String, List<Student>>> entries = map.entrySet();
	        Iterator<Map.Entry<String, List<Student>>> iterator = entries.iterator();
	        while (iterator.hasNext()) {
	            Map.Entry<String, List<Student>> entry = iterator.next();
	            System.out.println("�༶���ƣ�" + entry.getKey() + "\nѧ����Ϣ��" + entry.getValue());
	            System.out.println();
	        }

	    }
	}


