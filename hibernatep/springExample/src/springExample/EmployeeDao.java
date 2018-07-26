package springExample;

import java.util.List;

public interface EmployeeDao {
	public void saveEmployee(EmployeeBean e);
	public void updateEmployee(EmployeeBean e);  
	public void deleteEmployee(EmployeeBean e);
	public EmployeeBean getById(int eid);
	public List<EmployeeBean> getEmployees();
}
