package Abnormal;

public class TestAgelnputException {
	
	public static void main(String[] args) {
        person per = new person();
        try{
            per.setAge(111);
        }catch (AgelnputException ag){
            ag.printStackTrace();
        }
    }

}
