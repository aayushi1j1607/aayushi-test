package com.employee;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeApplicationTests {
	@Autowired
	EmployeeService service;
	@MockBean
	EmployeeRepository employeeRepository;

	@Test
	public void getAllEmployeeTest(){
		when(employeeRepository.findAll()).thenReturn(Stream
				.of(new Employee(11, "james") ,new Employee(10, "priya"))
				.collect(Collectors.toList()));
		assertEquals(2, service.getAllEmployee().size());
	}

	@Test
	public void addEmployeeTest(){
		Employee employee= new Employee(8 , "Raman");
		when(employeeRepository.save(employee)).thenReturn(employee);
		assertEquals(employee , service.addEmployee(employee));
	}

//	@Test
//	public void deleteEmployeeTest(){
//		Integer employeeId= 8;
//		service.deleteEmployeeId(employeeId);
//		verify(employeeRepository,times(1)).deleteById(employeeId);
//	}
}
