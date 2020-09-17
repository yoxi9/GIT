package homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;	

public class SQSProperties {
	public static void main(String[] args) throws IOException {
	        Properties properties=new Properties();
	        properties.load(new FileInputStream(new File("f:/sqs/qqq.properties")));
	        String name=properties.getProperty("name");
	        System.out.println(name);

	        String id=properties.getProperty("id");
	        System.out.println(id);

	        String grade=properties.getProperty("grade");
	        System.out.println(grade);
	    }



	    

}
