package com.knoldus.learning.service;

import com.knoldus.learning.entity.Employee;

@FunctionalInterface
public interface SaveEmployeeService {
    void saveEmployee(Employee employee);

}
