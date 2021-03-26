package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestEmployeeManager {
   TestEmployeeRepository er = new TestEmployeeRepository();

   @Test
   void integrationTestNumberPayed() {
      TestBankService bs = new TestBankService();
      EmployeeManager em = new EmployeeManager(er, bs);

      int expectedResult = 2;
      int actualResult = em.payEmployees();

      assertThat(actualResult).isEqualTo(expectedResult);
   }

   @Test
   void integrationTestExceptionDueToPaidFalse(){
      TestBankServiceException bsf = new TestBankServiceException();
      EmployeeManager em = new EmployeeManager(er, bsf);
      int expectedResult = 0;

      int actualResult = em.payEmployees();

      assertThat(actualResult).isEqualTo(expectedResult);
   }
}
