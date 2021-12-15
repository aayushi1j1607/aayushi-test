package com.employee.controller;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import com.employee.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
@Autowired
EmployeeService service;

    @GetMapping("/employees")
    public List<Employee> getAllEmployeeDetails(){
        return service.getAllEmployee();
    }

    @GetMapping(value="/employee/{id}")
    public Employee fetchEmployeeById(@PathVariable Integer id){
        return service.getEmployeeById(id);
    }

    @PostMapping(value="/adduser")
    public Employee addEmployee(@RequestBody Employee employee){
        return service.addEmployee(employee);
    }

    @PostMapping(value="/employees")
    public ResponseEntity<List<Employee>> addEmployee(@RequestBody List<Employee> employee){
        return (ResponseEntity<List<Employee>>) service.addEmployees(employee);
    }

    @PutMapping(value="/update-employee")
    public ResponseEntity<Employee> updateEmployeeDetails( @RequestBody Employee employee){
        return  ResponseEntity.ok(service.updateEmployeeDetails(employee));
    }

    @DeleteMapping(value="/delete-employee/{id}")
    public void deleteEmployee(@PathVariable Integer id){
        service.deleteEmployeeId(id);
    }
}
