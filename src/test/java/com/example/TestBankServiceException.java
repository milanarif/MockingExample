package com.example;

public class TestBankServiceException implements BankService {

   @Override
   public void pay(String id, double amount){
      throw new RuntimeException();
   }
}
