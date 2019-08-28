package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import model.Employee;
import service.EmployeeEJB;


@ManagedBean(name = "employeecontroller")
@SessionScoped
public class EmployeeController{
 
    
  //from form
  	@ManagedProperty(value="#{employee}")
   
  	private EmployeeEJB empejb;
    private List<Employee> employeeList = new ArrayList<>();
 
   public List<Employee> getEmployeeList() {
       employeeList = empejb.viewAllEmployees();
	   return employeeList;
    }
 
   public String viewEmployee(){
       return "employeeList.xhtml";
    }
   
    public String addNewEmployee() {
         employeeEJB.addNew(employee.getEntity());
         employeeList = empejb.viewAllEmployees();
        return "employeeList.xhtml";
    }

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}