package com.bridgelab.employeepayrollapp.convertor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.bridgelab.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelab.employeepayrollapp.dto.ResponseEmpDTO;
import com.bridgelab.employeepayrollapp.model.Employee;

@Component
public class EntityToDTOConvertor {

	public Employee dtoToEntity(EmployeeDTO dto) {
		Employee emp = new Employee();
		emp.setName(dto.getName());
		emp.setSalary(dto.getSalary());
		return emp;
	}

	public ResponseEmpDTO entityToResponseDTO(Employee emp) {
		ResponseEmpDTO responseDTO = new ResponseEmpDTO();
		responseDTO.setId(emp.getId());
		responseDTO.setName(emp.getName());
		responseDTO.setSalary(emp.getSalary());
		return responseDTO;
	}

	public List<Employee> dtoListToEntityList(List<EmployeeDTO> dto) {
		return dto.stream().map(dtoObject -> dtoToEntity(dtoObject)).collect(Collectors.toList());
	}

	public List<ResponseEmpDTO> entityListToDTOList(List<Employee> empList) {
		return empList.stream().map(empObject -> entityToResponseDTO(empObject)).collect(Collectors.toList());
	}
}
