package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.AgeDistribution;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.entity.PositionStatistics;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private final EmployeeService employeeService;

	// Constructor injection of EmployeeService
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// Handler method to list employees with sorting options
	@GetMapping("/list")
	public String listEmployees(@RequestParam(required = false) String sortField,
								@RequestParam(required = false) String sortOrder,
								Model theModel) {

		List<Employee> theEmployees;

		// Default sorting by ID ascending if no parameters provided
		if (sortField == null) {
			theEmployees = employeeService.findAllSortedById(Sort.Direction.ASC);
		} else {
			// Determine sorting order (ascending or descending)
			Sort.Direction direction;
			if (sortOrder != null && sortOrder.equals("desc")) {
				direction = Sort.Direction.DESC;
			} else {
				direction = Sort.Direction.ASC;
			}

			// Sort based on the selected field
			switch (sortField) {
				case "id":
					theEmployees = employeeService.findAllSortedById(direction);
					break;
				case "firstName":
					theEmployees = employeeService.findAllSortedByFirstName(direction);
					break;
				case "lastName":
					theEmployees = employeeService.findAllSortedByLastName(direction);
					break;
				case "age":
					theEmployees = employeeService.findAllSortedByAge(direction);
					break;
				case "position":
					theEmployees = employeeService.findAllSortedByPosition(direction);
					break;
				default:
					// Default to sorting by ID if an invalid sort field is provided
					theEmployees = employeeService.findAllSortedById(Sort.Direction.ASC);
					break;
			}
		}

		// Add the list of employees to the model
		theModel.addAttribute("employees", theEmployees);

		// Retrieve and add position statistics to the model
		List<PositionStatistics> positionStatistics = employeeService.getPositionStatistics();
		theModel.addAttribute("positionStatistics", positionStatistics);

		// Retrieve and add age distribution statistics to the model
		List<AgeDistribution> ageDistribution = employeeService.getAgeDistribution();
		theModel.addAttribute("ageDistribution", ageDistribution);

		// Retrieve total number of employees and add it to the model
		long totalEmployeesCount = employeeService.getTotalEmployeesCount();
		theModel.addAttribute("totalEmployeesCount", totalEmployeesCount);

		// Return the view name for listing employees
		return "employees/list-employees";
	}

	// Handler method to show the form for adding a new employee
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// Create a new Employee object
		Employee theEmployee = new Employee();
		// Add the Employee object to the model
		theModel.addAttribute("employee", theEmployee);
		// Return the view name for the employee form
		return "employees/employee-form";
	}

	// Handler method to show the form for updating an existing employee
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
		// Retrieve the Employee object by ID
		Employee theEmployee = employeeService.findById(theId);
		// Add the Employee object to the model
		theModel.addAttribute("employee", theEmployee);
		// Return the view name for the employee form
		return "employees/employee-form";
	}

	// Handler method to delete an employee by ID
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		// Call the service method to delete the employee by ID
		employeeService.deleteById(theId);
		// Redirect to the list page after deletion
		return "redirect:/employees/list";
	}

	// Handler method to save or update an employee
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		// Call the service method to save or update the employee
		employeeService.save(theEmployee);
		// Redirect to the list page after saving or updating
		return "redirect:/employees/list";
	}
}