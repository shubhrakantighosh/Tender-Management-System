package com.masai.usecases;

import com.masai.dao.BankManagementDaoImpl;
import com.masai.exceptions.BankAccountException;

import java.util.Scanner;

public class DepositMoney {
    public void customerDepositMoney() {

        try {

            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter Your Customer Account Number ");
            int userCustomerAccountNumber=scanner.nextInt();
            System.out.println("Enter the amount what to deposit to your account "+userCustomerAccountNumber);
            int amount=scanner.nextInt();

            String message=new BankManagementDaoImpl().depositMoneyCustomerAccount(userCustomerAccountNumber,amount);
            System.out.println(message);

        } catch (BankAccountException e) {
            throw new RuntimeException(e);
        }
    }
}
