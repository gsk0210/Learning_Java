package com.knoldus.learning.controller;

import com.knoldus.learning.entity.Employee;
import com.knoldus.learning.service.SaveEmployeeService;
import com.knoldus.learning.service.SaveEnployeeServiceImpl;
import com.knoldus.learning.service.ValidateEmployeeService;
import com.knoldus.learning.service.ValidateEmployeeServiceImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeController {

    public static void main(String[] a){
        ValidateEmployeeService validateEmployeeService = new ValidateEmployeeServiceImpl();
        SaveEmployeeService saveEmployeeService = new SaveEnployeeServiceImpl();
        List<Employee> emplList = new ArrayList<>();


               //remove below for loop and
        // read data from employee.csv, csv have id, and name in each row.
        // focus on Functional Interface and mark them Functional if it is.
        // focus on Single responsibility principle.
        // -1,Jiten
        // 2,Ram

        String lineEnd;
        String spilit=",";

        try{
            BufferedReader bufferedReader=new BufferedReader(new FileReader("src/com/knoldus/learning/entity/Employee.csv"));
            while ((lineEnd=bufferedReader.readLine())!=null) {
                String[] employeeData = lineEnd.split(spilit);
                emplList.add(0,new Employee(Integer.parseInt(employeeData[0]),employeeData[1]));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }




        /*for(int i = -5;i<10;i++){
            Employee employee = new Employee(i,"Name"+i);
            emplList.add(employee);
        }*/
        System.out.println("Total employee size  :  "+emplList.size());
        //emplList iterate and call validate service, then save.
        for (Employee e : emplList) {
            if(validateEmployeeService.validateEmployee(e))
                saveEmployeeService.saveEmployee(e);
        }
        //Remove this error.
        System.out.println("Saved employee  : ");
        emplList.stream().sorted(Comparator.comparingInt(Employee::getId)).forEach(employee -> System.out.println(employee.getId()+" "+employee.getName()));
    }
}
