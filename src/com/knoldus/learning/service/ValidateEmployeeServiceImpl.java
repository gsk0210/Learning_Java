package com.knoldus.learning.service;

import com.knoldus.learning.entity.Employee;

public class ValidateEmployeeServiceImpl implements ValidateEmployeeService{
    @Override
    public boolean validateEmployee(Employee e) {
        if(e.getId() <=0){
            return false;
        }
        return e.getName() != null && !e.getName().isEmpty();
    }
}
