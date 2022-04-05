package com.miit.hibernateTraining;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.miit.hibernateTraining.util.HibernateUtil;

public class TestOneToMany {
	
	public static void main(String[] args) {

		try{
			SessionFactory sf = HibernateUtil.buildSessionFactory("hibernate-one-to-many.cfg.xml");
	        Session session = sf.openSession();
	         
	        DepartmentOneToMany department = new DepartmentOneToMany();
	        department.setDepartmentName("Sales");
	        session.beginTransaction();
	        EmployeeOneToMany emp1 = new EmployeeOneToMany("Nina", "Mayers", "111");
	        EmployeeOneToMany emp2 = new EmployeeOneToMany("Tony", "Almeida", "222");
	        Set<EmployeeOneToMany> employeeOneToManies = new HashSet<EmployeeOneToMany>();
	        employeeOneToManies.add(emp1);
	        employeeOneToManies.add(emp2);
	        department.setEmployees(employeeOneToManies);
	        session.save(department);
	        session.getTransaction().commit();
	        //for(MAP.entry<String,String> entry : map.entry)
	        
	        /*DepartmentOneToMany department = new DepartmentOneToMany();
	        department.setDepartmentName("Sales");
	        session.save(department);
	        EmployeeOneToMany emp1 = new EmployeeOneToMany("Nina", "Mayers", "111");
	        //EmployeeOneToMany emp2 = new EmployeeOneToMany("Tony", "Almeida", "222");
	        emp1.setDepartment(department);
	        //department.setEmployees(employeeOneToManies);
	        session.save(emp1);
	 */
	   
	        /*DepartmentOneToMany department = new DepartmentOneToMany();
	        department.setDepartmentName("Sales");
	        session.save(department);
	        EmployeeOneToMany emp1 = new EmployeeOneToMany("Nina", "Mayers", "111");
	        EmployeeOneToMany emp2 = new EmployeeOneToMany("Tony", "Almeida", "222");
	        emp1.setDepartment(department);
	        emp2.setDepartment(department);
	        session.save(emp1);
	        session.save(emp2);*/
	        //session.flush();
	        session.close(); 
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}


}
