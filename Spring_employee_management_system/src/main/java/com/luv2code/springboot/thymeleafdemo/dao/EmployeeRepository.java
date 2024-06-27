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

    // Count employees whose age is less than 20
    @Query("SELECT COUNT(e) FROM Employee e WHERE e.age < 20")
    Long countEmployeesUnder20();

    // Count employees whose age is between 20 and 40 (inclusive)
    @Query("SELECT COUNT(e) FROM Employee e WHERE e.age BETWEEN 20 AND 40")
    Long countEmployees20To40();

    // Count employees whose age is between 40 and 60 (inclusive)
    @Query("SELECT COUNT(e) FROM Employee e WHERE e.age BETWEEN 40 AND 60")
    Long countEmployees40To60();

    // Count employees whose age is greater than 60
    @Query("SELECT COUNT(e) FROM Employee e WHERE e.age > 60")
    Long countEmployees60Plus();
}
