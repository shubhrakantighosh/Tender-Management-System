package com.masai.usecases;

import com.masai.dao.BankManagementDaoImpl;
import com.masai.exceptions.BankAccountException;

import java.util.Scanner;

public class WithdrawMoneyByDebitCard {
    public void customerWithdrawMoneyByDebitCard(){
        try {

            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter Your Debit Card Number ");
            String userDebitCard=scanner.next();
            System.out.println("Enter the amount withdraw amount for "+userDebitCard+" this account number");
            int amount=scanner.nextInt();
            System.out.println("Enter ATM Pin : ");
            int pin=scanner.nextInt();

            String message=new BankManagementDaoImpl().withdrawMonetByATM(userDebitCard,pin,amount);
            System.out.println(message);

        } catch (BankAccountException e) {
            throw new RuntimeException(e);
        }
    }
}
