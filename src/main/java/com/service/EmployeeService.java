package com.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.pojo.ContractEmp;
import com.pojo.Employee;
import com.pojo.PermanentEmp;
import com.util.HibernateUtil;

public class EmployeeService {
	
	public void addEmployee(Employee emp){

	    SessionFactory sf=HibernateUtil.getSessionFactory();
	    Session s=sf.getCurrentSession();
	    Transaction tx=s.beginTransaction();
	    
	    try {
	    	s.persist(emp);
		    tx.commit();
		    System.out.println("Employee Added successfully!!");
	    }catch(Exception e) {
	    	tx.rollback();
	    	e.printStackTrace();
	    }
	    finally {
			s.close();
		}
	}
	
	public void viewEmployee() {

	    SessionFactory sf=HibernateUtil.getSessionFactory();
	    Session s=sf.getCurrentSession();
	    Transaction tx=s.beginTransaction();
	    
	    try {

            List<Employee> list = s.createQuery("from Employee", Employee.class).list();

            if (list.isEmpty()) {

                System.out.println("No Employee Records Found.");

            } else {

                System.out.println("\n========== Employee Details ==========");

                for (Employee emp : list) {

                    System.out.println("----------------------------------");
                    System.out.println("Employee ID : " + emp.getEmp_id());
                    System.out.println("Name        : " + emp.getName());
                    System.out.println("Salary      : " + emp.getSalary());

                    if (emp.getAddr() != null) {
                        System.out.println("City        : " + emp.getAddr().getCity());
                        System.out.println("State       : " + emp.getAddr().getState());
                        System.out.println("Pincode     : " + emp.getAddr().getPincode());
                    }

                    if (emp.getDept() != null) {
                        System.out.println("Department  : " + emp.getDept().getDept_name());
                    }

                    // Inheritance Mapping
                    if (emp instanceof PermanentEmp) {

                        PermanentEmp p = (PermanentEmp) emp;

                        System.out.println("Employee Type : Permanent");
                        System.out.println("Bonus         : " + p.getBonus());

                    } else if (emp instanceof ContractEmp) {

                        ContractEmp c = (ContractEmp) emp;

                        System.out.println("Employee Type : Contract");
                        System.out.println("Contract      : " + c.getContractMonths() + " Months");

                    }
                }
            }
        } 
	    catch (Exception e) {
            e.printStackTrace();
        } 
	    finally {
            s.close();
        }
	}
	
	public void updateSalary(int id, double salary) {
		
		SessionFactory sf=HibernateUtil.getSessionFactory();
	    Session s=sf.getCurrentSession();
	    Transaction tx=s.beginTransaction();
	    
	    try {
            Employee emp = s.get(Employee.class, id);

            if (emp != null) {
                emp.setSalary(salary);
                s.merge(emp);
                tx.commit();
                System.out.println("Salary Updated Successfully.");

            } else {
                System.out.println("Employee Not Found.");
            }
        }
	    catch (Exception e) {
            e.printStackTrace();
        } 
	    finally {
            s.close();
        }
	}
	
	public void deleteEmployee(int id) {
		
		SessionFactory sf=HibernateUtil.getSessionFactory();
	    Session s=sf.getCurrentSession();
	    Transaction tx=s.beginTransaction();
	    
		try {
            Employee emp = s.get(Employee.class, id);

            if (emp != null) {
                s.remove(emp);
                tx.commit();
                System.out.println("Employee Deleted Successfully.");

            } else {
                System.out.println("Employee Not Found.");
            }

        } 
		catch (Exception e) {
            e.printStackTrace();
        } 
	    finally {
            s.close();
        }
	}
}