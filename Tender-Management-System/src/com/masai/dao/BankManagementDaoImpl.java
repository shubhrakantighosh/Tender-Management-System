package com.masai.dao;

import com.masai.Utility.DBUtil;
import com.masai.bean.BankAccount;
import com.masai.exceptions.BankAccountException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankManagementDaoImpl implements BankManagementDao{

    @Override
    public String createBankAccount(BankAccount bankAccount) throws BankAccountException {
        String message="Failed to create Bank Account";

        try (Connection connection=new DBUtil().provideConnection()) {

            PreparedStatement preparedStatement =connection.prepareStatement("insert into Bankmanagementsystem values(?,?,?,?,?,?,?,?,?,?);");

            preparedStatement.setInt(1,bankAccount.getCustomerAccountNumber());
            preparedStatement.setString(2,bankAccount.getCustomerName());
            preparedStatement.setInt(3,bankAccount.getCustomerAccountBalance());
            preparedStatement.setString(4,bankAccount.getCustomerAddress());
            preparedStatement.setString(5,bankAccount.getCustomerMobileNumber());
            preparedStatement.setString(6,bankAccount.getCustomerEmailID());
            preparedStatement.setString(7,bankAccount.getCustomerDebitCardNo());
            preparedStatement.setInt(8,bankAccount.getCustomerATMPin());
            preparedStatement.setString(9,bankAccount.getBranchifscCode());
            preparedStatement.setString(10,bankAccount.getBranchName());

            if (preparedStatement.executeUpdate()>0)
                message="Account create successfully";

        }catch (SQLException sqlException){

        }

        return message;
    }
    @Override
    public BankAccount getAccountInformation(int userCustomerAccountNumber) throws BankAccountException {

        BankAccount bankAccount=null;

        try (Connection connection=new DBUtil().provideConnection()) {

            PreparedStatement preparedStatement=connection.prepareStatement("select * from BankManagementSystem where customerAccountNumber=? ;");
            preparedStatement.setInt(1,userCustomerAccountNumber);
            ResultSet resultSet=preparedStatement.executeQuery();

            if(resultSet.next()){

                int customerAccountNumber=resultSet.getInt("customerAccountNumber");
                String customerName=resultSet.getString("customerName");
                int customerAccountBalance=resultSet.getInt("customerAccountBalance");
                String customerAddress=resultSet.getString("customerAddress");
                String customerMobileNumber=resultSet.getString("customerMobileNumber");
                String customerEmailID=resultSet.getString("customerEmailID");
                String customerDebitCardNo=resultSet.getString("customerDebitCardNo");
                int customerATMPin=resultSet.getInt("customerATMPin");
                String branchifscCode=resultSet.getString("branchifscCode");
                String branchName=resultSet.getString("branchName");

                bankAccount=new BankAccount(customerAccountNumber,customerName,customerAccountBalance,customerAddress,customerMobileNumber,customerEmailID,customerDebitCardNo,customerATMPin,branchifscCode,branchName);

            }else
                throw new BankAccountException("Doesn't Exit Customer Or Wrong Customer Account Number : "+userCustomerAccountNumber+" .");

        }catch (SQLException sqlException){
            throw new BankAccountException(sqlException.getMessage());
        }

        return bankAccount;

    }

    @Override
    public String depositMoneyCustomerAccount(int userCustomerAccountNumber,int depositAmount) throws BankAccountException {
        String message="Wrong Account Number";

        try (Connection connection=new DBUtil().provideConnection()) {

            PreparedStatement preparedStatement=connection.prepareStatement("update BankManagementSystem set customerAccountBalance=customerAccountBalance+? where customerAccountNumber=?;");
            preparedStatement.setInt(1,depositAmount);
            preparedStatement.setInt(2,userCustomerAccountNumber);

            if (preparedStatement.executeUpdate()>0){
                message="Rs : "+depositAmount+" , deposited. account number : "+userCustomerAccountNumber+" .";
            }

        }catch (SQLException sqlException){
            throw new BankAccountException(sqlException.getMessage());
        }

        return message;
    }

    @Override
    public String withdrawMoneyCustomerAccount(int userCustomerAccountNumber, int withdrawAmount) throws BankAccountException {
        String message="Wrong Account Number or Closed";

        try (Connection connection=new DBUtil().provideConnection()) {

            PreparedStatement preparedStatement=connection.prepareStatement("update BankManagementSystem set customerAccountBalance=customerAccountBalance-? where customerAccountNumber=?;");
            preparedStatement.setInt(1,withdrawAmount);
            preparedStatement.setInt(2,userCustomerAccountNumber);

            if (preparedStatement.executeUpdate()>0){
                message="Rs : "+withdrawAmount+" , withdraw from account number : "+userCustomerAccountNumber +" .";
            }

        }catch (SQLException sqlException){
            throw new BankAccountException(sqlException.getMessage());
        }

        return message;
    }

    @Override
    public String withdrawMonetByATM(String userDebitCard, int userATMPin, int withdrawAmount) throws BankAccountException {

        String message="Wrong ATM Pin or Not Readable";

        try (Connection connection=new DBUtil().provideConnection()) {

            PreparedStatement preparedStatement=connection.prepareStatement("update BankManagementSystem set customerAccountBalance=customerAccountBalance-? where  customerDebitCardNo=? && customerATMPin=?;");
            preparedStatement.setInt(1,withdrawAmount);
            preparedStatement.setString(2,userDebitCard);
            preparedStatement.setInt(3,userATMPin);

            if (preparedStatement.executeUpdate()>0){
                message="Rs : "+withdrawAmount+" , withdraw from Debit Card : "+userDebitCard+" .";
            }

        }catch (SQLException sqlException){
            throw new BankAccountException(sqlException.getMessage());
        }

        return message;

    }

    @Override
    public String checkCurrentBalance(int userCustomerAccountNumber) throws BankAccountException {
        String message="Wrong Account Number";

        try (Connection connection=new DBUtil().provideConnection()) {

            PreparedStatement preparedStatement=connection.prepareStatement("select customerAccountBalance from BankManagementSystem where customerAccountNumber=? ;");
            preparedStatement.setInt(1,userCustomerAccountNumber);
            ResultSet resultSet=preparedStatement.executeQuery();

            if(resultSet.next()){

                message="Current balance is :"+resultSet.getInt("customerAccountBalance");

            }else
                throw new BankAccountException("Doesn't Exit Customer Or Wrong Customer Account Number : "+userCustomerAccountNumber+" .");

        }catch (SQLException sqlException){
            throw new BankAccountException(sqlException.getMessage());
        }

        return message;
    }

    @Override
    public String closeAccount(int userCustomerAccountNumber) throws BankAccountException {
        String message="Wrong Account Number or Already closed";

        try (Connection connection=new DBUtil().provideConnection()) {

            PreparedStatement preparedStatement=connection.prepareStatement("delete from BankManagementSystem where customerAccountNumber=?;");
            preparedStatement.setInt(1,userCustomerAccountNumber);

            if (preparedStatement.executeUpdate()>0){
                message="Account Closed "+userCustomerAccountNumber+" .";
            }

        }catch (SQLException sqlException){
            throw new BankAccountException(sqlException.getMessage());
        }

        return message;
    }
}
