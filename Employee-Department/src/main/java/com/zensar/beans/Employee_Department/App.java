<<<<<<< HEAD
package com.zensar.beans.Employee_Department;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zensar.employee.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    	
    	Employee emp = (Employee)context.getBean("emp1",Employee.class);
    	System.out.println(emp);
    }
}
=======
package com.zensar.beans.Employee_Department;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zensar.employee.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    	
    	Employee emp = (Employee)context.getBean("emp1",Employee.class);
    	System.out.println(emp);
    }
}
>>>>>>> branch 'main' of https://github.com/srilaxmipillalamarri/java.git
