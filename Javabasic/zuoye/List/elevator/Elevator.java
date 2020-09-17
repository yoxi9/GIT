package elevator;
import java.util.LinkedList;
public class Elevator<T> {
	

	
	   private LinkedList<T> list=new LinkedList<T>();

	   public void In(T t){
	       this.list.addFirst(t);
	   }
	   
	   public T Out(){
	       return this.list.removeFirst();
	   }

	   public boolean isEmpty(){
	       if(list.size()!=0){
	           return true;
	       }else {
	           return false;
	       }
	   }

	    @Override
	    public String toString() {
	       String str="";
	        System.out.println("��ǰ�������ŶӵĴ���Ϊ��");
	        for(T t:list){
	            str+="���֣�"+t.toString()+"\n";
	        }
	        return str;
	    }

	    public static void main(String[] args) {
	       Elevator<Person> people=new Elevator<>();
	       people.In(new Person("X"));
	        people.In(new Person("C"));
	        people.In(new Person("V"));
	        System.out.println(people);


	        people.In(new Person("Q"));
	        System.out.println("�������У���9��ͣ�£����˽�����");
	        System.out.println(people);


	        System.out.println("�������У��ѵ���12�㣬"+people.Out()+"�Ѿ���վ���߳����ݡ�");
	        System.out.println(people);



	    }
	}



