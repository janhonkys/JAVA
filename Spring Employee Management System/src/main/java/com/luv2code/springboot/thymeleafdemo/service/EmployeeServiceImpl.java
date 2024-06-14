package com.luv2code.springboot.thymeleafdemo.service;

import com.luv2code.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleafdemo.entity.AgeDistribution;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.entity.PositionStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Service implementation for managing Employee-related operations
@Service
public class EmployeeServiceImpl implements EmployeeService {

	// Repository for interacting with the database
	private final EmployeeRepository employeeRepository;

	// Constructor for dependency injection of the EmployeeRepository
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	// Retrieve all employees sorted by their ID in the specified direction (ascending or descending)
	@Override
	public List<Employee> findAllSortedById(Sort.Direction direction) {
		return employeeRepository.findAll(Sort.by(direction, "id"));
	}

	// Retrieve all employees sorted by their first name in the specified direction (ascending or descending)
	@Override
	public List<Employee> findAllSortedByFirstName(Sort.Direction direction) {
		return employeeRepository.findAll(Sort.by(direction, "firstName"));
	}

	// Retrieve all employees sorted by their last name in the specified direction (ascending or descending)
	@Override
	public List<Employee> findAllSortedByLastName(Sort.Direction direction) {
		return employeeRepository.findAll(Sort.by(direction, "lastName"));
	}

	// Retrieve all employees sorted by their age in the specified direction (ascending or descending)
	@Override
	public List<Employee> findAllSortedByAge(Sort.Direction direction) {
		return employeeRepository.findAll(Sort.by(direction, "age"));
	}

	// Retrieve all employees sorted by their position in the specified direction (ascending or descending)
	@Override
	public List<Employee> findAllSortedByPosition(Sort.Direction direction) {
		return employeeRepository.findAll(Sort.by(direction, "position"));
	}

	// Find an employee by their ID, or throw an exception if not found
	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		return result.orElseThrow(() -> new RuntimeException("Did not find employee id - " + theId));
	}

	// Save or update an employee's details in the database
	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	// Delete an employee by their ID
	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

	// Get statistics about employees grouped by their position, including count and average age
	@Override
	public List<PositionStatistics> getPositionStatistics() {
		List<PositionStatistics> positionStatistics = new ArrayList<>();

		// Query database to get count of employees and average age per position
		List<Object[]> results = employeeRepository.getPositionStatistics();

		for (Object[] result : results) {
			String position = (String) result[0];
			Long count = (Long) result[1];
			double averageAge = (Double) result[2];

			// Convert the average age to an integer for rounding purposes
			int roundedAverageAge = (int) Math.round(averageAge);

			positionStatistics.add(new PositionStatistics(position, count, roundedAverageAge));
		}

		return positionStatistics;
	}

	// Get distribution of employees by different age groups
	@Override
	public List<AgeDistribution> getAgeDistribution() {
		List<AgeDistribution> ageDistribution = new ArrayList<>();

		// Query database to get count of employees in different age groups
		Long countUnder20 = employeeRepository.countEmployeesByAgeLessThan(20);
		Long count20to40 = employeeRepository.countEmployeesByAgeBetween(20, 40);
		Long count40to60 = employeeRepository.countEmployeesByAgeBetween(40, 60);
		Long countAbove60 = employeeRepository.countEmployeesByAgeGreaterThanEqual(60);

		// Create AgeDistribution objects for each age group and add them to the list
		ageDistribution.add(new AgeDistribution("<20", countUnder20));
		ageDistribution.add(new AgeDistribution("20-40", count20to40));
		ageDistribution.add(new AgeDistribution("40-60", count40to60));
		ageDistribution.add(new AgeDistribution("60+", countAbove60));

		return ageDistribution;
	}
}
