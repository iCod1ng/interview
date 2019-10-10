package oop.company;

import java.util.List;

/**
 * @author yanyuchi
 * @date 2019-05-18 17:24
 */
public class Employee {

    public static List<Employee> allEmployees;

    private final String name;

    private final int salary;

    public Employee(String name,int salary){
        this.name = name;
        this.salary = salary;
    }

}
