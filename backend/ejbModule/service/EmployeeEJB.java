package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.EmployeeEntity;

/**
 * Session Bean implementation class EmployeeEJB
 */
@Stateless
@LocalBean
public class EmployeeEJB {


	@PersistenceContext
	private EntityManager em;
	
	
    public EmployeeEJB() {
        // TODO Auto-generated constructor stub
    }
    
    public void addNew(Employeentity employeeEntity)
    {
    	System.out.println("============================");
    	System.out.println(employeeEntity.getName());
    	em.persist(employeeEntity);
    	System.out.println("============================");
    }

    public List<EmployeeEntity> viewAllEmployees()
    {
    	Query query = em.createQuery("select e from Employee e");
    	List <EmployeeEntity> results = query.getResultList();
    	    	
    	return results;
    }   	
}
