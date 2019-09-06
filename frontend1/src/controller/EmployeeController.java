package controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import model.Employee;
import service.EmployeeEJB;

@ManagedBean(name = "employeecontroller")
@SessionScoped
public class EmployeeController{
 
    @EJB
    private EmployeeEJB employeeEJB;
    
  //from form
  	@ManagedProperty(value="#{employee}")
    private Employee employee;
  	
    private List<Employee> employeeList = new ArrayList<>();
 
   public List<Employee> getEmployeeList() throws Exception {
       //employeeList = employeeEJB.findEmployees();
	   //employeeList = employeeEJB.ViewAllEmployees();

        return employeeList;
    }
 
   public EmployeeEJB getEmployeeEJB() {
	return employeeEJB;
}

public void setEmployeeEJB(EmployeeEJB employeeEJB) {
	this.employeeEJB = employeeEJB;
}

public void setEmployeeList(List<Employee> employeeList) {
	this.employeeList = employeeList;
}

public String viewEmployee(){
        return "employeeList.xhtml";
    }
   
    public String addNewEmployee() throws Exception {
    	System.out.println("after viewing...==================");
        employeeEJB.addNew(employee.getEntity());
        System.out.println("after viewing 2...==================");
        return "employeeList.xhtml";
    }

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}   
}