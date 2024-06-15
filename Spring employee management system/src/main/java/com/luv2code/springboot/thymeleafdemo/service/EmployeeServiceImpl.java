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

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	// Constructor injection of EmployeeRepository
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	// Retrieve all employees sorted by ID in the specified direction
	@Override
	public List<Employee> findAllSortedById(Sort.Direction direction) {
		return employeeRepository.findAll(Sort.by(direction, "id"));
	}

	// Retrieve all employees sorted by first name in the specified direction
	@Override
	public List<Employee> findAllSortedByFirstName(Sort.Direction direction) {
		return employeeRepository.findAll(Sort.by(direction, "firstName"));
	}

	// Retrieve all employees sorted by last name in the specified direction
	@Override
	public List<Employee> findAllSortedByLastName(Sort.Direction direction) {
		return employeeRepository.findAll(Sort.by(direction, "lastName"));
	}

	// Retrieve all employees sorted by age in the specified direction
	@Override
	public List<Employee> findAllSortedByAge(Sort.Direction direction) {
		return employeeRepository.findAll(Sort.by(direction, "age"));
	}

	// Retrieve all employees sorted by position in the specified direction
	@Override
	public List<Employee> findAllSortedByPosition(Sort.Direction direction) {
		return employeeRepository.findAll(Sort.by(direction, "position"));
	}

	// Find an employee by their ID
	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		return result.orElseThrow(() -> new RuntimeException("Employee not found with id: " + theId));
	}

	// Save or update an employee
	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	// Delete an employee by their ID
	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

	// Get statistics about employees grouped by their position
	@Override
	public List<PositionStatistics> getPositionStatistics() {
		List<PositionStatistics> positionStatistics = new ArrayList<>();

		// Query repository to get position statistics
		List<Object[]> results = employeeRepository.getPositionStatistics();

		for (Object[] result : results) {
			String position = (String) result[0];
			Long employeeCount = (Long) result[1];
			Double averageAge = (Double) result[2]; // Ensure this matches your database schema for age calculation

			// Round average age to integer for presentation
			int roundedAverageAge = (int) Math.round(averageAge);

			positionStatistics.add(new PositionStatistics(position, employeeCount, roundedAverageAge));
		}

		return positionStatistics;
	}

	// Get distribution of employees by different age groups
	@Override
	public List<AgeDistribution> getAgeDistribution() {
		List<AgeDistribution> ageDistribution = new ArrayList<>();

		// Retrieve counts from repository for different age groups
		Long countUnder20 = employeeRepository.countEmployeesUnder20();
		Long count20To40 = employeeRepository.countEmployees20To40();
		Long count40To60 = employeeRepository.countEmployees40To60();
		Long count60Plus = employeeRepository.countEmployees60Plus();

		ageDistribution.add(new AgeDistribution("<20", countUnder20));
		ageDistribution.add(new AgeDistribution("20-40", count20To40));
		ageDistribution.add(new AgeDistribution("40-60", count40To60));
		ageDistribution.add(new AgeDistribution("60+", count60Plus));

		return ageDistribution;
	}

	// Get total count of employees
	@Override
	public long getTotalEmployeesCount() {
		return employeeRepository.count();
	}
}
