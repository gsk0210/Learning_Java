package com.knoldus.learning.service;

import com.knoldus.learning.entity.Employee;

@FunctionalInterface
public interface ValidateEmployeeService {
    boolean validateEmployee(Employee e);
}
