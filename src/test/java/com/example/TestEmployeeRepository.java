package com.example;

import java.util.List;

public class TestEmployeeRepository implements EmployeeRepository {

   @Override
   public List<Employee> findAll() {
      return List.of(new Employee("firstInList", 2000), new Employee("secondInList", 3000));
   }

   @Override
   public Employee save(Employee e) {
      return null;
   }
}
