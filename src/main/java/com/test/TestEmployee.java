package com.test;

import java.util.Scanner;

import com.pojo.Address;
import com.pojo.ContractEmp;
import com.pojo.Department;
import com.pojo.PermanentEmp;
import com.service.EmployeeService;

public class TestEmployee {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
        EmployeeService dao = new EmployeeService();

        int ch;

        do {

            System.out.println("\n========== Employee Management System ==========");
            System.out.println("1. Add Permanent Employee");
            System.out.println("2. Add Contract Employee");
            System.out.println("3. View Employees");
            System.out.println("4. Update Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            
            System.out.print("Enter your choice: ");

            ch = sc.nextInt();

            switch (ch) {

            case 1:

                sc.nextLine();

                PermanentEmp p = new PermanentEmp();

                System.out.print("Enter Name: ");
                p.setName(sc.nextLine());

                System.out.print("Enter Salary: ");
                p.setSalary(sc.nextDouble());

                System.out.print("Enter Bonus: ");
                p.setBonus(sc.nextDouble());

                sc.nextLine();

                System.out.print("Enter City: ");
                String city = sc.nextLine();

                System.out.print("Enter State: ");
                String state = sc.nextLine();

                System.out.print("Enter Pincode: ");
                String pin = sc.nextLine();

                Address address = new Address(city, state, pin);

                p.setAddr(address);

                Department dept = new Department();

                System.out.print("Enter Department Name: ");
                dept.setDept_name(sc.nextLine());

                p.setDept(dept);

                dao.addEmployee(p);

                System.out.println("Permanent Employee Added Successfully.");

                break;

            case 2:

                sc.nextLine();

                ContractEmp c = new ContractEmp();

                System.out.print("Enter Name: ");
                c.setName(sc.nextLine());

                System.out.print("Enter Salary: ");
                c.setSalary(sc.nextDouble());

                System.out.print("Enter Contract Months: ");
                c.setContractMonths(sc.nextInt());

                sc.nextLine();

                System.out.print("Enter City: ");
                city = sc.nextLine();

                System.out.print("Enter State: ");
                state = sc.nextLine();

                System.out.print("Enter Pincode: ");
                pin = sc.nextLine();

                address = new Address(city, state, pin);

                c.setAddr(address);

                dept = new Department();

                System.out.print("Enter Department Name: ");
                dept.setDept_name(sc.nextLine());

                c.setDept(dept);

                dao.addEmployee(c);

                System.out.println("Contract Employee Added Successfully.");

                break;

            case 3:

                dao.viewEmployee();

                break;

            case 4:

                System.out.print("Enter Employee ID: ");
                int id = sc.nextInt();

                System.out.print("Enter New Salary: ");
                double salary = sc.nextDouble();

                dao.updateSalary(id, salary);

                break;

            case 5:

                System.out.print("Enter Employee ID: ");
                id = sc.nextInt();

                dao.deleteEmployee(id);

                break;

            case 6:

                System.out.println("Thank You!");
                break;

            default:

                System.out.println("Invalid Choice!");

            }

        } while (ch != 6);

        sc.close();

	}

}
