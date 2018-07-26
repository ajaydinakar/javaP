import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JavatoJason {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
User u=new User();
u.setUid(1);
u.setName("ajay");
u.setAddress("wichita");	
ObjectMapper om=new ObjectMapper();
String j=om.writeValueAsString(u);
System.out.println(j);
om.writeValue(new File("A://javaP/Webservices/Restful/JavatoJson/user.json"), u);
	}
}
