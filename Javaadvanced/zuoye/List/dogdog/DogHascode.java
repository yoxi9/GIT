package dogdog;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DogHascode {
	
	private String name;
	private String number;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public DogHascode(String name, String number) {
		
		this.name = name;
		this.number = number;
	}
	
	public DogHascode() {
		
	}
	
	@Override
	public String toString() {
		return "狗名字" + this.getName() + "主人电话号码" + this.getNumber() ;
	}
	
	public int hasCode() {
		int prime = 31;
		int result = 17;
		result = result * prime + (this.name != null ? this.name.hashCode() : 0);
	    result = result * prime + (this.number != null ? this.number.hashCode() : 0);
	    return result;
	}
	

	
	@Override
	public boolean equals(Object obj) {
		
	   
	        if (obj instanceof DogHascode) {
	            DogHascode doghc = (DogHascode) obj;
	            if (this.name.equals(doghc.getName()) && this.number.equals(doghc.getNumber())) {
	                return true;
	            } else {
	                return false;
	            }
	        } else {
	            return false;
	        }
	    }
	
	  public static void main(String[] args) {
	        Set<DogHascode> set = new HashSet<DogHascode>();
	        DogHascode doghc = new DogHascode("AA", "123456");
	        set.add(doghc);
	        set.add(new DogHascode("AA", "999999"));
	        set.add(new DogHascode("BB", "123456"));
	        set.add(new DogHascode("AA", "123456"));


	        Iterator<DogHascode> iterator = set.iterator();
	        while (iterator.hasNext()) {
	            System.out.println(iterator.next());
	        }
	
	
	
	
	  }}

