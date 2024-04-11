package com.example.StudentMarks.domain;

import org.apache.catalina.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class EmployeeTest {

    @Test
    void getNameTest(){
        Employee a = new Employee("Jan", 20, "Manager");
        Assertions.assertEquals("Jan", a.getName());
    }
}