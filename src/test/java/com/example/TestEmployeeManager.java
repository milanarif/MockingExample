package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.*;

public class TestEmployeeManager {


   @Test
   void integrationTestNumberPayed() {
      EmployeeRepository mockedRepo = mock(EmployeeRepository.class);
      when(mockedRepo.findAll()).thenReturn(List.of(new Employee("1", 2000), new Employee( "2", 3000)));
      BankService mockedBankService = mock(BankService.class);
      EmployeeManager em = new EmployeeManager(mockedRepo, mockedBankService);
      int expectedResult = 2;
      int actualResult = em.payEmployees();

      assertThat(actualResult).isEqualTo(expectedResult);
   }

   @Test()
   void integrationTestExceptionDueToPaidFalse(){
      TestEmployeeRepository employeeRepository = new TestEmployeeRepository();
      TestBankServiceException bankService = new TestBankServiceException();
      EmployeeManager em = new EmployeeManager(employeeRepository, bankService);
      int expectedResult = 0;

      int actualResult = em.payEmployees();

      assertThat(actualResult).isEqualTo(expectedResult);
   }
}
