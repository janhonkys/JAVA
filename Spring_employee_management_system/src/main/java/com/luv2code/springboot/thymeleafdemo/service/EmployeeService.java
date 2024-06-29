package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import com.luv2code.springboot.thymeleafdemo.entity.AgeDistribution;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.entity.PositionStatistics;
import org.springframework.data.domain.Sort;

// Service interface for managing Employee-related operations
public interface EmployeeService {

	// Retrieve a list of all employees, sorted by their ID in the specified direction (ascending or descending)
	List<Employee> findAllSortedById(Sort.Direction direction);

	// Retrieve a list of all employees, sorted by their first name in the specified direction (ascending or descending)
	List<Employee> findAllSortedByFirstName(Sort.Direction direction);

	// Retrieve a list of all employees, sorted by their last name in the specified direction (ascending or descending)
	List<Employee> findAllSortedByLastName(Sort.Direction direction);

	// Retrieve a list of all employees, sorted by their age in the specified direction (ascending or descending)
	List<Employee> findAllSortedByAge(Sort.Direction direction);

	// Retrieve a list of all employees, sorted by their position in the specified direction (ascending or descending)
	List<Employee> findAllSortedByPosition(Sort.Direction direction);

	// Find a specific employee by their ID
	Employee findById(int theId);

	// Save or update an employee's details
	void save(Employee theEmployee);

	// Delete an employee by their ID
	void deleteById(int theId);

	// Get statistics about employees grouped by their position, including count and average age
	List<PositionStatistics> getPositionStatistics();

	// Get distribution of employees by different age groups
	List<AgeDistribution> getAgeDistribution();

	// Retrieve total number of employees
	long getTotalEmployeesCount();
}
