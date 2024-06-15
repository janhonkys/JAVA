package com.luv2code.springboot.thymeleafdemo.entity;

// Class representing statistics related to an employee's position
public class PositionStatistics {

    // Job position or title of the employee
    private String position;

    // Number of employees in this position
    private long count;

    // Average age of employees in this position, changed to int for simplicity
    private int averageAge;

    // Constructor to initialize the PositionStatistics object with specific attributes
    public PositionStatistics(String position, long count, int averageAge) { // Changed averageAge type to int
        this.position = position;
        this.count = count;
        this.averageAge = averageAge;
    }

    // Getter for the position
    public String getPosition() {
        return position;
    }

    // Setter for the position
    public void setPosition(String position) {
        this.position = position;
    }

    // Getter for the count of employees
    public long getCount() {
        return count;
    }

    // Setter for the count of employees
    public void setCount(long count) {
        this.count = count;
    }

    // Getter for the average age of employees, changed return type to int
    public int getAverageAge() {
        return averageAge;
    }

    // Setter for the average age of employees, changed parameter type to int
    public void setAverageAge(int averageAge) {
        this.averageAge = averageAge;
    }

    // Override toString method to provide a string representation of PositionStatistics object
    @Override
    public String toString() {
        return "PositionStatistics{" +
                "position='" + position + '\'' +
                ", count=" + count +
                ", averageAge=" + averageAge +
                '}';
    }
}
