package com.masai.dao;

import com.masai.bean.BankAccount;
import com.masai.exceptions.BankAccountException;


public interface BankManagementDao {

    public String createBankAccount(BankAccount bankAccount) throws BankAccountException;
    public BankAccount getAccountInformation(int userCustomerAccountNumber) throws BankAccountException;
    public String depositMoneyCustomerAccount(int userCustomerAccountNumber,int depositAmount) throws BankAccountException;
    public String withdrawMoneyCustomerAccount(int userCustomerAccountNumber,int withdrawAmount) throws BankAccountException;
    public String withdrawMonetByATM(String userDebitCard, int userATMPin, int withdrawAmount) throws BankAccountException;
    public String checkCurrentBalance(int userCustomerAccountNumber) throws BankAccountException;
    public String closeAccount(int userCustomerAccountNumber) throws BankAccountException;
}
