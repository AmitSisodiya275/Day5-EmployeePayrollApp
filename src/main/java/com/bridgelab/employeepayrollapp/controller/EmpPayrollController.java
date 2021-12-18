package com.bridgelab.employeepayrollapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelab.employeepayrollapp.model.Employee;
import com.bridgelab.employeepayrollapp.services.IEmployeeService;

@RestController
@RequestMapping("/emppayroll")
public class EmpPayrollController {

	@Autowired
	private IEmployeeService empService;

	@GetMapping(value = { "", "/", "/get" })
	public List<Employee> getAll() {
		return empService.getAllEmp();
	}

	@GetMapping("/get/{eId}")
	public Employee getEmpById(@PathVariable("eId") int id) {
		return empService.getEmpById(id);
	}
	
	@PostMapping("/add")
	public Employee addEmp(@RequestBody Employee emp) {
		return empService.save(emp);
	}
	
	@PutMapping("/update/{eId}")
	public Employee updateEmp(@PathVariable("eId") int id, @RequestBody Employee emp) {
		return empService.update(id, emp);
	}
	
	@DeleteMapping("/delete/{eId}")
	public void deleteEmp(@PathVariable("eId") int id) {
		empService.deleteById(id);
	}
}
