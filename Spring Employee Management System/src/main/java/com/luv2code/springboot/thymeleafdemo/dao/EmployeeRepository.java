package com.luv2code.springboot.thymeleafdemo.dao;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Custom query to retrieve position statistics including employee count and average age
    @Query("SELECT e.position, COUNT(e) AS employeeCount, AVG(e.age) AS averageAge " +
            "FROM Employee e GROUP BY e.position ORDER BY employeeCount DESC")
    List<Object[]> getPositionStatistics();

    // Method to count employees whose age is less than the given age
    Long countEmployeesByAgeLessThan(int age);

    // Method to count employees whose age is between the given start and end ages (inclusive)
    Long countEmployeesByAgeBetween(int start, int end);

    // Method to count employees whose age is greater than or equal to the given age
    Long countEmployeesByAgeGreaterThanEqual(int age);
}
