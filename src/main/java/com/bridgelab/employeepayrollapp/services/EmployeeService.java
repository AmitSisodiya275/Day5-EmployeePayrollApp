package com.bridgelab.employeepayrollapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelab.employeepayrollapp.model.Employee;
import com.bridgelab.employeepayrollapp.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private EmployeeRepository empRepository;

	@Override
	public List<Employee> getAllEmp() {
		List<Employee> empList = empRepository.findAll();
		return empList;
	}

	@Override
	public Employee getEmpById(int id) {
		Employee employee = empRepository.findById(id).orElse(null);
		return employee;
	}

	@Override
	public Employee save(Employee emp) {
		Employee employee = empRepository.save(emp);
		return employee;
	}

	@Override
	public Employee update(int id, Employee emp) {
		Optional<Employee> empOptional = empRepository.findById(id);
		if (empOptional.isPresent()) {
			Employee employee = empOptional.get();
			employee.setName(emp.getName());
			employee.setSalary(emp.getSalary());
			return empRepository.save(employee);
		}
		return null;
	}

	@Override
	public void deleteById(int id) {
		empRepository.deleteById(id);
	}
}
