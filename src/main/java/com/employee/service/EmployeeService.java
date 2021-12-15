package com.employee.service;

import com.employee.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public abstract Employee addEmployee(Employee employee);

    public abstract List<Employee> addEmployees(List<Employee> employee);

    public abstract Employee updateEmployeeDetails(Employee entity);

    public abstract Employee getEmployeeById(Integer employeeId);

    public abstract List<Employee> getAllEmployee();

    public abstract void deleteEmployeeId(Integer id);

}
