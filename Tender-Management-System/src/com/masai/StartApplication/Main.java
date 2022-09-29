package com.masai.StartApplication;

import com.masai.usecases.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {

            Scanner scanner=new Scanner(System.in);
            System.out.println("Create an account the Enter : 1 .");
            System.out.println("Deposit amount using account number : 2 .");
            System.out.println("Deposit amount using ATM Card : 3 .");
            System.out.println("Withdraw amount using account number : 4 .");
            System.out.println("Withdraw amount using ATM Card : 5 .");
            System.out.println("Check current balance : 6 .");
            System.out.println("Close account : 7 .");
            int userInput=scanner.nextInt();

            switch (userInput){
                case 1:
                    new CreateBankAccount().customerCreateBankAccount();
                    break;

                case 2:
                    new GetCustomerInformation().customerGetCustomerInformation();
                    break;

                case 3:
                    new DepositMoney().customerDepositMoney();
                    break;

                case 4:
                    new WithdrawMoneyByAccountNumber().customerWithdrawMoney();
                    break;

                case 5:
                    new WithdrawMoneyByDebitCard().customerWithdrawMoneyByDebitCard();
                    break;

                case 6:
                    new CurrentBalance().customerCurrentBalance();
                    break;

                case 7:
                    new CloseAccount().customerCloseAccount();
                    break;

                default:
                    System.out.println("Wrong Input");
                    break;
            }
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }

    }
}
