package first;

import java.util.HashMap;
import java.util.Map;

public class MapHashMapSimpleDome {
	
	public static void main(String[] args) {
		Map<String,String> map=new HashMap<>();
	    map.put("CN","�л����񹲺͹�");
	    map.put("US","��������ڹ�");
	    map.put("UK","���е߼�����������������");
	    map.put("FN","���������͹�");
	    
	    System.out.println(map.size());
	    
	    System.out.println(map.get("UK"));
	    
	    map.remove("FN");
	    System.out.println("������������"+map.containsKey("FN"));
	    
	    System.out.println(map.keySet());
	    System.out.println(map.values());
	    System.out.println(map);
	    
		
	}

}
