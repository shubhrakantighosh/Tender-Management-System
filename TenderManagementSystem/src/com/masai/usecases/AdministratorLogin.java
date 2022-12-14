package com.masai.usecases;

import com.masai.bean.Administrator;
import com.masai.dao.TenderManagementDaoImpl;
import com.masai.exceptions.TenderManagementException;

import java.util.Scanner;

public class AdministratorLogin {
    public boolean adminLogIn() {

        try {

            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter Username : ");
            String userName=scanner.next();
            System.out.println("Enter Password : ");
            String password=scanner.next();

            Administrator administrator=new Administrator(userName,password);

            String message=new TenderManagementDaoImpl().administratorLogIn(administrator);
            System.out.println(message);

            if (message.equalsIgnoreCase("Login Successfully")){
                return true;
            }

        } catch (TenderManagementException e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}
