package springExample;

		// TODO Auto-generated method stub
		import org.springframework.beans.factory.BeanFactory;  
		import org.springframework.beans.factory.xml.XmlBeanFactory;  
		import org.springframework.core.io.ClassPathResource;  
		import org.springframework.core.io.Resource;  
class Driver{
		public static void main(String[] args) {  
		      
			BeanFactory beans=new XmlBeanFactory(new ClassPathResource("/spring.xml"));
		      
		    EmployeeDao dao=(EmployeeDao)beans.getBean("d");  
		      
		    EmployeeBean e=new EmployeeBean();  
		    e.setEid(8);  
		    e.setEname("varun");  
		    e.setEsalary(50000); 
		    e.setEadd("tanuku");
		      
		    dao.saveEmployee(e);  
		      
		}  
		}  


