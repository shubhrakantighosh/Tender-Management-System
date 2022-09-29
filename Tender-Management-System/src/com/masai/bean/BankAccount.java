package com.masai.bean;

public class BankAccount {

    private int customerAccountNumber;
    private String customerName ;
    private int customerAccountBalance;
    private String customerAddress ;
    private String customerMobileNumber ;
    private String customerEmailID ;
    private String customerDebitCardNo;
    private int customerATMPin;
    private String branchifscCode;
    private String branchName;


    public int getCustomerAccountNumber() {
        return customerAccountNumber;
    }

    public void setCustomerAccountNumber(int customerAccountNumber) {
        this.customerAccountNumber = customerAccountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerAccountBalance() {
        return customerAccountBalance;
    }

    public void setCustomerAccountBalance(int customerAccountBalance) {
        this.customerAccountBalance = customerAccountBalance;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerMobileNumber() {
        return customerMobileNumber;
    }

    public void setCustomerMobileNumber(String customerMobileNumber) {
        this.customerMobileNumber = customerMobileNumber;
    }

    public String getCustomerEmailID() {
        return customerEmailID;
    }

    public void setCustomerEmailID(String customerEmailID) {
        this.customerEmailID = customerEmailID;
    }

    public String getCustomerDebitCardNo() {
        return customerDebitCardNo;
    }

    public void setCustomerDebitCardNo(String customerDebitCardNo) {
        this.customerDebitCardNo = customerDebitCardNo;
    }

    public int getCustomerATMPin() {
        return customerATMPin;
    }

    public void setCustomerATMPin(int customerATMPin) {
        this.customerATMPin = customerATMPin;
    }

    public String getBranchifscCode() {
        return branchifscCode;
    }

    public void setBranchifscCode(String branchifscCode) {
        this.branchifscCode = branchifscCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public BankAccount(int customerAccountNumber, String customerName, int customerAccountBalance, String customerAddress, String customerMobileNumber, String customerEmailID, String customerDebitCardNo, int customerATMPin, String branchifscCode, String branchName) {
        this.customerAccountNumber = customerAccountNumber;
        this.customerName = customerName;
        this.customerAccountBalance = customerAccountBalance;
        this.customerAddress = customerAddress;
        this.customerMobileNumber = customerMobileNumber;
        this.customerEmailID = customerEmailID;
        this.customerDebitCardNo = customerDebitCardNo;
        this.customerATMPin = customerATMPin;
        this.branchifscCode = branchifscCode;
        this.branchName = branchName;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "customerAccountNumber=" + customerAccountNumber +
                ", customerName='" + customerName + '\'' +
                ", customerAccountBalance=" + customerAccountBalance +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerMobileNumber='" + customerMobileNumber + '\'' +
                ", customerEmailID='" + customerEmailID + '\'' +
                ", customerDebitCardNo='" + customerDebitCardNo + '\'' +
                ", customerATMPin=" + customerATMPin +
                ", branchifscCode='" + branchifscCode + '\'' +
                ", branchName='" + branchName + '\'' +
                '}';
    }

    public BankAccount() {

    }
}
