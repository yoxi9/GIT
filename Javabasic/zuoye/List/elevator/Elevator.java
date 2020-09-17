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
	        System.out.println("当前电梯中排队的次序为：");
	        for(T t:list){
	            str+="名字："+t.toString()+"\n";
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
	        System.out.println("电梯上行，在9层停下，有人进来了");
	        System.out.println(people);


	        System.out.println("电梯上行，已到达12层，"+people.Out()+"已经到站，走出电梯。");
	        System.out.println(people);



	    }
	}



