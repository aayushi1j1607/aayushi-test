package com.employee.service;

import ch.qos.logback.core.CoreConstants;
import com.employee.exception.EmployeeNotFoundException;
import com.employee.repository.EmployeeRepository;
import com.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements  EmployeeService{
    @Autowired
   private EmployeeRepository employeeRepo;

    @Override
    public Employee addEmployee(Employee employee)
    {
            return employeeRepo.save(employee);

    }

    @Override
    public List<Employee> addEmployees(List<Employee> employee)
    {
        return employeeRepo.saveAll(employee) ;
    }

    @Override
    public Employee getEmployeeById(Integer employeeId)
    {
        return employeeRepo.findById(employeeId).orElseThrow(() ->
                new EmployeeNotFoundException("Employee not Found with id =" + employeeId));
    }

    @Override
    public List<Employee> getAllEmployee()
    {
        List<Employee> empList=employeeRepo.findAll();
        if(!empList.isEmpty()){
            System.out.println("Getting data from Db :" + empList);
            return empList;
        }
        else{
            throw new EmployeeNotFoundException("No record Found");
        }
    }

    @Override
    public Employee updateEmployeeDetails(Employee entity) {
     return employeeRepo.save(entity);
    }

    @Override
    public void deleteEmployeeId(Integer id){
        Employee existingEmployee=employeeRepo.findById(id).orElseThrow(()->
                new EmployeeNotFoundException("employee not found with id:"+ id));
        this.employeeRepo.deleteById(id);

    }
}
