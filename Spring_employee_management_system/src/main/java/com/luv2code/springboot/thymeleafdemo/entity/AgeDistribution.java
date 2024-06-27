package com.luv2code.springboot.thymeleafdemo.entity;

// Represents the distribution of employees by age group
public class AgeDistribution {

    // Age group description
    private String ageGroup;

    // Count of employees in this age group
    private long count;

    // Constructor to initialize AgeDistribution object with age group and count
    public AgeDistribution(String ageGroup, long count) {
        this.ageGroup = ageGroup;
        this.count = count;
    }

    // Getter for ageGroup
    public String getAgeGroup() {
        return ageGroup;
    }

    // Setter for ageGroup
    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    // Getter for count
    public long getCount() {
        return count;
    }

    // Setter for count
    public void setCount(long count) {
        this.count = count;
    }

    // Override toString method to provide a string representation of AgeDistribution object
    @Override
    public String toString() {
        return "AgeDistribution{" +
                "ageGroup='" + ageGroup + '\'' +
                ", count=" + count +
                '}';
    }
}
