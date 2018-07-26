import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsontoJava {
public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
	ObjectMapper om=new ObjectMapper();
	User u=om.readValue(new File("A://javaP/Webservices/Restful/JavatoJson/user.json"), User.class);
	System.out.println(u.getUid()+"  "+u.getName()+"  "+u.getAddress());
}
}
