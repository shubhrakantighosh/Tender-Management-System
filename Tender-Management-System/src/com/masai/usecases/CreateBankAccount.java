package com.masai.usecases;

import com.masai.bean.BankAccount;
import com.masai.dao.BankManagementDaoImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class CreateBankAccount {
    public void customerCreateBankAccount () {

        try {

            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter Your Customer Account Number : ");
            int customerAccountNumber=scanner.nextInt();
            System.out.println("Enter Your Customer Name  : ");
            scanner.next();
            String customerName=scanner.nextLine();
            System.out.println("Enter Customer Account Balance");
            int customerAccountBalance=scanner.nextInt();
            System.out.println("Enter Customer Address  : ");
            String customerAddress=scanner.next();
            System.out.println("Enter Customer Mobile Number : ");
            String customerMobileNumber=scanner.next();
            System.out.println("Enter Customer EmailID  : ");
            String customerEmailID=scanner.next();
            System.out.println("Enter Customer Debit Card No : ");
            String customerDebitCardNo=scanner.next();
            System.out.println("Enter Customer ATM Pin : ");
            int customerATMPin=scanner.nextInt();
            System.out.println("Enter Branch ifsc Code  : ");
            String branchifscCode=scanner.next();
            System.out.println("Enter Branch Name : ");
            String branchName=scanner.next();

            BankAccount bankAccount=new BankAccount(customerAccountNumber,customerName,customerAccountBalance,customerAddress,customerMobileNumber,customerEmailID,customerDebitCardNo,customerATMPin,branchifscCode,branchName);

            String message=new BankManagementDaoImpl().createBankAccount(bankAccount);

            System.out.println(message);

        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}
