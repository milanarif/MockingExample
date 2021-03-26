package com.example;

import ass3.EmployeeRepo;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class EmployeeManagerIT {

   EmployeeRepo repo = new EmployeeRepo();
   BankService service = mock(BankService.class);
   EmployeeManager manager = new EmployeeManager(repo, service);

   @Test
   void addFindAndPayEmployee(){
      Employee e = new Employee("one", 100);
      repo.save(e);

      int employeesPaid = manager.payEmployees();

      assertThat(employeesPaid).isEqualTo(1);
   }
}
