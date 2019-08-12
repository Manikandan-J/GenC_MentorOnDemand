package com.javasampleapproach.springrest.mysql.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.springrest.mysql.model.Employee;

import com.javasampleapproach.springrest.mysql.repo.EmployeeRepository;
import org.springframework.http.MediaType;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/api", produces = { MediaType.APPLICATION_JSON_VALUE})
public class EmployeeController {

	@Autowired
	EmployeeRepository repository;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		System.out.println("Get all Employees...");

		List<Employee> Employees = new ArrayList<>();
		repository.findAll().forEach(Employees::add);

		return Employees;
	}

	@PostMapping(value = "/employees/create")
	public Employee postEmployee(@RequestBody Employee Employee) {

		Employee _Employee = repository.save(new Employee(0, Employee.getName(), Employee.getAge(), false));
		return _Employee;
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
		System.out.println("Delete Employee with ID = " + id + "...");

		repository.deleteById(id);

		return new ResponseEntity<>("Employee has been deleted!", HttpStatus.OK);
	}

	@DeleteMapping("/employees/delete")
	public ResponseEntity<String> deleteAllEmployees() {
		System.out.println("Delete All Employees...");

		repository.deleteAll();

		return new ResponseEntity<>("All Employees have been deleted!", HttpStatus.OK);
	}

	@GetMapping(value = "employees/age/{age}")
	public List<Employee> findByAge(@PathVariable int age) {

		List<Employee> Employees = repository.findByAge(age);
		return Employees;
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee Employee) {
		System.out.println("Update Employee with ID = " + id + "...");

		Optional<Employee> EmployeeData = repository.findById(id);

		if (EmployeeData.isPresent()) {
			Employee Employee1 = EmployeeData.get();
			Employee1.setName(Employee1.getName());
			Employee1.setAge(Employee1.getAge());
			Employee1.setActive(Employee1.isActive());
			return new ResponseEntity<>(repository.save(Employee1), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
