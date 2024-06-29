package com.luv2code.springboot.thymeleafdemo.service;

import com.luv2code.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleafdemo.entity.AgeDistribution;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.entity.PositionStatistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Sort;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    void setUp() {
        // Initialize mocks before each test
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllSortedById() {
        // Prepare mock data
        Employee employee1 = new Employee(1, "John", "Doe", "Developer", 30);
        Employee employee2 = new Employee(2, "Jane", "Smith", "Manager", 40);
        List<Employee> employees = Arrays.asList(employee1, employee2);

        // Define behavior for mocked repository
        when(employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "id"))).thenReturn(employees);

        // Call the service method
        List<Employee> result = employeeService.findAllSortedById(Sort.Direction.ASC);

        // Verify the results
        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getFirstName());
        assertEquals("Jane", result.get(1).getFirstName());

        // Verify that the repository method was called once with the correct parameter
        verify(employeeRepository, times(1)).findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Test
    void testFindById() {
        // Prepare mock data
        Employee employee = new Employee(1, "John", "Doe", "Developer", 30);

        // Define behavior for mocked repository
        when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));

        // Call the service method
        Employee result = employeeService.findById(1);

        // Verify the results
        assertNotNull(result);
        assertEquals("John", result.getFirstName());

        // Verify that the repository method was called once with the correct parameter
        verify(employeeRepository, times(1)).findById(1);
    }

    @Test
    void testSave() {
        // Prepare mock data
        Employee employee = new Employee(1, "John", "Doe", "Developer", 30);

        // Call the service method
        employeeService.save(employee);

        // Verify that the repository method was called once with the correct parameter
        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    void testDeleteById() {
        // Call the service method
        employeeService.deleteById(1);

        // Verify that the repository method was called once with the correct parameter
        verify(employeeRepository, times(1)).deleteById(1);
    }

    @Test
    void testGetPositionStatistics() {
        // Prepare mock data
        Object[] position1 = new Object[]{"Developer", 10L, 30.0};
        Object[] position2 = new Object[]{"Manager", 5L, 40.0};
        List<Object[]> positionStats = Arrays.asList(position1, position2);

        // Define behavior for mocked repository
        when(employeeRepository.getPositionStatistics()).thenReturn(positionStats);

        // Call the service method
        List<PositionStatistics> result = employeeService.getPositionStatistics();

        // Verify the results
        assertEquals(2, result.size());
        assertEquals("Developer", result.get(0).getPosition());
        assertEquals(10L, result.get(0).getCount());
        assertEquals(30, result.get(0).getAverageAge()); // Expecting integer values

        // Verify that the repository method was called once
        verify(employeeRepository, times(1)).getPositionStatistics();
    }

    @Test
    void testGetAgeDistribution() {
        // Define behavior for mocked repository
        when(employeeRepository.countEmployeesUnder20()).thenReturn(3L);
        when(employeeRepository.countEmployees20To40()).thenReturn(10L);
        when(employeeRepository.countEmployees40To60()).thenReturn(7L);
        when(employeeRepository.countEmployees60Plus()).thenReturn(2L);

        // Call the service method
        List<AgeDistribution> result = employeeService.getAgeDistribution();

        // Verify the results
        assertEquals(4, result.size());
        assertEquals("<20", result.get(0).getAgeGroup());
        assertEquals(3L, result.get(0).getCount());

        // Verify that the repository methods were called the correct number of times
        verify(employeeRepository, times(1)).countEmployeesUnder20();
        verify(employeeRepository, times(1)).countEmployees20To40();
        verify(employeeRepository, times(1)).countEmployees40To60();
        verify(employeeRepository, times(1)).countEmployees60Plus();
    }
}
